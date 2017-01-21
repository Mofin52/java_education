package ru.avelikorechin.loops;

/**
	* Class for creating pseudographics.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/
public class Paint {
	/**
		* Method to draw a piramid from "^" and " ".
		* @param h — height of the pyramid
		* @return Multiline string of sybmols
	*/
	public String piramid(int h) {
		final String block = "^ ";
		final String shortBlock = "^";
		final String space = " ";
		int offset = 0;
		StringBuilder piramid = new StringBuilder();
		for (int i = 1; i <= h; i++) {
			StringBuilder line = new StringBuilder();
			offset = h - i;
			for (int of = 0; of < offset; of++) {
				line.append(space);
			}
			for (int sym = 0; sym < i; sym++) {
				if (sym == i - 1) {
					line.append(shortBlock);
				} else {
					line.append(block);
				}
			}
			line.append("\n");
			piramid.append(line);
		}
		String result = piramid.toString();
		return result;
	}
}