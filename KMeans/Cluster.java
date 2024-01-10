import java.util.ArrayList;

public class Cluster {

    public ArrayList<PointOfCluster> points;
    public PointOfCluster centroid;
    public int clusterNumber;

    public Cluster(int clusterNumber) {
        this.clusterNumber = clusterNumber;
        points = new ArrayList<PointOfCluster>();
        centroid = null;
    }

    public ArrayList<PointOfCluster> getPoints() {
        return points;
    }

    public PointOfCluster getCentroid() {
        return centroid;
    }

    public void setCentroid(PointOfCluster centroid) {
        this.centroid = centroid;
    }

    public void printCluster() {
        System.out.println("Cluster: " + clusterNumber);
        System.out.println("Centroid: "+"["+centroid.getX1()+","+centroid.getX2()+"]");
        System.out.println("Points: " + points.size());
    }
}