public class Person {
    private int weight;
    int age;
    protected int height;
    public String name;

    public Person() {}
    
    public Person(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        Person Korean = new Person("name");
        Korean.weight = 10;
        Korean.age = 9;
        Korean.height = 8;
        Korean.name = "name";

        System.out.println(Korean.weight);
        System.out.println(Korean.age);
        System.out.println(Korean.height);
        System.out.println(Korean.name);
    }
}
