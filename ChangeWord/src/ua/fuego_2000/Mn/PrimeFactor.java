package ua.fuego_2000.Mn;

import java.util.ArrayList;

public class PrimeFactor {

	public static void main(String[] args) {
		Integer number = 120;
		ArrayList<Integer> masFactor = new ArrayList<>();
		while (number != 1) {
			number = getPrimeNumber(number, masFactor);
		}

		System.out.println(masFactor.toString());

	}

	private static Integer getPrimeNumber(Integer number, ArrayList<Integer> masFactor) {
		int i = 2;
		while (i < number) {
			if ((number % i) == 0) {
				masFactor.add(i);
				return number / i;
			} else {
				i++;
			}
		}
		masFactor.add(number);
		return 1;
	}
}
