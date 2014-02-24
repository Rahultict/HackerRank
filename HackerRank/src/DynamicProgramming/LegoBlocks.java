package DynamicProgramming;

import java.util.Scanner;

public class LegoBlocks {
	
	/*
	 * problem can be found at https://www.hackerrank.com/challenges/lego-blocks
	 */
	
	public static final int Max = 1001;
	public static long modMult(long x, long y, long module){
		
		long tempX = x > module ? x % module : x;
		long tempy = y > module ? y % module : y;
		long tempResult = (tempX) * (tempy);
		
		return tempResult > module ? (tempResult) % module : tempResult;
	}
	
	
	public static long getModPowerOf2(int N , long modulo){
		
		long result = 2;
		
		for(int i = 1 ; i <= N-1 ; i ++){
			
			result = result % modulo;
			
			result = result << 1;
			
		}
		
		return result;
		
	}
	
	public static long getNumCombsForSolidWall(int M , int N , int module){
		

		
		long[] solidWallArray = new long[Max]; // array is indexed by M for the give value of N
		long[] arrayNMWallCombos = new long[Max];
		long[] array1MWallCombos = new long[Max];

		for(int m = 1 ; m <= M ; m ++){


			/*
			 * load array1MWallCombos
			 */

			if(m == 1)
				array1MWallCombos[m] = 1;
			if(m == 2)
				array1MWallCombos[m] = 2;
			if(m == 3)
				array1MWallCombos[m] = 4;
			if(m == 4)
				array1MWallCombos[m] = 8;

			if(m >= 5){
				array1MWallCombos[m] =  ( (array1MWallCombos[m-1] % module) + (array1MWallCombos[m-2] % module) + (array1MWallCombos[m-3] % module) + (array1MWallCombos[m-4] % module) ) % module;
			}


			/*
			 * load arrayNMWallCombos
			 */

			//long numCombsFor1MWall = array1MWallCombos[m];
			long temp = 1;

			for(int i = 1 ; i <= N ; i ++){
				temp = LegoBlocks.modMult(array1MWallCombos[m], temp, module);
			}
			arrayNMWallCombos[m] = temp;
			
		}
			
		for(int m = 1 ; m <= M ; m ++){	
			/*
			 * load solidWallArray 
			 */

			if(m == 1)
				solidWallArray[m] = 1;

			if(m == 2){
				solidWallArray[m] = ( LegoBlocks.getModPowerOf2(N, module) - 1 ) % module;
			}

			if(m == 3){
				//	System.out.println("Mod of 4 ^ 40 "+Solution.getModPowerOf2(2*N, module));
				//	System.out.println("Mod of 2 ^ 40 "+Solution.getModPowerOf2(N, module));
				//	System.out.println("Final Modded value "+  ( Solution.getModPowerOf2(2*N, module)  - 2 * Solution.getModPowerOf2(N, module) + 1 ) % module);
				solidWallArray[m] =  ( LegoBlocks.getModPowerOf2(2*N, module)  - 2 * LegoBlocks.getModPowerOf2(N, module) + 1 ) % module;
			}

			if(m == 4){
				solidWallArray[m] =  ( ( LegoBlocks.getModPowerOf2(3*N, module) - 3 * LegoBlocks.getModPowerOf2(2*N, module) + 3 * LegoBlocks.getModPowerOf2(N, module) - 1) ) % module;
			}

			if( m >= 5 ){

				solidWallArray[m] = arrayNMWallCombos[m];

				for(int i = 1 ; i <= m -1 ; i ++){
					solidWallArray[m] -= (solidWallArray[i] * arrayNMWallCombos[m-i]) % module;
				}

			}
			while (solidWallArray[m] < 0 )
				solidWallArray[m] +=  module;

		}
		return solidWallArray[M];
	}
		
		
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int module = 1000000007;
		int T = sc.nextInt();
		for(int i = 0 ; i <= T - 1 ; i ++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(LegoBlocks.getNumCombsForSolidWall(M, N, module));
		}
	
	}

}
