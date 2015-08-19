package com.mkyong.common.radius;

/**
 * @author Sergey
 * 
 */
public class Radius {
	private static double firstx;
	private static double firsty;
	private static double radius;

	public Radius(double firstx, double firsty, double radius) {
		Radius.setFirstx(firstx);
		Radius.setFirsty(firsty);
		Radius.setRadius(radius);
	}

	/**
	 * @return the firstx
	 */
	public static double getFirstx() {
		return firstx;
	}

	/**
	 * @param firstx
	 *            the firstx to set
	 */
	public static void setFirstx(double firstx) {
		Radius.firstx = firstx;
	}

	/**
	 * @return the radius
	 */
	public static double getRadius() {
		return radius;
	}

	/**
	 * @return the firsty
	 */
	public static double getFirsty() {
		return firsty;
	}

	/**
	 * @param firsty
	 *            the firsty to set
	 */
	public static void setFirsty(double firsty) {
		Radius.firsty = firsty;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public static void setRadius(double radius) {
		Radius.radius = radius;
	}

	/**
	 * @return the Coordinate
	 */
	public static Coordinate coorRad(double x, double y, double radius) {
		setFirstx(x);
		setFirsty(y);
		setRadius(radius);
		// length in kilometers per degree of latitude
		float lx = 111.111f;
		// length in kilometers per degree of longitude
		float ly = ((float) (Math.cos(getFirstx()) * (40000 / 360)));
		double coorx = getRadius() / lx;
		double coory = getRadius() / ly;
		double x1 = getFirstx() - coorx;
		double x2 = getFirstx() + coorx;
		double y1 = getFirsty() - coory;
		double y2 = getFirsty() + coory;
		Coordinate coordinate = new Coordinate(x1, y1, x2, y2);

		return coordinate;
	}
}
