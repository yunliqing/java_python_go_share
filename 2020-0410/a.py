from pybloom import BloomFilter
f = BloomFilter(capacity=1000, error_rate=0.001) # capacity是容量, error_rate 是能容忍的误报率
f.add('Traim304') # 当不存在该元素,返回False
False
f.add('Traim304') # 若存在,返回 True
True
'Traim304' in f # 值得注意的是若返回 True。该元素可能存在, 也可能不存在。过滤器能容许存在一定的错误
True
'Jacob' in f # 但是 False。则必定不存在
False
len(f) # 当前存在的元素
1

f = BloomFilter(capacity=1000, error_rate=0.001)
from pybloom import ScalableBloomFilter
sbf = ScalableBloomFilter(mode=ScalableBloomFilter.SMALL_SET_GROWTH)
# sbf.add() 与 BloomFilter 同

