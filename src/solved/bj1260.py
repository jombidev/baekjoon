N, M, V = map(int, input().split())
o = [[]for i in range(N + 1)]
for i in range(M):
    a, b = map(int, input().split())
    o[a].append(b)
    o[b].append(a)
for i in range(N):
    o[i+1].sort()
p = [V,]
v = []
while p:
    t = p.pop(0)
    if t not in v:
        v.append(t)

    d = []
    for i in o[t]:
        if i not in v:
            d.append(i)
    for i, n in enumerate(d):
        p.insert(i, n)
print(*v)
p.clear()
v.clear()
p.append(V)

while p:
    t = p.pop(0)
    if t not in v:
        v.append(t)
    for i in o[t]:
        if i not in v:
            p.append(i)
print(*v)
