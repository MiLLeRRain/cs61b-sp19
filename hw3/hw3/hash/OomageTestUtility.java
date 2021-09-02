package hw3.hash;

import java.util.*;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int n = oomages.size();
//        Map<Integer, Integer> checker = new HashMap<>();
//        for (Oomage oomage : oomages) {
//            int key = (oomage.hashCode() & 0x7FFFFFFF) % M;
//            if (!checker.containsKey(key)) checker.put(key, 1);
//            else checker.put(key, checker.get(key) + 1);
//        }
//        for (Integer i : checker.values()) {
//            if (i > n / 2.5 || i < n / 50) return false;
//        }
        int[] bucket = new int[M];
        for (Oomage o : oomages) {
            bucket[(o.hashCode() & 0x7FFFFFFF) % M] += 1;
        }
        for (int b : bucket) {
            if (b > n / 2.5 || b < n / 50) return false;
        }
        return true;
    }
}
