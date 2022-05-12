public class UseArray2 {
    static void print(int[][] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(name + "[" + i + "] = ");
                System.out.println(arr[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }
        print(arr, "Hello");
    }
}
