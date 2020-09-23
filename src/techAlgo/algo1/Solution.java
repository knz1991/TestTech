package techAlgo.algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
	 public static int[] solution(int N, int[] A) {
	        int max = 0, min = 0, prec;
	        int[] Res = new int[N];
	        
	        for(int i = 0; i < A.length; i++)
	        {
	        	prec = A[i]-1;
	            if(A[i] <= N && A[i] >= 1)
	            {
	            	Res[prec] = Math.max(min,Res[prec]) + 1;
	            	max = Math.max(max,Res[prec]);
	            }else if(A[i] == N + 1)
	            {
	            	min = max;
	            }
	        }
	        
	        for (int i = 0 ; i < N ; i++)
	        {
	        	Res[i] = Math.max(Res[i],min);
	        }
	        
	        return Res;
	    }
	 
	 public static void main(String[] args) {
		 
			int[] A = {3,4,4,6,1,4,4} ;
	    	int[] result = solution(5, A) ;
	    	System.out.println(Arrays.toString(result));
	    	
		}
}
