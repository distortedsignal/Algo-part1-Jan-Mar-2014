/**
 * A PercolationStats class for Algs '14 to satisfy the Percolation assignment
 * 
 * @author "Tom Kelley"
 */

import java.lang.Math;

public class PercolationStats {
    
    int[] percAfterOpens = {};
    
    /**
     * Perform T independent computational experiments on an N-by-N grid.
     * @param N
     * @param T 
     */
    public PercolationStats(final int N, final int T) {
        if(N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Neither N (" + N + ") nor T ("
                    + T + ") can be negative.");
        }
        int counter = 0, rand1, rand2;
        
        for(int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            while(!p.percolates()) {
                //TODO FIX THIS BECAUSE IT'S AWFUL
                while(true) {
                    rand1 = StdRandom.uniform(1, N);
                    rand2 = StdRandom.uniform(1, N);

                    if(p.isFull(rand1, rand2)) {
                        p.open(rand1, rand2);
                        break;
                    }
                }
                counter++;
            }
            
            int[] newAfterOpens = new int[percAfterOpens.length + 1];
            System.arraycopy(percAfterOpens, 0, newAfterOpens, 0, 
                    percAfterOpens.length);
            newAfterOpens[percAfterOpens.length] = counter;
            percAfterOpens = newAfterOpens;
        }
    }
    
    /**
     * Sample mean of percolation threshold.
     * @return 
     */
    public double mean() {
        return StdStats.mean(percAfterOpens);
    }
    
    /**
     * Sample Standard Deviation of percolation threshold.
     * @return 
     */
    public double stddev() {
        return StdStats.stddev(percAfterOpens);
    }
    
    /**
     * Returns lower bound of the 95% confidence interval.
     * @return 
     */
    public double confidenceLo() {
        return mean() - halfConfidenceRange();
    }
    
    /**
     * Returns upper bound of the 95% confidence interval.
     * @return 
     */
    public double confidenceHi() {
        return mean() + halfConfidenceRange();
    }
    
    private double halfConfidenceRange() {
        return (1.96 * stddev()) / Math.sqrt((double)percAfterOpens.length);
    }
    
    /**
     * Test client.
     * @param main 
     */
    public static void main(final String[] main) {
        
    }
}
