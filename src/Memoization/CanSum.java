package Memoization;

import java.util.HashMap;

public class CanSum {

    static boolean canSum(int target, int[] arr, HashMap<Integer,Boolean> map) {
        if(map.containsKey(target)){
            return map.get(target);
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int i : arr) {
            int remaining = target - i;
            if (canSum(remaining, arr,map)) {
                map.put(remaining,true);
                return true;
            }
        }
        map.put(target,false);
        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int[] arr = {5, 3, 4, 7};
        System.out.println(canSum(7,arr,map));
        System.out.println(canSum(300, new int[]{7,14},map));
    }
}
