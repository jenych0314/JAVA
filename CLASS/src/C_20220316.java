public class C_20220316 {
    String name;
    int age;
    float salary;

    C_20220316(String name, int age, float salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {
        C_20220316 e = new C_20220316("HGD", 22, 4000);

        C_20220316[] employees = new C_20220316[3];
        employees[0] = e;
        employees[1] = new C_20220316("OYS", 23, 3500);
        employees[2] = new C_20220316("K", 43, 6000);

        // C_20220316 e1 = new C_20220316;

    }

    boolean equals(C_20220316 other) {
        boolean eq = this.name == other.name;
        eq = eq && this.age == other.age;
        eq = eq && this.salary == other.salary;
        return eq;
    }
}
