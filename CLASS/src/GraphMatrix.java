interface Graph {
    public void add(int source, int destination, int weight);

    public int getWeight(int source, int destination);

    public int getSize();

    public boolean isDirected();

    public void print();
}

public class GraphMatrix implements Graph {
    int size;
    boolean directed;
    int[][] edges;
    int[] distance;
    boolean[] visited;
    int MAX_VALUE = 10000000;

    GraphMatrix(int size, boolean directed) {
        this.size = size;
        this.directed = directed;
        this.edges = new int[size][size];
        this.distance = new int[size];
        this.visited = new boolean[size];
    }

    public void add(int v1, int v2) {
        add(v1, v2, 1);
    }

    public void add(int src, int dest, int weight) {
        // check range src and dest: 0 <= src, dest < size
        // check weight: weight >= 0
        this.edges[src][dest] = weight;
        if (!this.directed)
            this.edges[dest][src] = weight;
    }

    public int getWeight(int src, int dest) {
        // check range src and dest: 0 <= src, dest < size
        // check weight: weight >= 0
        return this.edges[src][dest];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isDirected() {
        return this.directed;
    }

    public void DFS(int v) {
        this.visited = new boolean[size];
        dfsInternal(v);
        System.out.println();
    }

    public void dfsInternal(int v) {
        this.visited[v] = true;
        System.out.print(v + " -> ");
        for (int i = 0; i < this.size; i++) {
            if (this.edges[v][i] == 1 && this.visited[i] == false)
                dfsInternal(i);
        }
    }

    public void shortestPath(int v) {
        // found와 distance 배열 선언 및 초기화
        int u, w;
        for (int i = 0; i < this.size; i++) {
            visited[i] = false;
            distance[i] = edges[v][i];
        }

        // 시작 정점을 S에 추가
        visited[v] = true;
        distance[v] = 0;

        for (int i = 0; i < this.size - 2; i++) { // v를 제외한 정점에 대한 최단 경로 찾기
            u = choose(distance, visited); // 최소 거리에 있는 정점 u 선택
            visited[u] = true;
            for (w = 0; w < size; w++) {
                if (visited[w])
                    continue;
                if (distance[u] + edges[u][w] < distance[w])
                    distance[w] = distance[u] + edges[u][w];
            }
        }
    }

    int choose(int distance[], boolean found[]) {
        int i, min, minPos;
        min = MAX_VALUE;
        minPos = -1;
        for (i = 0; i < this.size; i++) {
            if (distance[i] < min && !found[i]) {
                min = distance[i];
                minPos = i;
            }
        }
        return minPos;
    }

    public void print() {
        System.out.println("SIZE = " + this.size);
        System.out.println("DIRECTED = " + this.directed);

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                System.out.format("%02d |", this.edges[row][col]);
            }
            System.out.println();
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
