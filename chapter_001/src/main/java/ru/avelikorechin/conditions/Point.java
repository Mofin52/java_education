package ru.avelikorechin.conditions;

/**
	* Class for creating points.
	* @author Alexander Velikorechin
	* @since 18.01.2017
*/

public class Point {
	/**
	* Point x coord.
	*/
	private double x;

	/**
	* Point y coord.
	*/
	private double y;

	/**
	* Constructor class.
	* @param x — x coord
	* @param y — y coord
	*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	* Finding distance between two points.
	* @param point — point to calculate distance to
	* @return returns result
	*/

	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow(point.x - this.x, 2.0) + Math.pow(point.y - this.y, 2.0));
	}

}