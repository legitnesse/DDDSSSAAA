package F331A;

/** This class measures the performance of the permutation algorithms */

import java.util.Random;

public class PermutationTester {
	public static void main(String[] arg) {
		Permutations p = new Permutations();
		
		int[] perm = new int[6];
		p.algorithm1(perm);
		
        perm = new int[6];
        p.algorithm2(perm);

        perm = new int[6];
        p.algorithm3(perm);
	}

}
