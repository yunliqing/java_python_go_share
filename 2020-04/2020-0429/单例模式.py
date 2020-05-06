#
# # _*_coding:utf-8_*_
#
# # 作者    ：dingcm
# # 创建时间 ：2020/4/29 下午3:08
# # 文件    ：单例模式.py



# 其实,python的模块就是天然的单例模式,因为模块在第一次导入的时候,会生成.pyc文件,
# 当第二次导入的时候,就会直接加载.pyc文件,而不是再次执行模块代码.如果我们把相关的函数和数据定义在一个模块中,
# 就可以获得一个单例对象了.
# 新建一个python模块叫singleton,然后常见以下python文件
# class Singleton(object):
#     def foo(self):
#         pass
# singleton = Singleton()

# 使用装饰器
# 装饰器里面的外层变量定义一个字典,里面存放这个类的实例.当第一次创建的收,就将这个实例保存到这个字典中.
# 然后以后每次创建对象的时候,都去这个字典中判断一下,如果已经被实例化,就直接取这个实例对象.如果不存在就保存到字典中.

# def singleton(cls):
#
#     _instance = {}
#
#     def _singleton(*args, **kwargs):
#
#         if cls not in _instance:
#             _instance[cls] = cls(*args, **kwargs)
#
#         return _instance
#     return _singleton
#
# # encoding:utf-8
# __author__ = 'Fioman'
# __time__ = '2019/3/6 10:22'
#
#
# def singleton(cls):
#     # 单下划线的作用是这个变量只能在当前模块里访问,仅仅是一种提示作用
#     # 创建一个字典用来保存类的实例对象
#     _instance = {}
#
#     def _singleton(*args, **kwargs):
#         # 先判断这个类有没有对象
#         if cls not in _instance:
#             _instance[cls] = cls(*args, **kwargs)  # 创建一个对象,并保存到字典当中
#         # 将实例对象返回
#         return _instance[cls]
#
#     return _singleton
#
#
# @singleton
# class A(object):
#     a = 1
#
#     def __init__(self, x=0):
#         self.x = x
#         print('这是A的类的初始化方法')
#
#
# a1 = A(2)
# a2 = A(3)
# print(id(a1), id(a2))
#
#
#
#
# class Singleton(object):
#     def __init__(self,*args,**kwargs):
#         pass
#
#     @classmethod
#     def get_instance(cls, *args, **kwargs):
#         # 利用反射,看看这个类有没有_instance属性
#         if not hasattr(Singleton, '_instance'):
#             Singleton._instance = Singleton(*args, **kwargs)
#
#         return Singleton._instance
#
#
# s1 = Singleton()  # 使用这种方式创建实例的时候,并不能保证单例
# s2 = Singleton.get_instance()  # 只有使用这种方式创建的时候才可以实现单例
# s3 = Singleton()
# s4 = Singleton.get_instance()
#
# print(id(s1), id(s2), id(s3), id(s4))



# 4.基于__new__方法实现的单例模式(推荐使用,方便)

# 一个对象的实例化过程是先执行类的__new__方法,如果我们没有写,默认会调用object的__new__方法,
# 返回一个实例化对象,然后再调用__init__方法,对这个对象进行初始化,我们可以根据这个实现单例.
# 在一个类的__new__方法中先判断是不是存在实例,如果存在实例,就直接返回,如果不存在实例就创建.

import threading
class Singleton(object):
    _instance_lock = threading.Lock()

    def __init__(self, *args, **kwargs):
        pass
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, "_instance"):   # 判断当前对象是否包含属性
            with Singleton._instance_lock:
                if not hasattr(cls, "_instance"):
                    Singleton._instance = super().__new__(cls)


            return Singleton._instance

object1 = Singleton()
object2 = Singleton()
print(object1,object2)

def task(arg):
    obj = Singleton()
    print(obj)

for i in range(10):
    t = threading.Thread(target=task, args=[i,])
    t.start()


