package F331A;

public class PermutationMeasurer {
    public static void main(String[] args) {
        Permutations p = new Permutations(); int
        reps = 5;
        int[] sizes = {50000, 100000, 200000, 400000, 800000, 1600000, 3200000, 6400000};
        for (int i = 0; i < sizes.length; i++) {
        long totalSteps = 0;
        double start = System.currentTimeMillis();
        for (int j = 0; j < reps; j++) {
        int[] data = new int[sizes[i]];
        p.algorithm3(data);
        totalSteps += p.getStepCounter();
        }
        double stop = System.currentTimeMillis();
        System.out.println("" + sizes[i] + ", " + totalSteps/reps + ", " +(stop - start)/reps);
        }
    }
}
