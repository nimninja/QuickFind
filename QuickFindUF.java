import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickFindUF {

    private int[] id;

    // TODO: Implement the constructor
    // Initialize id[] so that each object is its own component (id[i] = i)
    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

    }

    // TODO: Implement connected()
    // Return true if p and q are in the same component
    public boolean connected(int p, int q) {
        // YOUR CODE HERE
        return id[q]==id[p]; // placeholder
    }

    // TODO: Implement union()
    // Merge the components containing p and q
    // HINT: Save id[p] to a variable BEFORE the loop — why does this matter?
    public void union(int p, int q) {
        int pval = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i]==pval) {
                id[i] = id[q];
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        // -------------------------------------------------------
        // EXAMPLE TEST (provided) — do not modify
        // -------------------------------------------------------
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        // After union(4,3) and union(3,8), nodes 4 and 8 should be connected
        System.out.println("Test 1 (expect true):  " + uf.connected(4, 8));

        // -------------------------------------------------------
        // YOUR TESTS — write 4 more tests below
        // Each test should print a label and the expected result
        // -------------------------------------------------------

        // Test 2: nodes not yet connected should return false
        // TODO: Write your test here
        QuickFindUF uff = new QuickFindUF(8);
        uf.union(4, 3);
        uf.union(3, 8);
        // After union(4,3) and union(3,8), nodes 4 and 8 should be connected
        System.out.println("Test 2 (expect false):  " + uf.connected(2, 8));

        // Test 3: a node is always connected to itself
        // TODO: Write your test here
        QuickFindUF ufff = new QuickFindUF(8);
        uf.union(4, 3);
        uf.union(3, 8);
        // After union(4,3) and union(3,8), nodes 4 and 8 should be connected
        System.out.println("Test 3 (expect true):  " + uf.connected(2, 2));

        // Test 4: union is transitive — 0-1 and 1-2 means 0-2 connected
        // TODO: Write your test here
        QuickFindUF uffff = new QuickFindUF(8);
        uf.union(4, 3);
        uf.union(4, 8);
        // After union(4,3) and union(3,8), nodes 4 and 8 should be connected
        System.out.println("Test 4 (expect true):  " + uf.connected(3, 8));

        // Test 5: union(p, q) where p and q are already connected — no change
        // TODO: Write your test here
        QuickFindUF ufffff = new QuickFindUF(8);
        uf.union(4, 3);
        uf.union(3, 4);
        // After union(4,3) and union(3,8), nodes 4 and 8 should be connected
        System.out.println("Test 5 (expect true):  " + uf.connected(3, 4));

        // -------------------------------------------------------
        // FILE TESTS — read union commands from a file using Scanner
        // Run with: java QuickFindUF < tinyUF.txt
        //
        // File format (tinyUF.txt):
        //   Line 1:        N  (number of objects)
        //   Lines 2+:      p q  (pairs to union if not already connected)
        // -------------------------------------------------------

        // Test 6 — tinyUF.txt (10 objects, 11 pairs)
        // Run with: java QuickFindUF < tinyUF.txt
        // After processing all pairs, check: are nodes 0 and 7 connected? (expect true)
        // TODO: Read N from Scanner, build QuickFindUF, process all pairs, then print:
        String fname = "tinyUF.txt";
        Scanner scanner = new Scanner(new File(fname));
        QuickFindUF uf6 = new QuickFindUF(scanner.nextInt());


        while(scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf6.union(p,q);
        }
        System.out.println("Test 6 (expect true):  " + uf6.connected(0, 7));

        // Test 7 — mediumUF.txt (larger file)
        // Run with: java QuickFindUF < mediumUF.txt
        // After processing all pairs, check: are nodes 0 and 1 connected? (expect true)
        // TODO: Read N from Scanner, build QuickFindUF, process all pairs, then print:
        String fnamem = "MediumUF.txt";
        Scanner scannerr = new Scanner(new File(fnamem));
        QuickFindUF uf7 = new QuickFindUF(scannerr.nextInt());
        while(scannerr.hasNext()) {
            int p = scannerr.nextInt();
            int q = scannerr.nextInt();
            uf7.union(p,q);
        }
        System.out.println("Test 7 (expect true):  " + uf7.connected(0, 1));
    }
}
