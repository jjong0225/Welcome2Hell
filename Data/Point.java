package Data;

public class Point {
	private double x;
	private double y;
	public Point() {
		this(0,0);
	}
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point p) {
		if(x == p.x && y == p.y)
			return true;
		else
			return false;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setXY(Number x, Number y) {
		this.x = x.doubleValue();
		this.y = y.doubleValue();
	}
	public void setX(Number x) {
		this.x = x.doubleValue();
	}
	public void setY(Number y) {
		this.y = y.doubleValue();
	}
	public String toString() {
		return "("+x+","+y+")";
	}

}
