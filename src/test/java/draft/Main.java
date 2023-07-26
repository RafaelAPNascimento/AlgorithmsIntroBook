package draft;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		String s = "AmoOmaSeRomametemamoresamoOma";
		System.out.println(is(s));


	}

	static boolean is(String str) {

		int size = str.length();
		String[] word = str.split("");
		for (int i = 0; i < size / 2; i++) {
			if (!word[i].equalsIgnoreCase(word[size - i - 1]))
				return false;
		}
		return true;
	}
}
