public class ColorPointEx {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        p.set(1, 2);
        p.showPoint();

        ColorPoint cp = new ColorPoint(5, 6, "blue");
        cp.set(3, 4);
        cp.setColor("red");
        cp.showColorPoint();
    }
}
