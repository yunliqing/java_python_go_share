#!/usr/bin/env python
# encoding: utf-8
'''
---------------------------------------------
|@author: CHEN ZHONGYUAN                    |
---------------------------------------------
|@contact: chenzhongyuan@dataexa.com        |
---------------------------------------------
|@file: zuhemoshi.py                        |
---------------------------------------------
|@time: 2020/4/4 下午10:40                   |
---------------------------------------------
'''

'''
设计模式 之 组合模式
为啥这次用 Python 实现呢
因为 Python 中没有接口
这个 组合 模式，有一点像 Java 中的接口
继承这个接口，重写接口的方法。这样两个类，就有相同的方法
但是组合类，
是相当于把对象写到组合类的某个 列表里面。循环这个列表，来执行里面相同的方法。

'''

class Component:
    def __init__(self, strName):
        self.m_strName = strName

    def Add(self, com):
        pass

    def Display(self, nDepth):
        pass


class Leaf(Component):
    def Add(self, com):
        print("leaf can't add")

    def Display(self, nDepth):
        strtemp = "-" * nDepth
        strtemp = strtemp + self.m_strName
        print(strtemp)


class Composite(Component):
    def __init__(self, strName):
        self.m_strName = strName
        self.c = []

    def Add(self, com):
        self.c.append(com)

    def Display(self, nDepth):
        strtemp = "-" * nDepth
        strtemp = strtemp + self.m_strName
        print(strtemp)
        for com in self.c:
            com.Display(nDepth + 2)


if __name__ == "__main__":
    p = Composite("Wong")
    p.Add(Leaf("Lee"))
    p.Add(Leaf("Zhao"))
    p1 = Composite("Wu")
    p1.Add(Leaf("San"))
    p.Add(p1)
    p.Display(1)
