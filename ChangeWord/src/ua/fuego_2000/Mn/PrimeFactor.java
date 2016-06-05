package ua.fuego_2000.Mn;

import java.util.ArrayList;

public class PrimeFactor {
	
	
	public static void main(String[] args) {
		Integer number = 120;
		ArrayList<Integer> masFactor = new ArrayList<>();
		do{
			number = getPrimeNumber(number,masFactor);
		}
		while (number!=1);
		
		System.out.println(masFactor.toString());

	}

	private static Integer getPrimeNumber(Integer number, ArrayList<Integer> masFactor) {
		int i = 2;
		do{
		if ((number%i)==0)
		{
			masFactor.add(i);
			return number/i;
		}
		else
		{
			i++;
		}
		}
		while (i<number);
		masFactor.add(number);
		return 1;
	}
}
