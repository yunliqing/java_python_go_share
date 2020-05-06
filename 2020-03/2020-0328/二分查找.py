# _*_coding:utf-8_*_

# 作者    ：dingcm
# 创建时间 ：2019/12/23 上午10:14
# 文件    ：二分查找.py

def func(list,item):

    low = 0
    high = len(list)-1

    while low <= high:
        mid = (low + high)//2
        if item == list[mid]:
            return mid
        if item > list[mid]:
            low = mid + 1
        else:
            high = mid -1

    return None


a = func([1,2,5,6,7,9,73],5)
print(a)