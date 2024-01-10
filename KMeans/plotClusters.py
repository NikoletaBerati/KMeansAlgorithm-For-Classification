import matplotlib.pyplot as plt
import pandas as pd

m3Files = ['M3-Cluster1.csv', 'M3-Cluster2.csv', 'M3-Cluster3.csv','centroidsForCluster3.csv']

colors = ['yellow', 'red', 'green', 'blue', 'magenta', 'orange', 'grey', 'skyblue', 'pink', 'aquamarine', 'mediumpurple', 'olive']

for file_name, color in zip(m3Files[:-1], colors):
    df = pd.read_csv(file_name, header=None)
    df.columns = ["x1", "x2"]
    plt.scatter(df['x1'], df['x2'], s=20, marker="+", color=color)

centroid_file = m3Files[-1]
centroid_df = pd.read_csv(centroid_file, header=None)
centroid_df.columns = ["x1", "x2"]
plt.scatter(centroid_df['x1'], centroid_df['x2'], s=30, marker="*", color='black')

plt.title("3 Clusters")

#####################################################
plt.figure()

m6Files = ['M6-Cluster1.csv', 'M6-Cluster2.csv', 'M6-Cluster3.csv',
              'M6-Cluster4.csv', 'M6-Cluster5.csv', 'M6-Cluster6.csv', 'centroidsForCluster6.csv']

for file_name, color in zip(m6Files[:-1], colors):
    df = pd.read_csv(file_name, header=None)
    df.columns = ["x1", "x2"]
    plt.scatter(df['x1'], df['x2'], s=20, marker="+", color=color)

centroid_file = m6Files[-1]
centroid_df = pd.read_csv(centroid_file, header=None)
centroid_df.columns = ["x1", "x2"]
plt.scatter(centroid_df['x1'], centroid_df['x2'], s=30, marker="*", color='black')
 
plt.title("6 Clusters")

########################################################
plt.figure()

m9Files = ['M9-Cluster1.csv', 'M9-Cluster2.csv', 'M9-Cluster3.csv',
              'M9-Cluster4.csv', 'M9-Cluster5.csv', 'M9-Cluster6.csv',
               'M9-Cluster7.csv', 'M9-Cluster8.csv', 'M9-Cluster9.csv', 'centroidsForCluster9.csv']

for file_name, color in zip(m9Files[:-1], colors):
    df = pd.read_csv(file_name, header=None)
    df.columns = ["x1", "x2"]
    plt.scatter(df['x1'], df['x2'], s=20, marker="+", color=color)

centroid_file = m9Files[-1]
centroid_df = pd.read_csv(centroid_file, header=None)
centroid_df.columns = ["x1", "x2"]
plt.scatter(centroid_df['x1'], centroid_df['x2'], s=30, marker="*", color='black')

plt.title("9 Clusters")

########################################################
plt.figure()

m12Files = ['M12-Cluster1.csv', 'M12-Cluster2.csv', 'M12-Cluster3.csv',
              'M12-Cluster4.csv', 'M12-Cluster5.csv', 'M12-Cluster6.csv',
               'M12-Cluster7.csv', 'M12-Cluster8.csv', 'M12-Cluster9.csv',
               'M12-Cluster10.csv', 'M12-Cluster11.csv', 'M12-Cluster12.csv','centroidsForCluster12.csv']

for file_name, color in zip(m12Files[:-1], colors):
    df = pd.read_csv(file_name, header=None)
    df.columns = ["x1", "x2"]
    plt.scatter(df['x1'], df['x2'], s=20, marker="+", color=color)

centroid_file = m12Files[-1]
centroid_df = pd.read_csv(centroid_file, header=None)
centroid_df.columns = ["x1", "x2"]
plt.scatter(centroid_df['x1'], centroid_df['x2'], s=30, marker="*", color='black')

plt.title("12 Clusters")

#########################################################
plt.show()