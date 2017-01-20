package ru.avelikorechin.loops;

/**
	* Loops training class.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/

public class Factorial {
	/**
		* Calculates factorial of given number.
		* @param number — number to calculate factorial of
		* @return returns factorial
	*/
	public int factorial(int number) {
		int result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
}