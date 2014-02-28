/**
 * A Percolation class for Algs '14 to satisfy the Percolation assignment
 * 
 * @author "Tom Kelley"
 */
public class Percolation {
    
    private Site[][] grid;
    private int size;
    private Site top;
    private Site bottom;
    
    /**
     * Create an N-by-N grid with all sites blocked
     * 
     * @param size The size of one side of the grid to generate for this run
     */
    public Percolation(final int size) {
        this.size = size;
        grid = new Site[size][size];
        int counter = 0;
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = new Site(counter, false);
                counter++;
            }
        }
        
        top = new Site(counter, true);
        counter++;
        bottom = new Site(counter, true);
    }
    
    /**
     * Open site on row i, column j
     * @param i y coordinate of site
     * @param j x coordinate of site
     */
    public void open(final int i, final int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        grid[i-1][j-1].open();
        //TODO This is broken, please fix it.
        union(i-1, j-1, i-2, j-1);
        union(i-1, j-1, i-1, j-2);
        union(i-1, j-1, i, j-1);
        union(i-1, j-1, i-1, j);
    }
    
    public boolean[][] getGrid() {
        boolean[][] printableGrid = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                printableGrid[i][j] = grid[i][j].isOpen();
            }
        }
        return printableGrid;
    }
    
    public int[][] seeConnections() {
        int[][] connectGrid = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                connectGrid[i][j] = grid[i][j].getIndex();
            }
        }
        return connectGrid;
    }
    
    /**
     * Find out if a certain site is open
     * @param i y coordinate of site
     * @param j x coordinate of site
     * @return If the site is open, return true; else return false
     */
    public boolean isOpen(final int i, final int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        return grid[i-1][j-1].isOpen();
    }
    
    /**
     * Find out if a certain site is not open
     * @param i y coordinate of site
     * @param j x coordinate of site
     * @return If the site is open, return false; else return true
     */
    public boolean isFull(final int i, final int j) throws IndexOutOfBoundsException {
        validateArgs(i,j);
        //TODO Fix this, because it's broken
        return !grid[i-1][j-1].isOpen();
    }
    
    /**
     * Test if the system percolates or not. If the system percolates, this returns true.
     * @return True if the system percolates, false if the system does not percolate
     */
    public boolean percolates() {
        return top.getIndex() == bottom.getIndex();
    }
    
    private void validateArgs(final int i, final int j) throws IndexOutOfBoundsException {
        if(0 >= i) {
            throw new IndexOutOfBoundsException("First argument (" + i + ") is less than 1.");
        } else if(i > this.size) {
            throw new IndexOutOfBoundsException("First argument (" + i + ") is larger than the "
                    + "given size.");
        } else if(0 >= j) {
            throw new IndexOutOfBoundsException("Second argument (" + j + ") is less than 1.");
        } else if(j > this.size) {
            throw new IndexOutOfBoundsException("Second argument (" + j + ") is larger than the "
                    + "given size.");
        }
    }
    
    private void union(final int i, final int j, final int k, final int l) {
        try {
            validateArgs(k, l);
            if (grid[k][l].isOpen()) {
                unionSites(grid[i][j], grid[k][l]);
            }
        } catch(IndexOutOfBoundsException ex) {
            if(k < 1) {
                System.out.println("Connecting to top.");
                unionSites(grid[i][j], top);
            } else if(k > size) {
                System.out.println("Connecting to bottom.");
                unionSites(grid[i][j], bottom);
            } else {
                //TODO Print that this is on a side
            }
        }
    }
    
    private void unionSites(final Site one, final Site two) {
        //TODO Make this not suck
        int siteOneIndex = one.getIndex();
        
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(grid[i][j].getIndex() == siteOneIndex) {
                    grid[i][j].setIndex(two.getIndex());
                }
            }
        }
    }
    
    public class Site {
        private boolean open;
        private int index;
        
        /**
         * Make a new Site using a provided index and open state
         * @param openIndex The index of the site
         * @param isOpen The open status of the site
         */
        public Site(final int openIndex, final boolean isOpen) {
            open = isOpen;
            index = openIndex;
        }
        
        /**
         * Open the specific site
         */
        public void open() {
            open = true;
        }
        
        /**
         * Equivalent to getOpen()
         * @return the value of the open variable in this data structure
         */
        public boolean isOpen() {
            return open;
        }
        
        public int getIndex() {
            return index;
        }
        
        public void setIndex(final int index) {
            this.index = index;
        }
    }
}