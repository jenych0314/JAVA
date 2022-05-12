import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class GraphList {
    int size;
    boolean directed;
    ArrayList<LinkedList<Integer>> heads;
    boolean[] visited;

    GraphList(int size, boolean directed) {
        this.size = size;
        this.directed = directed;
        this.heads = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.heads.add(new LinkedList<>());
        }
    }

    void add(int start, int finish) {
        LinkedList<Integer> select = this.heads.get(start);
        if (!select.contains(finish)) {
            select.addLast(finish);
            if (!this.directed) {
                this.add(finish, start);
            }
        }
    }

    @FunctionalInterface
    interface GraphListVisitor {
        void visit(int data);
    }

    void bfs(int v, GraphListVisitor visitor) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.size];
        this.bfsInternal(v, visitor, visited, queue);
    }

    void bfsInternal(int start, GraphListVisitor visitor, boolean[] visited,
            Queue<Integer> queue) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int visit = queue.remove();
            LinkedList<Integer> select = this.heads.get(visit);
            for (int i = 0; i < select.size(); i++) {
                int next = select.get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
            visitor.visit(visit);
        }
    }

    void printElem(ArrayList<LinkedList<Integer>> graphList) {
        for (int i = 0; i < size; i++) {
            LinkedList<Integer> list = graphList.get(i);
            System.out.print(i + ": ");
            for (int elem : list) {
                System.out.print(elem + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphListVisitor visitor = (node) -> {
            System.out.print(node + " -> ");
        };

        GraphList graphList = new GraphList(8, false);
        graphList.add(0, 1);
        graphList.add(0, 2);
        graphList.add(1, 3);
        graphList.add(1, 4);
        graphList.add(2, 5);
        graphList.add(2, 6);
        graphList.add(3, 7);
        graphList.add(4, 7);
        graphList.add(5, 7);
        graphList.add(6, 7);

        System.out.println("Start from 0");
        graphList.bfs(0, visitor);
        System.out.println("\nStart from 3");
        graphList.bfs(3, visitor);

        // graphList.printElem(graphList.heads);
    }

}
