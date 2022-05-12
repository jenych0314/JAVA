public class CircularLinkedList extends Node {
    Node begin;

    public CircularLinkedList() {
        this.begin = new Node();
        this.begin.link = this.begin;
    }

    public boolean isEmpty() {
        return this.begin.link == this.begin;
    }

    @FunctionalInterface
    public interface Visitor {
        void visit(Node n);
    }

    public void traverse(Visitor visitor) {
        Node first = this.begin.link;
        Node p;

        for (p = first; p.link != first; p = p.link) {
            visitor.visit(p);
        }
        if (first.link == first) {
            visitor.visit(first);
        } else {
            visitor.visit(p);
        }
    }

    public void traverse(Node L, Visitor visitor) {
        Node p;
        for (p = L; p.link != L; p = p.link) {
            visitor.visit(p);
        }
        if (L != this.begin && L != this.begin.link) {
            visitor.visit(L);
        }
        visitor.visit(p);
    }

    public void traverseIterative(Node L, Node E, Visitor visitor) {
        for (Node p = L; p != E; p = p.link) {
            visitor.visit(p);
        }
        visitor.visit(E);
    }

    @FunctionalInterface
    interface ItemComparator {
        int compare(Object left, Object right);
    }

    public Node search(Node L, Object data, ItemComparator comparator) {
        Node p = L;
        Node found = L;

        if (isEmpty()) { // 비어있는 경우
            return this.begin;
        }

        if (L.link == L) { // 하나만 있는 경우
            if (comparator.compare(L.data, data) <= 0) {
                return L;
            } else {
                return this.begin;
            }
        }

        while (p.link != L && comparator.compare(p.data, data) <= 0) { // 둘 이상 있는 경우
            found = p;
            p = p.link;
        }

        if (p == L) { // 첫 시작에 집어넣을 경우
            while (p.link != L) {
                found = p;
                p = p.link;
            }
        } else {
            found = p;
        }

        return found;
    }

    public Node search(Object data, ItemComparator comparator) {
        return this.search(this.begin.link, data, comparator);
    }

    public Node add(Object data, ItemComparator comparator) {
        // Node insert = this.getNode(data);
        Node pos = this.search(data, comparator);
        Node insert = new Node(data);

        if (isEmpty()) {
            begin.link = insert;
            insert.link = insert;
        } else {
            insert.link = pos.link;
            pos.link = insert;
        }

        if (pos != begin && comparator.compare(pos.data, data) > 0) {
            // 시작 노드에 추가하려고 할 때
            this.begin.link = insert;
        }

        return insert;
    }

    // public Node deleteSearch(Node L, Object data, ItemComparator comparator) {
    // Node p = L;
    // Node found = L;

    // while (p != end && comparator.compare(p.data, data) != 0) {
    // found = p;
    // p = p.link;
    // }

    // if (p == end)
    // return end;
    // if (found == p)
    // return begin;
    // return found;
    // }

    // public Node deleteSearch(Object data, ItemComparator comparator) {
    // return deleteSearch(begin.link, data, comparator);
    // }

    // public Node delete(Object data, ItemComparator comparator) {
    // Node pos = null;
    // Node deleting = null;
    // pos = deleteSearch(data, comparator);

    // if (pos == end)
    // return null;

    // deleting = pos.link;
    // pos.link = deleting.link;

    // return pos;
    // }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        ItemComparator comp = (left, right) -> {
            int i1 = (Integer) left;
            int i2 = (Integer) right;
            return i1 - i2;
        };

        Visitor v = (n) -> {
            if (n.link == null) {
                System.out.print("null");
            } else {
                System.out.print(n.data + " -> ");
            }
        };

        list.add(1, comp);
        list.add(2, comp);
        list.add(3, comp);
        list.add(4, comp);

        list.traverse(v);
    }
}