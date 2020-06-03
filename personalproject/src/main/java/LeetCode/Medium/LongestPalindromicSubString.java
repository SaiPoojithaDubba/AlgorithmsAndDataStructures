package LeetCode.Medium;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        if(s.length()==1 || s.length()==0){
            return s;
        }
        char[]a = s.toCharArray();
        String longestPalindrome = "";
        String tempStorage = "";
        if(a.length==2){
            if(a[0]==a[1]){
                return s;
            }
            else return  String.valueOf(a[0]);
        }
        if(a.length==3){
            if(a[0]==a[1]) tempStorage = tempStorage+a[0]+a[1];
            else if(a[1]==a[2]) tempStorage = tempStorage+a[1]+a[2];
        }
        for(int i=0,j=1,k=2;i<a.length-2;i++,j++,k++){
            if(a[i]==a[k]){
                longestPalindrome = String.valueOf(a[i])+a[j]+a[k];
                if(i==0 && k==a.length-1){
                    break;
                }
                else {
                    if(i==0){
                        if(a[i+1]!=a[k+1]){
                            longestPalindrome="";
                        }else {

                        }
                    }else {
                        int temp = i - 1;
                        int temp2 = k + 1;
                        while (temp >= 0 && temp2 <= a.length - 1) {
                            if (a[temp] == a[temp2]) {
                                longestPalindrome = longestPalindrome + a[temp] + a[temp2];
                                temp--;
                                temp2++;
                            } else {
                                break;
                            }
                        }
                    }
                   break;
                }
            }else{
                if(a[i]==a[j]){
                    tempStorage = tempStorage+a[i]+a[j];
                }
                continue;
            }
        }
        if(longestPalindrome.equals("")){
            if(!tempStorage.equals("")) longestPalindrome=tempStorage;
            else longestPalindrome = String.valueOf(a[0]);
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        LongestPalindromicSubString l = new LongestPalindromicSubString();
        String output = l.longestPalindrome("babab");
        int x= 1;
    }
}
