package ru.avelikorechin.conditions;

/**
	* Class for creating triangles.
	* @author Alexander Velikorechin
	* @since 18.01.2017
*/

public class Triangle {
	/**
	* A point.
	*/
	private Point a;
	/**
	* B point.
	*/
	private Point b;
	/**
	* C point.
	*/
	private Point c;
	/**
	* Constructor class for triangles.
	* @param a — a point
	* @param b — b point
	* @param c — c point
	*/

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Calculates area of triangle with Geron's formula.
	* @return returns area in double format
	*/

	public double area() {
		if (checkIfTriangleIsPossible()) {
			double aToB = this.a.distanceTo(this.b);
			double bToC = this.b.distanceTo(this.c);
			double cToA = this.c.distanceTo(this.a);
			double halfPer = (aToB + bToC + cToA) / 2;
			return Math.sqrt(halfPer * (halfPer - aToB) * (halfPer - bToC) * (halfPer - cToA));
		} else {
			return 0;
		}
	}

	/**
	* Checks is it possible to build such a triangle.
	* @return true — it's possible, false — it's impossible
	*/
	public boolean checkIfTriangleIsPossible() {
		boolean result = false;

		if (this.a.distanceTo(this.b)  < this.b.distanceTo(this.c)  + this.c.distanceTo(this.a) && this.b.distanceTo(this.c) < this.c.distanceTo(this.a) + this.a.distanceTo(this.b) && this.c.distanceTo(this.a) < this.a.distanceTo(this.b) + this.b.distanceTo(this.c)) {
			return true;
		}

		return result;
	}
}