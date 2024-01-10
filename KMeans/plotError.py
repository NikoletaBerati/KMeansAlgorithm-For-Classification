import matplotlib.pyplot as plt
import csv

def plot_error(file_path):
    clusters = []
    errors = []

    with open(file_path, 'r') as csv_file:
        csv_reader = csv.reader(csv_file)
        for row in csv_reader:
            cluster, error = map(float, row)
            clusters.append(cluster)
            errors.append(error)

    plt.plot(clusters, errors, label='Error', linestyle='-')
    plt.title('Clustering Error')
    plt.xlabel('Cluster')
    plt.ylabel('Error')
    plt.legend()
    plt.show()

if __name__ == "__main__":
    file_path = "clusteringError.csv"
    plot_error(file_path)
