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
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
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
	public Point add(Point p) {
		Point point = new Point(this);
		point.x += p.x;
		point.y += p.y;
		return point;
	}
	public double getDistance(Point p) {
		return Math.hypot(this.x-p.x, this.y-p.y);
	}
	public static Point[] showMeTheShortest(Point p1, Point p2, Point p3, Point p4) {
		Point[] arrp = new Point[2];
		double min;
		arrp[0] = p1;
		arrp[1] = p3;
		min = p1.getDistance(p3);
		if(p1.getDistance(p4)< min) {
			min = p1.getDistance(p4);
			arrp[0] = p1;
			arrp[1] = p4;
		}
		if(p2.getDistance(p3)<min) {
			min = p2.getDistance(p3);
			arrp[0] = p2;
			arrp[1] = p3;
		}
		if(p2.getDistance(p4)<min) {
			min = p2.getDistance(p4);
			arrp[0] = p2;
			arrp[1] = p4;
		}
		return arrp;
	}
	public String toString() {
		return "("+(int)x+","+(int)y+")";
	}

}
