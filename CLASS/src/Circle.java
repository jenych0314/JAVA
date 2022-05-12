public class Circle extends Shape {
    private int radius;
    protected String name;

    // constructor
    public Circle() {
        this(0, "Circle");
    }

    public Circle(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public int getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        name = "Circle";
        super.name = "Shape";
        // super.draw();
        System.out.println(name);
    }

    public static void main(String[] args) {
        Circle pizza;
        pizza = new Circle();
        pizza.radius = 10;
        pizza.name = "JavaPizza";
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle donut = new Circle();
        donut.radius = 2;
        donut.name = "JavaDonut";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);

        Circle ball = new Circle(5, "SoccerBall");
        // double area = ball.getArea();
        System.out.println(ball.radius + " and " + ball.name);

        Shape b = new Circle();
        b.paint();
    }
}