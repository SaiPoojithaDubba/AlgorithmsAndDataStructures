package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character,Integer> romans = new HashMap<Character, Integer>();
        romans.put('V',5);
        romans.put('I',1);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('M',1000);
        romans.put('D',500);
        char[]a = s.toCharArray();
        int output = 0;
        for(int i=0;i<a.length-1;i++){
            int current  = romans.get(a[i]);
            int next = romans.get(a[i+1]);
            if(current<next){
                output = output+(current*-1);
            }else{
                output = output+current;
            }
        }
        return output+romans.get(a[a.length-1]);
    }

    public static  void  main(String[] args){
        RomanToInteger r = new RomanToInteger();
        r.romanToInt("IX");
    }
}
