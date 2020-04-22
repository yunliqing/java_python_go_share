# 第一种 递归法
def fib_recur(n):
  assert n >= 0, "n > 0"
  if n <= 1:
    return n
  return fib_recur(n-1) + fib_recur(n-2)

for i in range(1, 20):
    print(fib_recur(i), end=' ')

# 第二种 递推法
def fib_loop(n):
    a, b = 0, 1
    for i in range(n + 1):
        a, b = b, a + b
    return a


for i in range(20):
    print(fib_loop(i), end=' ')

# 第三种 生成器
def fib_loop_while(max):
    a, b = 0, 1
    while max > 0:
        a, b = b, a + b
        max -= 1
        yield a


for i in fib_loop_while(10):
    print(i)

