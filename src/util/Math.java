package util;

public class Math {

	public static int getNextPrimeNumer(int number) {
		number++;
		while(!isPrime(number)) {
			number++;
		}
		return number;
	}
	
	private static boolean isPrime(int number) {
		int count = 0;
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) { 
				count++; 
				if(count > 2) { return false; }
			}
		}
		return true;
	}
}
