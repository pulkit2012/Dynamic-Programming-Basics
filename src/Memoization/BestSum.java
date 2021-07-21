package Memoization;

import java.util.*;

public class BestSum {
    static ArrayList<Integer> bestSum(int target, int[] arr, Map<Integer,ArrayList<Integer>> dict) {
        if(dict.containsKey(target)){
            return dict.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> shortest = null;
        for (int i : arr) {
            int remaining = target - i;
            ArrayList<Integer> res = bestSum(remaining, arr,dict);
            if (res != null) {
                ArrayList<Integer> combi = new ArrayList<>();
                combi.addAll(res);
                combi.add(i);
                if (shortest == null || combi.size() < shortest.size()) {
                    shortest = combi;
                }
            }
        }
        dict.put(target,shortest);
        return shortest;
    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map = new Hashtable<>();
        System.out.println(bestSum(100, new int[]{1,2,5,25},map));
        //System.out.println(bestSum(100, new int[]{1, 5, 25},map));
    }
}

