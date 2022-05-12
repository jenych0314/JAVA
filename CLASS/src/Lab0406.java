public class Lab0406 extends SingleLinkedList {
    ItemComparator cString = (left, right) -> {
        String s1 = (String) left;
        String s2 = (String) right;
        return s1.compareTo(s2);
    };

    ItemComparator cInteger = (left, right) -> {
        int i1 = (Integer) left;
        int i2 = (Integer) right;
        return i1 - i2;
    };

    SingleLinkedList lst1 = new SingleLinkedList();
    SingleLinkedList lst2 = new SingleLinkedList();

    SingleLinkedList lst3 = new SingleLinkedList();
    SingleLinkedList lst4 = new SingleLinkedList();
    SingleLinkedList lst5 = new SingleLinkedList();
    SingleLinkedList lst6 = new SingleLinkedList();

    public Lab0406() {
        lst1.add(1, cInteger);
        lst1.add(3, cInteger);
        lst1.add(5, cInteger);
        lst1.add(7, cInteger);
        lst1.add(9, cInteger);

        lst2.add("Ant", cString);
        lst2.add("Bear", cString);
        lst2.add("Cat", cString);
        lst2.add("Dog", cString);

        lst3.add(1, cInteger);
        lst3.add(3, cInteger);
        lst3.add(5, cInteger);
        lst3.add(7, cInteger);
        lst3.add(9, cInteger);

        lst4.add(2, cInteger);
        lst4.add(10, cInteger);
        lst4.add(12, cInteger);
        lst4.add(20, cInteger);

        lst5.add("Ant", cString);
        lst5.add("Bear", cString);
        lst5.add("Elephant", cString);

        lst6.add("Cat", cString);
        lst6.add("Dog", cString);
        lst6.add("Flamingo", cString);
    }

    void toString(SingleLinkedList lst) {
        System.out.print("(");
        Node p;
        if (lst.begin.link != null) {
            p = lst.begin.link;
            while (p.link != lst.end.link) {
                System.out.print(p.data + ", ");
                p = p.link;
            }
        } else {
            p = lst.end.link;
            while (p.link != lst.begin) {
                System.out.print(p.data + ", ");
                p = p.link;
            }
        }
        System.out.print(p.data);
        System.out.println(")");
    }

    void testCase11() {
        System.out.println("INPUT:");
        this.toString(this.lst1);

        this.lst1.invert();
        System.out.println("INVERTED");
        this.toString(this.lst1);
    }

    void testCase12() {
        System.out.println("INPUT:");
        this.toString(this.lst2);

        this.lst2.invert();
        System.out.println("INVERTED");
        this.toString(this.lst2);
    }

    void testCase21() {
        System.out.println("INPUT:");
        this.toString(this.lst3);
        this.toString(this.lst4);

        this.lst3.concatenate(lst4.begin.link);
        System.out.println("CONCATENATED:");
        this.toString(this.lst3);
    }

    void testCase22() {
        System.out.println("INPUT:");
        this.toString(this.lst5);
        this.toString(this.lst6);

        this.lst5.concatenate(lst6.begin.link);
        System.out.println("CONCATENATED:");
        this.toString(this.lst5);
    }

    public static void main(String[] args) {
        Lab0406 testcase = new Lab0406();
        // testcase.testCase11();
        // testcase.testCase12();
        testcase.testCase21();
        testcase.testCase22();
    }
}
