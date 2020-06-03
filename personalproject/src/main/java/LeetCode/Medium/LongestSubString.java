package LeetCode.Medium;

public class LongestSubString {
    public int longSubString(String s){
        char[] gfg = s.toCharArray();
        String output = String.valueOf(gfg[0]);
        String tempStorage = "";
        for(int i=1;i<gfg.length-1;i++){
            if(!output.contains(String.valueOf(gfg[i]))) {
                output = output + gfg[i];
            }
            else {
                if(tempStorage.length()<output.length()){
                    tempStorage = output;
                }
                if(gfg[i]!=gfg[i+1]) {
                    if(gfg[i]==gfg[i-1]) {
                        output = String.valueOf(gfg[i]);
                    }else{
                        int index = output.indexOf(gfg[i]);
                        output = output.substring(index+1)+gfg[i];
                    }
                }else{
                    output = "";
                }
            }
        }
        if(output.length()!=0 && gfg[gfg.length-1]!=gfg[gfg.length-2] && !output.contains(String.valueOf(gfg[gfg.length-1]))){
            output = output + gfg[gfg.length-1];
        }
        if(tempStorage.length()<output.length()){
            tempStorage = output;
        }
        return tempStorage.length();
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String []args) {
        LongestSubString l = new LongestSubString();
        //int output = l.longSubString("dvdf");
        int output = l.lengthOfLongestSubstring("abcabcbb");
        int x = 0;
    }
}
