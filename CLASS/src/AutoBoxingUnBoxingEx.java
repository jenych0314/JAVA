public class AutoBoxingUnBoxingEx {
    public static void main(String[] args) {
        int n = 10;
        Integer intObj = n;
        System.out.println("intObj = " + intObj);

        int m = intObj + 10;
        System.out.println("m = " + m);
    }
}
