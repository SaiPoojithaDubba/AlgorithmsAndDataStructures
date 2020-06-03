public class UnionFind_Largest {
    private int id[];
    private int size[];
    private int large[];
    public UnionFind_Largest(int N) {
        id = new int[N];
        size = new int[N];
        large = new int[N];
        for(int i=0;i<N;++i){
            id[i]=i;
            size[i]=1;
            large[i]=i;
        }
    }

    private int root(int p){
        while(id[p]!=p){
            id[p]=id[id[p]];
            p=id[p];
        }
        return p;
    }

    public int find(int p) {
        return large[root(p)];
    }

    public void union(int p,int q){
        int rootp = root(p);
        int rootq = root(q);
        if(rootp == rootq) return;
        int largep = large[rootp];
        int largeq = large[rootq];
        if(size[p]<size[q]){
            id[rootp]=rootq;
            size[rootq] += size[rootp];
            if(largep>largeq) large[rootq]=largep;

        }else{
            id[rootq]=rootp;
            size[rootp] += size[rootq];
            if(largeq>largep) large[rootp]=largeq;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
}
