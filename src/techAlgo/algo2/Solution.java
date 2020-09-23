package techAlgo.algo2;

import java.util.Arrays;

public class Solution {
	public static int[] solution(int[] A, int[] B) {
	       
        int max = 0;
        int L = A.length;
        
        max = Arrays.stream(A).max().getAsInt();
        
        int[] TabAux = new int[max+1]; 
        
        TabAux[0] =1;
        TabAux[1] =1;

        for(int i=2; i<= max; i++){
        	
        	TabAux[i] = (TabAux[i-1] + TabAux[i-2]) % (1 << 30);
        }
        int[] results = new int[L];
        
        for(int i=0; i<L; i++){
        	
            results[i] = TabAux[A[i]] % (1 << B[i]);
        }
        return results;
    }
    
    public static void main(String[] args) {
    	int[] A = {4,4,5,5,1} ;
    	int[] B = {3,2,4,3,1} ;
    	
    	int[] result = solution(A, B) ;

    	
    	System.out.println(Arrays.toString(result));
    	
    	
    }
}
