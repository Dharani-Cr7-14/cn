import java.util.Scanner;

public class link {
    static final int INF = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of routers: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (use 9999 for no direct link):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (i == j) cost[i][j] = 0;
            }

        for (int src = 0; src < n; src++) {
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            int[] prev = new int[n];

            for (int i = 0; i < n; i++) {
                dist[i] = INF;
                prev[i] = -1;
            }

            dist[src] = 0;

            for (int count = 0; count < n - 1; count++) {
                int u = -1, min = INF;
                for (int i = 0; i < n; i++)
                    if (!visited[i] && dist[i] < min) {
                        min = dist[i];
                        u = i;
                    }

                visited[u] = true;

                for (int v = 0; v < n; v++) {
                    if (!visited[v] && cost[u][v] != INF &&
                        dist[u] + cost[u][v] < dist[v]) {
                        dist[v] = dist[u] + cost[u][v];
                        prev[v] = u;
                    }
                }
            }

            System.out.println("\nRouting Table for Router " + (src + 1));
            System.out.println("Dest\tCost\tPath");
            for (int i = 0; i < n; i++) {
                if (i != src) {
                    System.out.print((i + 1) + "\t" + dist[i] + "\t");
                    printPath(prev, i);
                    System.out.println();
                }
            }
        }

        sc.close();
    }

    static void printPath(int[] prev, int j) {
        if (prev[j] == -1) {
            System.out.print((j + 1));
            return;
        }
        printPath(prev, prev[j]);
        System.out.print(" -> " + (j + 1));
    }
}
