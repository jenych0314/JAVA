public class Rect extends Shape {
    public int width, length;

    public Rect() {
        this.width = 0;
        this.length = 0;
    }

    public Rect(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public void draw() {
        System.out.println("Rect");
    }

    public boolean equals(Object obj) {
        Rect p = (Rect)obj;
        return (width * length == p.width*p.length) ? true: false;
    }

    public static void main(String[] args) {
        System.out.println("RectClass");
    }
}
