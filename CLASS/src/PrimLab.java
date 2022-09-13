public class PrimLab {
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

        SpanningTreeBuilder builder = new PrimMethodBuilder();
        SpanningTree tree;
        tree = builder.build(g, 0);
        tree.print();
        tree = builder.build(g, 3);
        tree.print();
        tree = builder.build(g, 6);
        tree.print();
    }
}
