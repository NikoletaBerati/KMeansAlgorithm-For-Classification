public class PointOfCluster {

	private double x1 = 0;
	private double x2 = 0;
	private int cluster = 0;

	public PointOfCluster(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}

	public double getX1() {
		return this.x1;
	}

	public double getX2() {
		return this.x2;
	}

	public void setCluster(int n) {
		this.cluster = n;
	} 
}