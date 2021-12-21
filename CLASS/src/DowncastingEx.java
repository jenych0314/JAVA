public class DowncastingEx {
    public static void main(String[] args) {
        Person p = new Student("이재문"); // 업캐스팅
        Student s;

        s = (Student)p; // 다운캐스팅

        System.out.println(s.name);
        s.grade = "A";
    }
}
