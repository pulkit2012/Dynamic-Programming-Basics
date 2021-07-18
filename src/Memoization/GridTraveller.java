package Memoization;

import java.util.HashMap;

public class GridTraveller {
    static int gridTraveller(int m, int n, HashMap<String, Integer> map) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        String cell = new String(m + "," + n);
        if(map.containsKey(cell)){
            return map.get(cell);
        }

        map.put(cell,gridTraveller(m-1,n,map) + gridTraveller(m,n-1,map));
        return map.get(cell);
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        System.out.println(gridTraveller(1, 1,map));
        System.out.println(gridTraveller(2, 3,map));
        System.out.println(gridTraveller(3, 2,map));
        System.out.println(gridTraveller(3, 3,map));
        System.out.println(gridTraveller(18, 18,map));
    }
}
