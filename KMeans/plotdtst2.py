import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_csv("data.csv")
df.columns = ["x1","x2"]

plt.scatter(list(df['x1']), list(df['x2']), s =20, marker="+", color="b")

plt.show()

