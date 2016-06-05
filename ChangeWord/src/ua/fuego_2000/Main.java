package ua.fuego_2000;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String str = "dfjdkfjd jdkfjdkf jdfjdf, djfdkf djfkdj! dfj dkfj djf jkdj dj dk dj kjdk fjd kd";
		ChangeWord(str);

	}

	private static void ChangeWord(String str) {
		String[] ss = str.split(" ");
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int i = 0; i < ss.length; i++) {
			boolean onlySpace = false;
			if (counter % 5 == 0 & counter % 3 == 0) 
			{
				sb.append("FizzBuzz");
				
			}
			else if (counter % 3 == 0){
				sb.append("Fizz");
			}
			else if (counter % 5 == 0) 
			{
				sb.append("Buzz");
			}
			else {
				sb.append(ss[i]);
				onlySpace = true;
			}
			counter = counter+1;
			if (i == ss.length-1){
				
			}
			else if (onlySpace) {
				sb.append(" ");
			}
			else
			{
				sb.append(addSimbol(ss[i]));
			}
		}
		System.out.println(sb);
		
	}

	private static String addSimbol(String string) {
		String[] masSimbol = {",","!","?","."};
		String w = string.substring(string.length()-1);
		if (Arrays.asList(masSimbol).contains(w)){
			return w+" ";
		}
		return " ";
	}

	

}
