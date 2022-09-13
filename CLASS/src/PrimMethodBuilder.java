import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

interface SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source);
}

public class PrimMethodBuilder implements SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source) {
        // initalize
        int n = graph.getSize();
        boolean visited[] = new boolean[n];
        int disjoint[] = new int[n];
        SpanningTree tree = new SpanningTree(n);
        for (int v = 0; v < n; v++) {
            disjoint[v] = v;
        }

        // extract edges
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int row = 0; row < n; row++) {
            int col = graph.isDirected() ? 0 : row;
            for (; col < n; col++) {
                int w = graph.getWeight(row, col);
                if (w > 0)
                    edges.add(new Edge(row, col, w));
            }
        }

        // sort edges
        Collections.sort(edges, (Edge e1, Edge e2) -> {
            return e1.weight - e2.weight; // 오름차순
            // return e2.weight - e1.weight; // 내림차순
        });

        // Prim method
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int curEdge = 0;
        int totalWeight = 0;

        while (true) {
            visited[curEdge] = true;
            for (int i = 0; i < n; i++) {
            }
            break;
        }

        return tree;
    }

    int find(int v, int[] disjoint) {
        if (v == disjoint[v])
            return v;
        disjoint[v] = find(disjoint[v], disjoint);
        return disjoint[v];
    }

    void union(int v1, int v2, int[] disjoint) {
        int r1 = find(v1, disjoint);
        int r2 = find(v2, disjoint);
        if (r1 == r2)
            return;
        disjoint[r1] = r2;
    }
}