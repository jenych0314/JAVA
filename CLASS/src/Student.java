public class Student extends Person {
    String grade;
    String department;

    public Student() {}
    public Student(String name) {
        super(name);
    }

    public void set() {
        age = 30;
        name = "홍길동";
        height = 175;
        // weight = 99; // 오류, super 클래스의 private 접근 불가
        setWeight(99);
    }

    public static void main(String[] args) {
        Student s = new Student("name");
        s.set();
        System.out.println("Student");
    }
}
