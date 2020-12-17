package Dynamic_Programming.Tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableAllConstruct {
    public List<List<String>> getAllCombinationOfStringsForGivenTarget(String target, String[]words){
        List<List<List<String>>> table = new ArrayList<>();
        for(int i=0;i<=target.length();i++){
            table.add(new ArrayList<>());
        }
        table.set(0,new ArrayList<>(new ArrayList<>()));
        for(int i=0;i<=target.length();i++){
            for(String word:words){
                int newIndex = i+word.length();
                if(newIndex<=target.length() && target.substring(i,newIndex).equals(word)){
                    table.set(newIndex,table.get(i).)
                }
            }
        }
    }
}
