@FunctionalInterface
interface LambdaArray {
    void print(int[] arr, String name);
}

public class C_20220314_2 {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = { 0, 1, 5, 7, 9 };
        int[] c = new int[5];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }

        LambdaArray la = (arr, name) -> {
            // for (int i = 0; i < arr.length; i++) {
            // System.out.println(name + "[" + i + "] = " + arr[i]);
            // }
            System.out.print("Arr " + name + " = [");
            // System.out.print(" = [");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i);
                if (i != arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]\n");
            // System.out.println();
        };

        la.print(a, "a");
        la.print(b, "b");
        la.print(c, "c");
    }
}
