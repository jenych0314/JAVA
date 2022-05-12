public class GraphMatrix {
    int size;
    boolean directed;
    int[][] edges;
    boolean[] visited;

    GraphMatrix(int size, boolean directed) {
        this.size = size;
        this.directed = directed;
        this.edges = new int[size][size];
        // this.visited = new boolean[size];
    }

    public void add(int v1, int v2) {
        this.edges[v1][v2] = 1;
        if (!this.directed) {
            this.edges[v2][v1] = 1;
        }
    }

    public void DFS(int v) {
        this.visited = new boolean[size];
        printDFS(v);
        System.out.println();
    }

    public void printDFS(int v) {
        this.visited[v] = true;
        System.out.print(v + " -> ");
        for (int i = 0; i < this.size; i++) {
            if (this.edges[v][i] == 1 && this.visited[i] == false)
                printDFS(i);
        }
    }

    public static void main(String[] args) {
        GraphMatrix graphMatrix = new GraphMatrix(8, false);
        graphMatrix.add(0, 1);
        graphMatrix.add(0, 2);
        graphMatrix.add(1, 3);
        graphMatrix.add(1, 5);
        graphMatrix.add(2, 7);
        graphMatrix.add(3, 4);
        graphMatrix.add(3, 7);
        graphMatrix.add(4, 5);
        graphMatrix.add(5, 6);
        graphMatrix.add(6, 7);

        graphMatrix.DFS(0);
        graphMatrix.DFS(7);
    }
}
