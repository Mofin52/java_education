package ru.avelikorechin.conditions;

/**
	* Class for finding maximum of given numbers.
	* @author Alexander Velikorechin
	* @since 19.01.2017
*/

public class Max {
	/**
	* Finds maximum of two numbers.
	* @param first — First number
	* @param second — Second number
	* @return the maximum of two
	*/
	public int max(int first, int second) {
		return (first > second) ? first : second;
	}

	/**
	* Finds maximum of three numbers.
	* @param first — First number
	* @param second — Second number
	* @param third — Third number
	* @return the maximum of three
	*/
	public int max(int first, int second, int third) {
		int maxOfFirstTwo = max(first, second);
		return max(maxOfFirstTwo, third);
	}
}