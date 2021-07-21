package Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

//    static ArrayList<ArrayList<String>> allConstruct(String word, String[] wordBank, Map<String,ArrayList<ArrayList<String>>> map){
//        if(map.containsKey(word)){
//            return map.get(word);
//        }
//        if(word.equals("")){
//            ArrayList<ArrayList<String>> tmp = new ArrayList<>();
//            ArrayList<String> list = new ArrayList<>();
//            tmp.add(list);
//            return tmp;
//        }
//        ArrayList<ArrayList<String>> result = new ArrayList<>();
//        for(String i : wordBank){
//            if(word.indexOf(i) == 0){
//                String suffix = word.substring(i.length());
//                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix,wordBank,map);
//                ArrayList<ArrayList<String>> targetWays = new ArrayList<>();
//                for(ArrayList<String> suffixWay : suffixWays){
//                    ArrayList<String> temp = new ArrayList<>(suffixWay);
//                    temp.add(0,word);
//                    targetWays.add(temp);
//                }
//                result.addAll(targetWays);
//            }
//        }
//        map.put(word,result);
//        return result;
//    }
    static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) {
            List<List<String>> tmp = new ArrayList<>();
            List<String> list = new ArrayList<>();
            tmp.add(list);
            return tmp; // a list with one element [[]]
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> suffixWay : suffixWays) {
                    List<String> tmp = new ArrayList<>(suffixWay);
                    tmp.add(0, word);
                    targetWays.add(tmp);
                }
                result.addAll(targetWays);
            }
        }
        memo.put(target, result);
        return result;
    }
    public static void main(String[] args) {
        Map<String,List<List<String>>> map = new HashMap<>();
        System.out.println(allConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd","ef","c"},map));
        map.clear();
        System.out.println(allConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},map));
        map.clear();
        System.out.println(allConstruct("purple", new String[]{"purp","p","ur","le","ot","purpl"},map));
        map.clear();
        //System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},map));
    }
}
