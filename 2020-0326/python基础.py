# _*_coding:utf-8_*_

# 作者    ：dingcm
# 创建时间 ：2019/11/29 上午10:09
# 文件    ：python基础.py


# 模块级常量 常量应该全大写 用下划线链接
# 有时候用全局变量来缓存值或者作为函数返回值很有用
# 全局变量应该仅在模块内部可用，并通过模块级的公共函数来访问
# 不要在行尾加分号，也不要用分号将两条命令放在同一行
# 每行不超过80个字符
# 不要使用反斜杠连接行
# 绝对不要用tab，也不要tab和空格混用
# 顶级定义之间空两行，方法定义之间空一行
# 当’=’用于指示关键字参数或默认参数值时, 不要在其两侧使用空格.
# 大部分.py文件不必以#!作为文件的开始. 根据 PEP-394 , 程序的main文件应该以 #!/usr/bin/python2或者 #!/usr/bin/python3开始.
# !先用于帮助内核找到Python解释器, 但是在导入模块时, 将会被忽略. 因此只有被直接执行的文件中才有必要加入#!.
# 每个导入应该独占一行
# 应该避免的名称
# 单字符名称, 除了计数器和迭代器.
# 包/模块名中的连字符(-)
# 双下划线开头并结尾的名称(Python保留, 例如__init__)
# 命名约定
# 所谓”内部(Internal)”表示仅模块内可用, 或者, 在类内是保护或私有的.
# 用单下划线(_)开头表示模块变量或函数是protected的(使用from module import *时不会包含).
# 用双下划线(__)开头的实例变量或方法表示类内私有.
# 将相关的类和顶级函数放在同一个模块里. 不像Java, 没必要限制一个类一个模块.
# 对类名使用大写字母开头的单词(如CapWords, 即Pascal风格),
# 但是模块名应该用小写加下划线的方式(如lower_with_under.py). 尽管已经有很多现存的模块使用类似于CapWords.py这样的命名, 但现在已经不鼓励这样做, 因为如果模块名碰巧和类名一致, 这会让人困扰.

class Solution():
    def ans(self, nums):

        if len(nums) <= 1:
            return [nums]

        result = [[nums[0]]]
        index = 1
        while index < len(nums):
            tmp = []
            for j in result:
                for i in range(index + 1):
                    tmp.append(j[:i] + [nums[index]] + j[i:])
            result = tmp
            index += 1
        return result
solu = Solution()
ans = solu.ans([1,2,3,4])

print(ans)