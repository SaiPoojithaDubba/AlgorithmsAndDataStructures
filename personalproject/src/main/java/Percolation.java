import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean [][]grid;
    private WeightedQuickUnionUF uf; //for percolation
    private WeightedQuickUnionUF ufBack; //for full
    private int N;
    private int sz;
    public Percolation(int N) {
        if(N<=0){
            throw new IllegalArgumentException();
        }
        grid = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                grid[i][j] = false;
            }
        }
        this.N = N;
        this.sz = (N*N)+2;
        int NSquare = N*N;
        uf = new WeightedQuickUnionUF(sz);
        ufBack = new WeightedQuickUnionUF(sz-1);
        for(int i=0;i<sz;i++) {
            uf.union(0,i);
            ufBack.union(0,i);
            uf.union(sz-1,sz-1-i);
        }
    }

    //open Site
    public void openSite(int i,int j){
        validArguments(i,j);
        grid[i-1][j-1] = true;
        int idx = posToIndex(i,j);
        if(i>1 && isOpen(i-1,j)){
            uf.union(idx,posToIndex(i-1,j));
            ufBack.union(idx,posToIndex(i-1,j));
        }
        if(i<N && isOpen(i+1,j)){
            uf.union(idx,posToIndex(i+1,j));
            ufBack.union(idx,posToIndex(i+1,j));
        }
        if(j>1 && isOpen(i,j-1)){
            uf.union(idx,posToIndex(i,j-1));
            ufBack.union(idx,posToIndex(i,j-1));
        }
        if(j<N && isOpen(i,j+1)){
            uf.union(idx,posToIndex(i,j+1));
            ufBack.union(idx,posToIndex(i,j+1));
        }
    }

    //does system percolates
    public boolean percolates(){
        if(N==1) return isOpen(1,1);
        return uf.connected(1,sz-1);
    }

    public boolean isOpen(int i, int j) {
        validArguments(i,j);
        return grid[i-1][j-1];
    }

    //is site full
    public boolean isFull(int i,int j) {
        validArguments(i,j);
        return isOpen(i,j) && ufBack.connected(posToIndex(i,j),0);

    }

    private void validArguments(int i, int j){
        if(i<1 || i>N || j<1 || j>N) throw new IndexOutOfBoundsException();
    }

    private int posToIndex(int i, int j) {
        return (i-1)*N +j;
    }
}