import java.util.Random;

public class C_20220314_3 {
    static void accumlateSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
            sum += arr[i];
        }
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] value = new int[5];

        for (int i = 0; i < value.length; i++) {
            value[i] = rand.nextInt(5 + i);
            System.out.println(value[i]);
        }

        accumlateSum(value);
    }
}
