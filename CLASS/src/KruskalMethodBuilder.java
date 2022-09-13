import java.util.ArrayList;
import java.util.Collections;

interface SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source);
}

public class KruskalMethodBuilder implements SpanningTreeBuilder {
    public SpanningTree build(Graph graph, int source) {
        // initalize
        // boolean visited[] = new boolean[graph.getSize()];
        int disjoint[] = new int[graph.getSize()];
        SpanningTree tree = new SpanningTree(graph.getSize());
        for (int v = 0; v < graph.getSize(); v++) {
            disjoint[v] = v;
        }

        // extract edges
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int row = 0; row < graph.getSize(); row++) {
            int col = graph.isDirected() ? 0 : row;
            for (; col < graph.getSize(); col++) {
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

        // Kruskal method
        for (int i = 0; i < edges.size(); i++) {
            Edge select = edges.get(i); // 정렬됨

            int a = find(select.start, disjoint);
            int b = find(select.end, disjoint);

            if (a == b) // 이미 연결
                continue;

            union(a, b, disjoint);

            tree.add(select.start, select.end, select.weight);
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