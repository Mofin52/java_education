package ru.avelikorechin.testtask;
import java.util.Arrays;
/**
	* Class to work with substrings.
	* @author Alexander Velikorechin
	* @since 22.01.2017
*/
public class Substr {
	/**
		* Method checks if sub is a substring of origin string.
		* @param origin — String to find in
		* @param sub — given substring
		* @return true — sub is substring of origin, false — sub is not in origin
	*/
	public boolean contains(String origin, String sub) {
		char[] subArr = new char[sub.length()];
		for (int i = 0; i < sub.length(); i++) {
			subArr[i] = sub.charAt(i);
		}
		char[][] originArr = new char[origin.length() - sub.length() + 1][sub.length()];
		for (int i = 0; i < (origin.length() - sub.length() + 1); i++) {
			for (int j = 0; j < sub.length(); j++) {
				originArr[i][j] = origin.charAt(i + j);
			}
		}
		for (int i = 0; i < originArr.length; i++) {
			if (Arrays.equals(originArr[i], subArr)) {
				return true;
			}
		}
	return false;
	}
}