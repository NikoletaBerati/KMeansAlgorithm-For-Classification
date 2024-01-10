import matplotlib.pyplot as plt
import pandas as pd

# Replace the file names and colors as needed
file_names = ['curve.txt']
colors = ['blue']

for file_name, color in zip(file_names, colors):
    data = pd.read_csv(file_name, delimiter='\s+', header=None, names=['x', 'y'])
    x = data['x']
    y = data['y']

    plt.plot(x, y, color=color)

plt.show()
