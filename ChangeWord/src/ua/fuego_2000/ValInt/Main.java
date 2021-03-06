package ua.fuego_2000.ValInt;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		String s = "-2147483648";
		String sRes;
		int sign = 1;
		if (s.startsWith("-")) {
			sRes = s.substring(1);
			sign = -1;
		} else {
			sRes = s;
		}
		if (Pattern.matches("\\D", sRes)) {
			throw new NumberFormatException();
		} else {
			char[] ch = sRes.toCharArray();
			int result = 0;
			for (int i = 0; i < ch.length; i++) {
				int res = (int) ch[i] - 48;
				result = (int) (result + sign*res * Math.pow(10, ch.length - i - 1));
			}
			if (!s.equals("" + result)) {
				throw new NumberFormatException();
			}
			System.out.println(result);
		}
	}

}
