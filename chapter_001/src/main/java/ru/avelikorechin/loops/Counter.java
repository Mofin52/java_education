package ru.avelikorechin.loops;

/**
	* Loops training class.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/

public class Counter {
	/**
		* Method sums all even numbers in given range.
		* @param start — start of range
		* @param finish — end of range
		* @return sum
	*/
	public int add(int start, int finish) {
		int result = 0;
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}