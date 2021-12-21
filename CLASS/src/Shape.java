abstract public class Shape {
    protected String name;
    public Shape next;
    public Shape() { next = null;}

    public void paint() {
        draw();
    }
    
    // public void draw() {
    //     System.out.println(name);
    // }

    abstract public void draw();
    public static void main(String[] args) {
        System.out.println("ShapeClass");

        // Shape a = new Shape();
        // a.paint();
    }
}
