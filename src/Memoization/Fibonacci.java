package Memoization;

import java.util.HashMap;

public class Fibonacci {
    // Simple fibonacci recursive function
    // ]Time:- O(2^n) Space:- O(n)
    static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //enhanced version using dynamic programming
    // s we know there are many same calls that may create there another full large calls
    // why dont we just store those calls in memory and if the recursion calls same
    // call then we just return the value computed and stored in memo
    //and that is the memoization
    //Time:- O(n) Space:- O(n)
    static int fibonacci2(int n, HashMap<Integer,Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n <= 2){
            return 1;
        }
        map.put(n,fibonacci2(n-1,map) + fibonacci2(n-2,map));
        return map.get(n);
    }

    public static void main(String[] args) {
        //System.out.println(fibonacci(50));
        HashMap<Integer,Integer> map = new HashMap<>();
       System.out.println(fibonacci2(50,map));
    }
}
