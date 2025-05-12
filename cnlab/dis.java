import java.util.Scanner;

public class dis {
    static final int INF = 9999;
    static final int MAX = 10;

    static int[][] dist = new int[MAX][MAX];
    static int[][] from = new int[MAX][MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.print("Enter number of routers: ");
        n = sc.nextInt();

        int[][] cost = new int[n][n];

        System.out.println("Enter cost matrix (use " + INF + " for no direct link):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (i == j) cost[i][j] = 0;
                dist[i][j] = cost[i][j];
                from[i][j] = j;
            }
        }

        // Distance Vector Algorithm
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dist[i][j] > cost[i][k] + dist[k][j]) {
                            dist[i][j] = cost[i][k] + dist[k][j];
                            from[i][j] = k;
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);

        // Display routing tables
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting Table for Router " + (i + 1));
            System.out.println("Destination\tDistance\tNext Hop");
            for (int j = 0; j < n; j++) {
                System.out.println((j + 1) + "\t\t" + dist[i][j] + "\t\t" + (from[i][j] + 1));
            }
        }

        sc.close();
    }
}