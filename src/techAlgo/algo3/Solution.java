package techAlgo.algo3;

import java.util.Arrays;

public class Solution{

    public static int solution(int[] A) {
        int arrayLength = A.length;
        int MaxA = 0;
        for (int i = 0; i < arrayLength; i++) {
            A[i] = Math.abs(A[i]);
        }

        int SommeA =  Arrays.stream(A).sum();
        int[] Tfn = new int[SommeA + 1];
        
        
        MaxA =  Arrays.stream(A).max().getAsInt();
        int[] Tnbr = new int[MaxA + 1];
        
        
        for (int i = 0; i < arrayLength; i++) {
        	Tnbr[A[i]] += 1;
        }
        
        Arrays.fill(Tfn, -1);
        Tfn[0] = 0;
        
        
        for (int i = 1; i < MaxA + 1; i++) {
            if (Tnbr[i] > 0) {
                for(int j = 0; j < SommeA; j++) {
                    if (Tfn[j] >= 0) {
                    	Tfn[j] = Tnbr[i];
                    } else if (j >= i && Tfn[j - i] > 0) {
                    	Tfn[j] = Tfn[j - i] - 1;
                    }
                }
            }
        }
        int result = SommeA;
        for (int i = 0; i < Math.floor(SommeA / 2) + 1; i++) {
            if (Tfn[i] >= 0) {
                result = Math.min(result, SommeA - 2 * i);
            }
        }
        return result;
    }

    
    
    public static void main(String args[]) {
        int[] array = {1,5,2,-2};
        System.out.println(solution(array));
    }
}
