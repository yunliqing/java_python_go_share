# 三元运算符就是在赋值变量的时候，可以直接加判断，然后赋值
#
#         三元运算符的功能与'if....else'流程语句一致，它在一行中书写，代码非常精炼，执行效率更高
#
#         格式：[on_true] if [expression] else [on_false]
#
#         res = 值1 if 条件 else 值2
a = 2
b = 5
val = a if a > b else b
print(val)  # 5

val = a if a < 3 else b
print(val)  # 2