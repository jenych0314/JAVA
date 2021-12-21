public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("노지영");
        p = s;

        System.out.println((p.name));
    }
}
