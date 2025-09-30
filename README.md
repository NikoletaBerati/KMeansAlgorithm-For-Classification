
# K-Means Clustering

This repository contains an implementation of the **K-Means clustering algorithm** in Java, along with Python scripts for result visualization. 

The main task is to group **1200 data points** into clusters, with the number of clusters `M` taking values in `{3, 6, 9, 12}`.




## ℹ️ About this project
This project was developed as part of the *Computational Intelligence* course at University of Ioannina, in collaboration with a fellow student.

## 📌 Overview

- Clusters are formed by repeatedly assigning points to the nearest center and updating cluster centroids.  
- For each cluster setting (`M`), the program executes **15 independent runs**.  
- The best run is chosen based on the **lowest clustering error** (sum of squared distances).  
- Final results include cluster assignments, centroid positions, and cluster ID.

  
## 🛠️ Project Components

- **KMeans.java** – Main program. Implements all the logic of the algorithm. Handles initialization, iterative updates, and convergence checks.
- **Cluster.java** –  Represents a signle cluster, storing its centroid, ID, and assigned points.
- **PointOfCluster.java** – Represents a data point of a cluster  `[x1, x2]`.   

## 📊 Dataset
  The `1200` data points being clustered are imported in the `data.csv` file.


## 🔍 Visualization

To help visualize the K-Mean algorithm, the repository includes Python scripts that can:

- **Plot the clusters and their centers**  
  - Points `+`
  - Centroids `*`

- **Plot the clustering error**  
  - Displays the error values across multiple runs  
  - Makes it easier to verify which run produced the best solution  



## 🚀 How to run
  - Compile and run:    
    **javac** *.java  
     **java**  KMeans  

