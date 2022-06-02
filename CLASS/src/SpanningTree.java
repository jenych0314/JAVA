import java.util.ArrayList;
import java.util.Collections;

public class SpanningTree extends GraphMatrix {
    SpanningTree() {
        this(0);
    }

    SpanningTree(int size) {
        super(size, true);
    }

    public void add(int src, int dest, int weight) {
        // check range src and dest: 0 <= src, dest < size
        // check weight: weight >= 0
        // check cycle
        this.edges[src][dest] = weight;
    }

    public int weight() {
        int result = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = row; col < this.size; col++) { // int col = 0 일 때보다 탐색량 1/2배로 감소
                result += this.edges[row][col];
            }
        }
        return result;
    }

    interface SpanningTreeBuilder {
        public SpanningTree build(Graph graph, int source);
    }

    class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    class KruskalMethodBuilder implements SpanningTreeBuilder {
        public SpanningTree build(Graph graph, int source) {
            // initalize
            boolean visited[] = new boolean[graph.getSize()];
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
                Edge select = edges.get(i);

                int a = find(select.start, disjoint);
                int b = find(select.end, disjoint);

                if (a == b)
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

    class KruskalLab {
        public static void main(String[] args) {
            GraphMatrix g = new GraphMatrix(7, false);
            g.add(0, 5, 10);
            g.add(0, 1, 28);
            g.add(0, 1, 28);
            g.add(1, 2, 16);
            g.add(1, 6, 14);
            g.add(2, 3, 12);
            g.add(3, 4, 22);
            g.add(3, 6, 18);
            g.add(4, 5, 25);
            g.add(4, 6, 24);
            g.print();

            SpanningTreeBuilder builder = new KruskalMethodBuilder();
            SpanningTree tree = builder.build(g, 0);
            tree.print();
        }
    }
}
