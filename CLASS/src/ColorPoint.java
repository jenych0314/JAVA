public class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }

    public static void main(String[] args) {
        ColorPoint redMoon = new ColorPoint(100, 100, "red");
        redMoon.set(100, 100);
        redMoon.setColor("red");
        redMoon.showColorPoint();
    }
}