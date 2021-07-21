package Memoization;

import java.util.Arrays;
import java.util.HashMap;

public class CountConstruct {
    static int countConstruct1(String word,String[] wordBank,HashMap<String,Integer> map){
        if(map.containsKey(word)){
            return map.get(word);
        }
        if(word.equals("")){
            return 1;
        }
        int totalCount = 0;
        for(String i : wordBank){
            if(word.indexOf(i) == 0){
               int ways = countConstruct1(word.substring(i.length()),wordBank,map);
                totalCount += ways;
            }
        }
        map.put(word,totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
       HashMap<String,Integer> map = new HashMap<>();
        System.out.println(countConstruct1("abcdef",new String[]{"ab","abc","cd","def","abcd"},map));
        //map.clear();
        System.out.println(countConstruct1("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},map));
        //map.clear();
        System.out.println(countConstruct1("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"},map));
        //map.clear();
        System.out.println(countConstruct1("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},map));
    }
}
