package Dynamic_Programming.Tabulation;

public class TableGridTraveller {
    public static void main(String[]args){
        TableGridTraveller traveller = new TableGridTraveller();
        System.out.println(traveller.getNumberOfWaysOneCanTravelInGivenGrid(3,3));
    }
    public int getNumberOfWaysOneCanTravelInGivenGrid(int rows, int columns){
        int newRows = rows+1;
        int newColumns = columns+1;
        int[][]table = new int[newRows][newColumns];
        table[1][1]=1; //Seed or base case for the table
        for(int i=0;i<newRows;i++){
            for(int j=0;j<newColumns;j++){
                if(i+1<newRows) table[i+1][j]+=table[i][j]; //add current value to next row i.e, moving down in grid
                if(j+1<newColumns) table[i][j+1]+=table[i][j];//add current value to next col i.e, moving right in grid
            }
        }
        return table[rows][columns];
    }

    //Time - O(n*m) Space - O(n*m)
}
