import random
import matplotlib.pyplot as plt
import numpy as np

def generate_random_int(n):

    return [random.randint(1, 9) for i in range(n)]

if __name__ == '__main__':

    number = 8000
    x = [i for i in range(number + 1) if i != 0]
    print(x)
    total_random_int = generate_random_int(number)
    print(total_random_int)

    y = [np.mean(total_random_int[0:i+1]) for i in range(number)]
    # np.mean 求均值
    plt.plot(x, y, "b-")

    plt.xlim(0, number)
    # 设置x轴显示范围
    plt.grid(True)
    # 设置网格线
    plt.show()