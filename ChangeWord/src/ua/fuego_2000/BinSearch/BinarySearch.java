package ua.fuego_2000.BinSearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] mas = {0,10,15,25,35,75,85,90,105,107,108};
		int x = 75;//его ищем
		int first= 0;
		int res =0;
		int last = mas.length-1;
		boolean stop = false;
		int midle =(int)((last - first)/2);
		do{
			if (mas[first] ==x){
				res = first;
				stop = true;
			}
			else if (mas[last] ==x){
				res = last;
				stop = true;
			}
			if (stop != true){
			if (mas[midle]>x){
				last = midle-1;
			}
			else if (mas[midle]<x){
				first = midle+1;
			}
			if (mas[midle]==x){
				res = midle;
				stop = true;
			}
			else{
				midle =(int)((last - first)/2);
			}
			}
		}
		while(!stop); 
		System.out.println(res);
	
	}
}
