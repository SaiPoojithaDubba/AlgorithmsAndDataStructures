import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationStats {
    private double[] results;
    private int T;
    private int N;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new java.lang.IllegalArgumentException();

        this.N = N;
        this.T = T;
        double NSquare = N * N;
        results = new double[T];
        Percolation perc;
        for (int k = 0; k < T; ++k) {
            perc = new Percolation(N);

            int i = 0;
            int j = 0;
            int openNum = 0;
            while (!perc.percolates()) {
                i = StdRandom.uniform(1, N+1);
                j = StdRandom.uniform(1, N+1);
                if (perc.isOpen(i,j))
                    continue;
                perc.openSite(i,j);
                openNum++;
            }

            results[k] = openNum / NSquare;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

    // take two args N and T
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(N, T);
        System.out.printf("mean                    = %f%n", ps.mean());
        System.out.printf("stddev                  = %f%n", ps.stddev());
        System.out.printf("95%% confidence interval = %f, %f%n", ps.confidenceLo(), ps.confidenceHi());
    }
}