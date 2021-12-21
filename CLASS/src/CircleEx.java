public class CircleEx {
    public static void main(String[] args) {
        Circle pizza;
        pizza = new Circle();
        pizza.setRadius(10);
        pizza.setName("JavaPizza");
        double area = pizza.getArea();
        System.out.println(pizza.getName() + "의 면적은 " + area);

        Circle ball = new Circle(5, "SoccerBall");
        System.out.println(ball.getRadius() + " and " + ball.getName());
    }
}
