package Dynamic_Programming.Tabulation;

public class TableCanSum {
    public static  void main(String[]args){
        TableCanSum canSum = new TableCanSum();
        System.out.println(canSum.canGivenElementsOfArrayAddUpToTargetSum(5000, new int[]{2, 3, 5}));
    }
    public boolean canGivenElementsOfArrayAddUpToTargetSum(int targetSum, int[] input){
        boolean[]table = new boolean[targetSum+1];
        table[0]=true;
        for(int i=0;i<=targetSum;i++){
            for (int num:input) {
                int newIndex = num+i;
                if(table[i] && newIndex<=targetSum) table[newIndex]=true;
            }
        }
        return table[targetSum];
    }
    //Time - O(m*n) Space - O(m) where m is targetSum and n is length of inputArray
}
