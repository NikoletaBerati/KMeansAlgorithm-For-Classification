import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class KMeans {

    private ArrayList<PointOfCluster> points;
    private ArrayList<Cluster> clusters;
    private int numberOfClusters;

    public KMeans(int numberOfClusters){
        points = new ArrayList<PointOfCluster>();
        clusters = new ArrayList<Cluster>();
        this.numberOfClusters = numberOfClusters;
    }

    public void loadFile(String filename){
		Scanner reader = null;
		try{
			reader = new Scanner(new FileInputStream(filename));
		} 
		catch(FileNotFoundException e){
			System.exit(0);
		}

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] coordinate = line.split(",");
			PointOfCluster point =  new PointOfCluster(Double.parseDouble(coordinate[0]), Double.parseDouble(coordinate[1]));
			points.add(point);
		}
		reader.close();
	}

    public void initializeClusters(){
	    for(int i = 0; i<numberOfClusters; i++){
            Cluster cluster = new Cluster(i);
            int randomInt = getRandomNumber(0, points.size()-1);
            PointOfCluster randomPoint = points.get(randomInt);
            PointOfCluster centroid = randomPoint;
            cluster.setCentroid(centroid);
            clusters.add(cluster);
        }
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    private void printCurrentState(){
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        for (int i=0; i<numberOfClusters; i++){
            Cluster c = clusters.get(i);
            c.printCluster();
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");
    }

    public double calculateEuclideanDistance(PointOfCluster point, PointOfCluster centroid){
		double distanceX2 = centroid.getX2() - point.getX2();
		double distanceX1 = centroid.getX1() - point.getX1();
		double euclideanDistance = Math.sqrt(Math.pow(distanceX2, 2) + Math.pow(distanceX1, 2));
		return euclideanDistance;
	}

    public void assignPoints(){
        int clusterNumber = 0;

        for (int i=0; i<points.size(); i++){
            double distance = 0.0;
            double min = Double.MAX_VALUE;
            for (int j=0; j<numberOfClusters; j++){
                Cluster cluster = clusters.get(j);
                PointOfCluster centroid = cluster.getCentroid();
                distance = calculateEuclideanDistance(points.get(i), centroid);
                if (distance < min){
                    min = distance;
                    clusterNumber = j;
                }
            }
            points.get(i).setCluster(clusterNumber);
            Cluster currentCluster = clusters.get(clusterNumber);
            ArrayList<PointOfCluster> pointsOfCurrentCluster = currentCluster.getPoints();
            pointsOfCurrentCluster.add(points.get(i));
        }
    }

    public void moveCentroids() {
        for (Cluster cluster : clusters){
            double meanX1 = 0;
            double meanX2 = 0;
            ArrayList<PointOfCluster> pointsOfCluster = cluster.getPoints();
            int totalNumOfPoints = pointsOfCluster.size();

            for (PointOfCluster point : pointsOfCluster){
                meanX1 += point.getX1();
                meanX2 += point.getX2();
            }
            meanX1 = meanX1 / totalNumOfPoints;
            meanX2 = meanX2 / totalNumOfPoints;
            PointOfCluster newCentroid = new PointOfCluster(meanX1, meanX2);

            cluster.setCentroid(newCentroid);
        }
    }

    private double computeTotalError(){
        double totalError = 0;
    
        for (Cluster cluster : clusters){
            PointOfCluster centroid = cluster.getCentroid();
            for (PointOfCluster point : cluster.getPoints()){
                totalError += calculateEuclideanDistance(point, centroid);
            }
        }
        return totalError;
    }

    public double kMeansAlgorithm() {
        double distanceOfCentroids = Double.MAX_VALUE;
        double totalError = 0.0;
        double terminateThreshold = 0.1;

        while (distanceOfCentroids > terminateThreshold){
            ArrayList<PointOfCluster> centroidsBefore = new ArrayList<PointOfCluster>();
            
            for (Cluster cluster : clusters){
                cluster.getPoints().clear();
                centroidsBefore.add(cluster.getCentroid());
            }
         
            assignPoints();
            moveCentroids();
            totalError = computeTotalError();

            ArrayList<PointOfCluster> centroidsAfter = new ArrayList<PointOfCluster>();
            for (Cluster cluster : clusters){
                centroidsAfter.add(cluster.getCentroid());
            }

            distanceOfCentroids = 0.0;
            for (int i=0; i<centroidsBefore.size(); i++){
                double beforeAfterDistance = calculateEuclideanDistance(centroidsBefore.get(i), centroidsAfter.get(i));
                distanceOfCentroids += beforeAfterDistance;
            }
        }
        System.out.println("Clustering Error: " + totalError + "\n");
        return totalError;
    }

    public void createFilesWithClusterPoints(int M){
        FileWriter fileWriter = null;
        int counter = 1;
        
        for (Cluster cluster : clusters){
            try {
                fileWriter = new FileWriter("M"+M +"-"+"Cluster"+counter+".csv");
            } catch (IOException e) {
                System.exit(0);
            }
            PrintWriter outputWriter = new PrintWriter(fileWriter);
            outputWriter.flush();
            ArrayList<PointOfCluster> pointsOfCluster = cluster.getPoints();
            for (PointOfCluster point : pointsOfCluster){
                outputWriter.println(point.getX1() + "," + point.getX2());
                outputWriter.flush();
            }
            counter++;
        }
    }

    public void createFileWithCentroids(int i, ArrayList<Integer> numClusters, ArrayList<Double> distances){
        FileWriter fileWriter = null;
 
        try {
            fileWriter = new FileWriter("centroidsForCluster" + i + ".csv");
        } catch (IOException e) {
            System.exit(0);
        }

        PrintWriter outputWriter = new PrintWriter(fileWriter);
        outputWriter.flush();
        for (Cluster cluster : clusters){
            PointOfCluster centroid = cluster.getCentroid();
            outputWriter.println(centroid.getX1()+","+centroid.getX2());
            outputWriter.flush();
        }
    }

    public void createFileWithClusteringError(ArrayList<Integer> numClusters, ArrayList<Double> distances){
        FileWriter fileWriter = null;
 
        try {
           fileWriter = new FileWriter("clusteringError.csv");
        } catch (IOException e) {
            System.exit(0);
        }

        PrintWriter outputWriter = new PrintWriter(fileWriter);
        outputWriter.flush();
        for (int j=0; j<numClusters.size(); j++){
            outputWriter.println(numClusters.get(j)+","+distances.get(j));
            outputWriter.flush();
        }
    }

	public static void main(String[] args){
        int counter = 0;
        ArrayList<Integer> numberOfClustersM = new ArrayList<Integer>();
        numberOfClustersM.add(3);
        numberOfClustersM.add(6);
        numberOfClustersM.add(9);
        numberOfClustersM.add(12);
        ArrayList<Double> clusteringErrors = new ArrayList<Double>();
        
        for(int i=0; i<numberOfClustersM.size(); i++){
            System.out.println("\n");
            System.out.println("******************************* FOR "+numberOfClustersM.get(i)+" CLUSTERS *******************************");
            System.out.println("\n");
            
            KMeans kmeans = new KMeans(numberOfClustersM.get(i));
            kmeans.loadFile("data.csv");
            kmeans.initializeClusters();

            double minDistanceError = Double.MAX_VALUE;
            for (int j=0; j<15; j++){
                System.out.println("For iteration "+ (j+1));
                double currentDistanceError = kmeans.kMeansAlgorithm();
                if (minDistanceError > currentDistanceError) {
                    minDistanceError = currentDistanceError;
                }
            }
            clusteringErrors.add(minDistanceError);

            System.out.println("\n               Final State Of Clusters ");
            kmeans.printCurrentState();
            System.out.println("<-------------------------------------------------------------------->");
            System.out.println("Minimum clustering error after 15 iterations is : " + minDistanceError);
            System.out.println("<-------------------------------------------------------------------->\n");       

            kmeans.createFileWithCentroids(numberOfClustersM.get(counter), numberOfClustersM, clusteringErrors);
            kmeans.createFilesWithClusterPoints(numberOfClustersM.get(counter));
            
            if (i == numberOfClustersM.size()-1){
                kmeans.createFileWithClusteringError(numberOfClustersM, clusteringErrors);
            }
            counter++;
        }
        for (int i=0; i<clusteringErrors.size(); i++){
            System.out.println("For "+numberOfClustersM.get(i)+" clusters : clustering error = "+clusteringErrors.get(i));
        }
	}

}
