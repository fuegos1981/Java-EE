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
			String lastSimbol; 
			if (i==ss.length-1){
				lastSimbol = "";
			}
			else
			{
				lastSimbol = " ";
			}
			boolean isChange = false;
			if (counter % 3 == 0 & counter % 5 != 0){
				sb.append("Fizz"+addSimbol(ss[i])+lastSimbol);
				isChange = true;
			}
			if (counter % 5 == 0 & counter % 3 != 0) 
			{
				isChange = true;
				sb.append("Buzz"+addSimbol(ss[i])+lastSimbol);
			}
			if (counter % 5 == 0 & counter % 3 == 0) 
			{
				isChange = true;
				sb.append("FizzBuzz"+addSimbol(ss[i])+lastSimbol);
				
			}
			if (isChange == false) {
				sb.append(ss[i]+lastSimbol);
			}
			counter = counter+1;
		}
		System.out.println(sb);
		
	}

	private static String addSimbol(String string) {
		String[] masSimbol = {",","!","?","."};
		String w = string.substring(string.length()-1);
		if (Arrays.asList(masSimbol).contains(w)){
			return w;
		}
		return "";
	}

	

}
