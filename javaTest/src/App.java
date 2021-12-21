public class App {
    int sum(int ... values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App app = new App();
        int total = app.sum(1, 2, 3, 4);
        System.out.println(total);
    }
}
