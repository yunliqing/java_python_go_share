```python
# !coding:utf-8
import sys
from hdfs.client import Client
 
 
 
# 关于python操作hdfs的API可以查看官网:
# https://hdfscli.readthedocs.io/en/latest/api.html
 
 
# 读取hdfs文件内容,将每行存入数组返回
def read_hdfs_file(client, filename):
    # with client.read('samples.csv', encoding='utf-8', delimiter='\n') as reader:
    #  for line in reader:
    # pass
    lines = []
    with client.read(filename, encoding='utf-8', delimiter='\n') as reader:
        for line in reader:
            # pass
            # print line.strip()
            lines.append(line.strip())
    return lines
 
 
# 创建目录
def mkdirs(client, hdfs_path):
    client.makedirs(hdfs_path)
 
 
# 删除hdfs文件
def delete_hdfs_file(client, hdfs_path):
    client.delete(hdfs_path)
 
 
# 上传文件到hdfs
def put_to_hdfs(client, local_path, hdfs_path):
    client.upload(hdfs_path, local_path, cleanup=True)
 
 
# 从hdfs获取文件到本地
def get_from_hdfs(client, hdfs_path, local_path):
    client.download(hdfs_path, local_path, overwrite=False)
 
 
# 追加数据到hdfs文件
def append_to_hdfs(client, hdfs_path, data):
    client.write(hdfs_path, data, overwrite=False, append=True, encoding='utf-8')
 
 
# 覆盖数据写到hdfs文件
def write_to_hdfs(client, hdfs_path, data):
    client.write(hdfs_path, data, overwrite=True, append=False, encoding='utf-8')
 
 
# 移动或者修改文件
def move_or_rename(client, hdfs_src_path, hdfs_dst_path):
    client.rename(hdfs_src_path, hdfs_dst_path)
 
 
# 返回目录下的文件
def list(client, hdfs_path):
    return client.list(hdfs_path, status=False)
 
# client = Client(url, root=None, proxy=None, timeout=None, session=None)
# client = Client("http://hadoop:50070")
client = Client("http://192.168.1.80:50070/",root="/",timeout=10000,session=False)
# client = InsecureClient("http://192.168.1.80:50070", user='ann');
 
# move_or_rename(client,'/input/2.csv', '/input/emp.csv')
# read_hdfs_file(client,'/input/emp.csv')
append_to_hdfs(client,'/input/emp.csv','我爱你'+'\n')
# write_to_hdfs(client, '/emp.csv', "sadfafdadsf")
# read_hdfs_file(client,'/input/emp.csv')
# move_or_rename(client,'/input/emp.csv', '/input/2.csv')
# mkdirs(client,'/input/python')
# print(list(client, '/'))
# chown(client,'/input/1.csv', 'root')
 
```

有时候我们会链接报错：

**urllib3.exceptions.NewConnectionError: <urllib3.connection.HTTPConnection object at 0x0000000003A45F28>: Failed to establish a new connection: [Errno 11004] getaddrinfo failed**



可以通过下面的方式去解决：

1、服务器上的hadoop的配置文件中，namenode不能设置成127.0.0.1或者localhost，要设置ip映射别名

（1）首先修改centos的/etc/hosts，这里要写服务器的ip，不能写127.0.0.1，不然没办法远程连接过来hdfs

192.168.1.80     hadoop

（2）修改hadoop的配置

即hadoop的core-site.xml文件

```
<configuration>
<property>
        <name>fs.defaultFS</name>
        <value>hdfs://hadoop:9000</value>
    </property>
    <!--存放数据的公共目录 -->
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/usr/local/hadoop/hadoop-2.9.0/tmp</value>
    </property>
</configuration>
```


fs.defaultFS这里设置要注意，如果需要通过客户端远程连接（非服务器命令行连接，即使是java或者python运行在服务器连接hdfs也要设置下面这种）

hdfs://hadoop:9000

如果只限本地操作设置成这样即可（或者本地命令行操作），刚开始我就是犯了这个错误，因为网上很多资料单机部署hdfs都是写localhost   :   hdfs://127.0.0.1:9000或者hdfs://localhost:9000

2、看到某些报错信息python通过webhdfs发送请求时传递参数是hadoop:50070，当时在想，是不是客户端机器也要配置ip映射。百度了下window修改ip映射的文件位置： **/etc/hosts**
修改ip映射

**192.168.1.80 hadoop**
注：可能本人使用pycharm的原因，配置了linux的ip别名映射后，还是提示网络报错，后来觉得可能需要重启电脑，配置才完全生效，结果重启电脑后，python上传文件到hdfs运行正常。

3、然后再尝试python通过hdfs库上传文件，提示Name node is in safe mode

这是因为hadoop处于安全模式，输命令强制离开安全模式

**hadoop dfsadmin -safemode leave**
资料：https://blog.csdn.net/xw13106209/article/details/6866072

 

经过上面3步后，python终于可以顺利远程上传文件到hdfs上。

注：这里有些地方要注意

1、java通过hdfs远程连接hdfs，不需要在客户端机配置ip映射。

2、python利用hdfs库通过webhdfs操作hdfs，必须在客户端机配置ip映射

3、阿里云配置hadoop，/etc/hosts要设置内网ip，namenode才能正常运行。但是java、python通过外网ip访问hdfs时，总提示连不上。后面我在虚拟机配置hadoop，用java、python连接一切正常。所以如果使用阿里云配置hadoop，远程连接hadoop的程序应该运行在同一个服务器，或者另外的阿里内网服务器，然后通过内网连接
