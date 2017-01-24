package ru.avelikorechin.testtask;
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
		char[] subArr = sub.toCharArray();
		char[] originArr = origin.toCharArray();
		int count = 0;
		if (originArr.length >= subArr.length) {
			for (int i = 0; i < (originArr.length - subArr.length + 1); i++) {
				for (int j = 0; j < subArr.length; j++) {
					if (originArr[i + j] == subArr[j]) {
						count++;
						if (count == subArr.length) {
							return true;
						}
					} else {
						count = 0;
					}
				}
			}
		}
	return false;
	}
}