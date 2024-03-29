# python 关键字yield的用法
# yield就是保存当前程序执行状态,你用for循环的时候,每次取一个元素的时候就会计算一次.
# 用yield的函数叫generator和iterator一样，他的好处是不用一次计算所有元素，而是用一次计算一次，
# 可以节省很多空间。generator每次计算需要上一次计算结果，所以用yield，否则一return，上次结果就没拉
def createGen():
    mylist =range(3)
    for i in mylist:
        yield i*i

mycreateGen=createGen()
print(mycreateGen)
for i in mycreateGen:
    print("i=",i)