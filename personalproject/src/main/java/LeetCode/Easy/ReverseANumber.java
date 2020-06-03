package LeetCode.Easy;

public class ReverseANumber {

    public int reverse(int x){
        int num = x;
        int rev = 0;
        while(num>0){
            int pop = num%10;
            num=num/10;
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE && pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE && pop<-8)) return 0;
            rev = rev*10+pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int number = 1534236469;
        ReverseANumber r = new ReverseANumber();
        r.reverse(number);
        int output =0;
    }
}
