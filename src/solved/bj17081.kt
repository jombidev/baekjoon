interface Attackable {
    var health: Int
    var maxHealth: Int

    val atk: Int
    val def: Int

    fun setHp(hp: Int) {
        health = minOf(maxHealth, maxOf(0, hp)) // clamp
    }
}

data class Pos(val x: Int, val y: Int)

class Player(var x: Int, var y: Int) : Attackable {
    private val spawnX = x
    private val spawnY = y

    override var health = 20
    override var maxHealth = 20

    var statAtk = 2
        private set
    var statDef = 2
        private set

    var weaponAtk = 0
    var armorDef = 0

    val isDead get() = health <= 0
    override val atk get() = statAtk + weaponAtk
    override val def get() = statDef + armorDef

    var level = 1
        private set
    var exp = 0
        private set

    fun addExp(n: Int) {
        val n = Math.floor(n * (getAccessory(Accessory.Experience)?.onAddExp(this) ?: 1.0)).toInt()
        exp += n
        if (exp >= 5 * level)
            incrementLevel()
    }

    fun incrementLevel() {
        level++
        exp = 0

        maxHealth += 5
        statAtk += 2
        statDef += 2
        setHp(maxHealth)
    }

    val accessories = LinkedHashSet<Accessory>()

    fun equipAccessory(accessory: Accessory) {
        if (accessories.size >= 4) return
        accessories.add(accessory)
    }

    fun releaseAccessory(accessory: Accessory) { // only for 'RE' I guess?
        accessories.remove(accessory)
    }

    fun respawn() {
        setHp(maxHealth)

        x = spawnX
        y = spawnY
    }

    fun hasAccessory(accessory: Accessory) = accessory in accessories

    fun getAccessory(accessory: Accessory) = accessory.takeIf { hasAccessory(it) }
}

class Monster(
    val pos: Pos,
    val name: String,
    override var health: Int,
    override val atk: Int,
    override val def: Int,
    val exp: Int
) : Attackable {
    override var maxHealth = health
        set(_) = throw NotImplementedError()

    companion object {
        fun parse(n: List<String>): Monster = Monster(
            Pos(n[1].toInt() - 1, n[0].toInt() - 1),
            n[2],
            n[5].toInt(),
            n[3].toInt(),
            n[4].toInt(),
            n[6].toInt()
        )
    }
}

sealed interface Chest {
    fun open(player: Player)

    val pos: Pos

    data class WeaponChest(override val pos: Pos, val atk: Int) : Chest {
        override fun open(player: Player) {
            player.weaponAtk = atk
        }
    }
    data class ArmorChest(override val pos: Pos, val def: Int) : Chest {
        override fun open(player: Player) {
            player.armorDef = def
        }
    }
    data class AccessoryChest(override val pos: Pos, val accessory: Accessory) : Chest {
        override fun open(player: Player) {
            player.equipAccessory(accessory)
        }
    }

    companion object {
        fun parse(n: List<String>): Chest = when (n[2]) {
            "W" -> WeaponChest(Pos(n[1].toInt() - 1, n[0].toInt() - 1), n[3].toInt())
            "A" -> ArmorChest(Pos(n[1].toInt() - 1, n[0].toInt() - 1), n[3].toInt())
            else -> AccessoryChest(Pos(n[1].toInt() - 1, n[0].toInt() - 1), Accessory.entries.find { it.serialName == n[3] }!!)
        }
    }
}

class Fight(val player: Player, val monster: Monster, val boss: Boolean) {
    var turn: Attackable = player
        private set
    var isFirst = true
        private set

    fun deal(damage: Int) {
        val target = if (turn == player) monster else player
        target.setHp(target.health - maxOf(1, damage - target.def))
    }

    fun run() {
        val hunter = player.getAccessory(Accessory.Hunter)
        hunter?.onFight(this)

        while (player.health > 0 && monster.health > 0) {
            val courage = player.getAccessory(Accessory.Courage)
            if (courage == null || !courage.onAttack(this)) {
                if (hunter == null || !hunter.onAttack(this)) {
                    deal(turn.atk)
                }
            }

            turn = if (turn == player) monster else player

            if (turn == player)
                isFirst = false
        }

        if (player.health > 0) {
            player.getAccessory(Accessory.HPRegeneration)?.onWin(player)
            player.addExp(monster.exp)
        }
    }
}

sealed interface Accessory {
    val serialName: String

    fun onDeath(player: Player, monster: Monster?): Boolean { return false }
    fun onWin(player: Player) {}
    fun onAttack(fight: Fight): Boolean { return false }
    fun onFight(fight: Fight) {}
    fun onAddExp(player: Player): Double { return 1.0 }
    fun onSpike(player: Player): Boolean { return false }

    companion object {
        val entries = arrayOf(HPRegeneration, Reincarnation, Courage, Dexterity, Experience, Hunter, Cursed)
    }

    data object HPRegeneration : Accessory {
        override val serialName = "HR"

        override fun onWin(player: Player) {
            player.setHp(player.health + 3)
        }
    }

    data object Reincarnation : Accessory {
        override val serialName = "RE"

        override fun onDeath(player: Player, monster: Monster?): Boolean {
            player.releaseAccessory(Reincarnation)
            player.respawn()

            monster?.setHp(monster!!.maxHealth)
            return true
        }
    }

    data object Courage : Accessory {
        override val serialName = "CO"

        override fun onAttack(fight: Fight): Boolean {
            if (!fight.isFirst || fight.turn != fight.player)
                return false

            val deal = fight.turn.atk * if (fight.player.hasAccessory(Dexterity)) 3 else 2
            fight.deal(deal)
            return true
        }
    }

    data object Dexterity : Accessory {
        override val serialName = "DX" // maimai

        override fun onSpike(player: Player): Boolean {
            player.setHp(player.health - 1)
            return true
        }
    }

    data object Experience : Accessory {
        override val serialName = "EX"

        override fun onAddExp(player: Player): Double {
            return 1.2
        }
    }

    data object Hunter : Accessory {
        override val serialName = "HU"

        override fun onFight(fight: Fight) {
            if (!fight.boss) return

            fight.player.setHp(fight.player.maxHealth)
        }

        override fun onAttack(fight: Fight): Boolean {
            return fight.boss && fight.turn == fight.monster && fight.isFirst
            // deal zero damage
            // if monster is boss and his first turn
        }
    }

    data object Cursed : Accessory {
        override val serialName = "CU"
        // literally does nothing
    }
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val field = Array(n) { CharArray(m) }
    var _player: Player? = null
    var _bossPos: Pos? = null
    var _monsterNum = 0
    var _chest = 0

    repeat(n) {
        for ((i, ch) in readln().withIndex()) {
            field[it][i] = ch
            when (ch) {
                '@' -> {
                    _player = Player(i, it)
                    field[it][i] = '.'
                }
                'M' -> {
                    _bossPos = Pos(i, it)
                    _monsterNum++
                }
                '&' -> {
                    _monsterNum++
                }
                'B' -> {
                    _chest++
                }
            }
        }
    }

    val player = _player!!
    val moves = readln()

    val monsters = HashMap<Pos, Monster>()
    repeat(_monsterNum) {
        val monster = Monster.parse(readln().split(' '))
        monsters[monster.pos] = monster
    }
    val chests = HashMap<Pos, Chest>()
    repeat(_chest) {
        val chest = Chest.parse(readln().split(' '))
        chests[chest.pos] = chest
    }
    val boss = monsters[_bossPos!!]!!
    var deathReason: String? = null
    var endGame = false
    var turns = 0

    val idx = "UDLR"
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    for (ch in moves) {
        turns++
        val mvi = idx.indexOf(ch)
        val ox = player.x + dx[mvi]
        val oy = player.y + dy[mvi]

        if (ox !in 0..<m || oy !in 0..<n || field[oy][ox] == '#') {
            // no move
        } else {
            when (field[oy][ox]) {
                'B' -> {
                    val chestPos = Pos(ox, oy)
                    val chest = chests[chestPos]!!
                    chest.open(player)
                    field[oy][ox] = '.'
                    chests.remove(chestPos)

                    player.x = ox
                    player.y = oy
                }
                '&' -> {
                    val monsterPos = Pos(ox, oy)
                    val monster = monsters[monsterPos]!!
                    val fight = Fight(player, monster, false)
                    fight.run()

                    if (monster.health <= 0) {
                        field[oy][ox] = '.'
                        monsters.remove(monsterPos)

                        player.x = ox
                        player.y = oy
                    }

                    if (player.isDead) {
                        if (player.getAccessory(Accessory.Reincarnation)?.onDeath(player, monster) != true) {
                            deathReason = monster.name
                            break // real death handling
                        }
                    }
                }
                'M' -> {
                    val fight = Fight(player, boss, true)
                    fight.run()

                    if (boss.health <= 0) {
                        field[oy][ox] = '.'
                        monsters.remove(_bossPos)

                        player.x = ox
                        player.y = oy

                        endGame = true
                        break
                    } else if (player.isDead) {
                        if (player.getAccessory(Accessory.Reincarnation)?.onDeath(player, boss) != true) {
                            deathReason = boss.name
                            break // real death handling
                        }
                    }
                }
                else -> {
                    player.x = ox
                    player.y = oy
                }
            }
        }

        if (field[player.y][player.x] == '^') {
            if (player.getAccessory(Accessory.Dexterity)?.onSpike(player) != true) {
                player.setHp(player.health - 5)
            }

            if (player.isDead) {
                if (player.getAccessory(Accessory.Reincarnation)?.onDeath(player, null) != true) {
                    deathReason = "SPIKE TRAP"
                    break // real death handling
                }
            }
        }
    }

    if (!player.isDead) {
        field[player.y][player.x] = '@'
    }

    println(field.joinToString("\n") { it.joinToString("") })
    println("Passed Turns : $turns")
    println("LV : ${player.level}")
    println("HP : ${player.health}/${player.maxHealth}")
    println("ATT : ${player.statAtk}+${player.weaponAtk}")
    println("DEF : ${player.statDef}+${player.armorDef}")
    println("EXP : ${player.exp}/${player.level * 5}")

    if (endGame) {
        print("YOU WIN!")
    } else if (player.isDead) {
        print("YOU HAVE BEEN KILLED BY $deathReason..")
    } else {
        print("Press any key to continue.")
    }
}
