package Memoization;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class BestSum {
    static ArrayList<Integer> bestSum(int target, int[] arr, Dictionary<Integer,ArrayList<Integer>> dict) {
        if(dict.get(target) != null){
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
                res.add(i);
                if (shortest == null || res.size() < shortest.size()) {

                    shortest = res;
                    System.out.println(shortest);
                }
            }
        }
        System.out.println("target-------------- " + target + " " + shortest);
        dict.put(target,shortest);
        System.out.println(dict);
        return shortest;
    }

    public static void main(String[] args) {
        Dictionary<Integer, ArrayList<Integer>> map = new Hashtable<>();
        System.out.println(bestSum(4, new int[]{1,2},map));
        //System.out.println(bestSum(100, new int[]{1, 5, 25},map));
    }
}

