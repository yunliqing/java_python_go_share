class People(object):
    def __init__(self, name, age, gender):
        self.name = name
        self.age = age
        self.gender = gender

    def walk(self):
        print('%s is walking' % self.name)

    def test(self):
        print('test class from father class %s' % self.name)


# 定义Teacher子类
class Teacher(People):
    school = 'jialidun'

    def __init__(self, name, age, gender, level, salary):
        # super写和父类相同的属性。
        super(Teacher, self).__init__(name, age, gender)
        self.level = level
        self.salary = salary

    def teach(self):
        print('%s is teaching' % self.name)

    def test(self):
        People.test(self)
        print('from teacher')


# 测试部分
t = Teacher("bruce", 23, "male", "teacher", 30000)
t.walk()
t.teach()
t.test()
