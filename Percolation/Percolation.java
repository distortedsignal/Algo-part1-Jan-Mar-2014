/**
 * A class for Algs '14 to satisfy the Percolation assignment
 * 
 * @author "Tom Kelley"
 */
public class Percolation {
    
    private Site[][] grid;
    private int size;
    
    /**
     * Create an N-by-N grid with all sites blocked
     * 
     * @param N The size of one side of the grid to generate for this run
     */
    public Percolation(int N) {
        this.size = N;
        grid = new Site[N][N];
        int counter = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = new Site(counter, false);
                counter++;
            }
        }
    }
    
    /**
     * Open site on row i, column j
     * @param i y coordinate of site
     * @param j x coordinate of site
     */
    public void open(int i, int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        grid[i][j].open();
        
    }
    
    /**
     * Find out if a certain site is open
     * @param i y coordinate of site
     * @param j x coordinate of site
     * @return If the site is open, return true; else return false
     */
    public boolean isOpen(int i, int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        return grid[i][j].isOpen();
    }
    
    /**
     * Find out if a certain site is not open
     * @param i y coordinate of site
     * @param j x coordinate of site
     * @return If the site is open, return false; else return true
     */
    public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        return !grid[i][j].isOpen();
    }
    
    /**
     * Test if the system percolates or not. If the system percolates, this returns true.
     * @return True if the system percolates, false if the system does not percolate
     */
    public boolean percolates() {
        return true;
    }
    
    private void validateArgs(int i, int j) throws IndexOutOfBoundsException {
        if(0 >= i) {
            throw new IndexOutOfBoundsException("First argument (" + i + ") is less than 1.");
        } else if(i >= this.size) {
            throw new IndexOutOfBoundsException("First argument (" + i + ") is larger than the given size.");
        } else if(0 >= j) {
            throw new IndexOutOfBoundsException("Second argument (" + j + ") is less than 1.");
        } else if(j >= this.size) {
            throw new IndexOutOfBoundsException("Second argument (" + j + ") is larger than the given size.");
        }
    }
    
    private class Site {
        private boolean open;
        private int index;
        
        /**
         * Make a new Site using a provided index and open state
         * @param openIndex The index of the site
         * @param isOpen The open status of the site
         */
        public Site(int openIndex, boolean isOpen) {
            this.open = isOpen;
            this.index = openIndex;
        }
        
        /**
         * Open the specific site
         */
        public void open() {
            this.open = true;
        }
        
        /**
         * Equivalent to getOpen()
         * @return the value of the open variable in this data structure
         */
        public boolean isOpen() {
            return this.open;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        public void setIndex(int index) {
            this.index = index;
        }
    }
}