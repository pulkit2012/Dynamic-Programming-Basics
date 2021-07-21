package Memoization;

import java.util.HashMap;

public class CanConstruct {
    static boolean canConstruct1(String word, String[] wordBank, HashMap<String,Boolean> map){
        if(map.containsKey(word)){
            return map.get(word);
        }
        if(word.equals("")){
            return true;
        }
        for(String i : wordBank){
            if(word.indexOf(i) == 0){
                String suffix = word.substring(i.length());
                if(canConstruct1(suffix,wordBank,map)){
                    map.put(word,true);
                    return true;
                }
            }
        }
        map.put(word,false);
        return false;
    }

    public static void main(String[] args) {
        HashMap<String,Boolean> map = new HashMap<>();
        System.out.println(canConstruct1("abcdef",new String[]{"ab","abc","cd","def","abcd"},map));
        map.clear();
        System.out.println(canConstruct1("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},map));
        map.clear();
        System.out.println(canConstruct1("enterapotentpot", new String[]{"a","p","ent","enter","ot","o","t"},map));
        map.clear();
        System.out.println(canConstruct1("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},map));
    }
}
