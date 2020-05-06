# _*_coding:utf-8_*_

# 作者    ：dingcm
# 创建时间 ：2020/4/21 下午2:31
# 文件    ：数据结构.py

# 保留有限历史记录 collections.deque

from collections import deque

def search(lines, pattern, history):
    previous_lines = deque(maxlen=history)
    for li in lines:
        if pattern in li:
            yield li, previous_lines

        previous_lines.append(li)


# 怎样从一个集合中获得最大或者最小的 N 个元素列表?
# heapq 模块有两个函数:nlargest() 和 nsmallest() 可以完美解决这个问题。

import heapq
nums = [1,3,43,12,312,543,423,23,54,765,345,876,-312,5435,765,8]
print(heapq.nlargest(3,nums))    # 获取最大值
print(heapq.nsmallest(3,nums))   # 获取最小值


portfolio = [
{'name': 'IBM', 'shares': 100, 'price': 91.1},
{'name': 'AAPL', 'shares': 50, 'price': 543.22},
{'name': 'FB', 'shares': 200, 'price': 21.09},
{'name': 'HPQ', 'shares': 35, 'price': 31.75},
{'name': 'YHOO', 'shares': 45, 'price': 16.35},
{'name': 'ACME', 'shares': 75, 'price': 115.65}
]

print(heapq.nlargest(2,portfolio, key= lambda y : y["shares"]))
print(heapq.nsmallest(2, portfolio, key= lambda y:y["price"]))

nums = [1,-123,321,43,0,432,54,6,76,76,345,86,987,3423]
import heapq
heapq.heapify(nums)
print(nums)    # [-123, 0, 54, 6, 1, 86, 321, 43, 76, 76, 345, 432, 987, 3423]
# 上述结构是堆数据结构 python堆最重要的特征是heap[0]永远是最小的元素
# 并且剩余的元素可以很
# 容易的通过调用 heapq.heappop() 方法得到,该方法会先将第一个元素弹出来,然后
# 用下一个最小的元素来取代被弹出元素 (这种操作时间复杂度仅仅是 O(log N),N 是
# 堆大小)。比如,如果想要查找最小的 3 个元素,你可以这样做

print(heapq.heappop(nums))    # -123
print(heapq.heappop(nums))    # 0
print(heapq.heappop(nums))    # 1
print(heapq.heappop(nums))    # 6

# 当要查找的元素个数相对比较小的时候,函数 nlargest()和nsmallest()是很合适的。

# 实现一个优先级队列
import heapq
class PriorityQueue():
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        print(self._queue)
        self._index += 1

    def pop(self):
        return heapq.heappop(self._queue)[-1]

class Item():
    def __init__(self, name):
        self.name = name
    def __repr__(self):
        # print("Item({!r})".format(self.name))
        return "Item({!r})".format(self.name)

q = PriorityQueue()
q.push(Item("foo"),1)
q.push(Item("bar"),5)
q.push(Item("spam"),4)
q.push(Item("grok"),1)

print(q.pop())
print(q.pop())
print(q.pop())
print(q.pop())
