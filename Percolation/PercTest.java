public class PercTest {
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        
        printGrid(p.getGrid());
        printGrid(p.seeConnections());
        p.open(1,1);
        System.out.println();
        printGrid(p.getGrid());
        printGrid(p.seeConnections());
        System.out.println();
        p.open(1,3);
        printGrid(p.getGrid());
        printGrid(p.seeConnections());
        System.out.println();
        p.open(2,3);
        printGrid(p.getGrid());
        printGrid(p.seeConnections());
        System.out.println();
        System.out.println("Percolates? " + p.percolates());
        p.open(3,3);
        printGrid(p.getGrid());
        printGrid(p.seeConnections());
        System.out.println("Percolates? " + p.percolates());
    }
    
    private static void printGrid(final boolean[][] s) {
        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < s.length; j++) {
                if(s[i][j]) {
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
        }
    }
    
    private static void printGrid(final int[][] s) {
        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < s.length; j++) {
                System.out.print(s[i][j]);
            }
            System.out.print("\n");
        }
    }
}