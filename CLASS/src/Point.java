public class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.printf("(%d, %d)%n", x, y);
    }

    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public boolean equals(Object obj) {
        Point p = (Point)obj;
        if (x == p.x && y == p.y) return true;
        else return false;
    }
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        p.set(1, 2);
        p.showPoint();
        System.out.println(p.toString());
        System.out.println(p);
        System.out.println(p + "입니다");
    }
}
