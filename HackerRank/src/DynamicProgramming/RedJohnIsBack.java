package DynamicProgramming;


import java.util.Scanner;

public class RedJohnIsBack {
	
	/*
	 * problem can be found at https://www.hackerrank.com/challenges/red-john-is-back
	 */
	
	public static int getNumCombos(int numCols){
		
		if(numCols <= 3)
			return 1;
		
		return getNumCombos(numCols-4) + getNumCombos(numCols-1);
		
	}
	

	public static int getNumPrimes(int n){

		boolean[] array = new boolean[n+1];

		for(int i = 2 ; i <= n ; i ++) array[i] = true;

		int maxSqrt = (int) Math.sqrt(n);

		for(int i = 2 ; i <= maxSqrt ; i ++ ){

			if(array[i]){

				int temp = i*i;

				while(temp <= n){
					array[temp] = false;
					temp += i;
				}

			}

		}

		int numPrimes = 0;
		for(boolean bool : array )
			if(bool)
				numPrimes++;

		return numPrimes;


	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1 ; i <= T ; i ++){
			System.out.println(RedJohnIsBack.getNumPrimes(getNumCombos(sc.nextInt())));
		}
		
	}

}
