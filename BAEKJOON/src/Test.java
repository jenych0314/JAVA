public class Test {
    static double pi = 3.141592;
    static int plus (int x, int y) {
        return x + y;
    }
    static int minus (int x, int y) {
        return x - y;
    }
    public static void main(String[] args) {
        Test test = new Test();
        double pi = test.pi;
        var x = 100000;
        System.out.println(x);
        System.out.println(pi);
    }
}

class Solution {
    public int[][] solution(int[][] mat1, int[][] mat2) {
        int[][] arr = new int[2][2];
        int N = mat2.length;
        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 2; m++) {
                int temp = 0;
                for (int i = 0; i < N; i++) {
                    temp += mat1[n][i] * mat2[i][m];
                }
                arr[n][m] = temp;
            }
        }
        return arr;
    }
}