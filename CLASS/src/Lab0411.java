public class Lab0411 extends DoubleLinkedList {
    void testCase1() {
        DoubleLinkedList list = new DoubleLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
            return ((String) lhs).compareTo((String) rhs);
        };

        final BidirectNode begin = list.begin.next;

        Visitor v = (n) -> {
            if (begin.next == n) {
                System.out.print("LIST = (");
            }
            System.out.print(n.data);
            if (n.next == begin.next) {
                System.out.println(")");
            } else {
                System.out.print(", ");
            }
        };

        list.traverse(v);
        System.out.println("Add A");
        list.add("A", c);
        list.traverse(v);
        System.out.println("Add F");
        list.add("F", c);
        list.traverse(v);
        System.out.println("Add G");
        list.add("G", c);
        list.traverse(v);
        System.out.println("Add E");
        list.add("E", c);
        list.traverse(v);

        System.out.println("Remove A");
        list.remove("A", c);
        list.traverse(v);
        System.out.println("Remove G");
        list.remove("G", c);
        list.traverse(v);

        System.out.println("Add B");
        list.add("B", c);
        list.traverse(v);
        System.out.println("Add A");
        list.add("A", c);
        list.traverse(v);
    }

    void testCase2() {
        DoubleLinkedList list = new DoubleLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
            int i1 = (Integer) lhs;
            int i2 = (Integer) rhs;
            return i1 - i2;
        };

        final BidirectNode begin = list.begin.next;

        Visitor v = (n) -> {
            if (begin.next == n) {
                System.out.print("(");
            }
            System.out.print(n.data);
            if (n.next == begin.next) {
                System.out.println(")");
            } else {
                System.out.print(", ");
            }
        };

        for (int i = 0; i < 5; i++) {
            list.add((2 * i + 1), c);
        }

        while (true) {
            list.traverse(v);

            int result = 0;
            for (int i = 0; i < 2; i++) {
                Object data = list.removeFirst();
                System.out.println("Remove First: " + data);
                result += (Integer) data;
            }
            result *= 2;

            if (list.isEmpty()) {
                list.add(result, c);
                list.traverse(v);
                System.out.print("Result: " + result);
                break;
            }

            System.out.println("Add: " + result);
            list.add(result, c);
        }
    }

    public static void main(String[] args) {
        Lab0411 test = new Lab0411();
        // test.testCase1();
        test.testCase2();
    }
}
