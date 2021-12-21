public class EqualsEx {
    public static void main(String[] args) {
        // 1
        // Point a = new Point(2, 3);
        // Point b = new Point(2, 3);
        // Point c = new Point(3, 4);

        // if (a == b) System.out.println("a == b");
        // if (a.equals(b)) System.out.println("a is equal to b");
        // if (a.equals(c)) System.out.println("a is equal to c");

        // 2
        Rect a = new Rect(2, 3);
        Rect b = new Rect(3, 2);
        Rect c = new Rect(3, 4);

        if (a == b) System.out.println("a == b"); // ==는 주소값 비교
        if (a.equals(b)) System.out.println("a is equal to b");
        if (a.equals(c)) {
            System.out.println("a is equal to c");
        }
        if (b.equals(c)) {
            System.out.println("b is equal to c");
        }
    }
}
