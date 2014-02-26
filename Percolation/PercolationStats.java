/**
 * A PercolationStats class for Algs '14 to satisfy the Percolation assignment
 * 
 * @author "Tom Kelley"
 */
public class PercolationStats {
    
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
    }
    
    /**
     * Sample mean of percolation threshold.
     * @return 
     */
    public double mean() {
        return 0.0;
    }
    
    /**
     * Sample Standard Deviation of percolation threshold.
     * @return 
     */
    public double stddev() {
        return 0.0;
    }
    
    /**
     * Returns lower bound of the 95% confidence interval.
     * @return 
     */
    public double confidenceLo() {
        return 0.0;
    }
    
    /**
     * Returns upper bound of the 95% confidence interval.
     * @return 
     */
    public double confidenceHi() {
        return 0.0;
    }
    
    /**
     * Test client.
     * @param main 
     */
    public static void main(final String[] main) {
        
    }
}
