import java.util.Scanner;

class ShellSort {
    static int MAX_SIZE = 1000;

    static int[] swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    static void shellSort(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        int shrinkRatio = 2;
        int gap = size / shrinkRatio;

        while (gap > 0) {
            for (int i = gap; i < size; i++) {
                int tmp = arr[i];
                int j;

                for (j = i; j >= gap; j -= gap) {
                    cntCmpOps++;
                    if (!(arr[j - gap] > tmp))
                        break;

                    arr[j] = arr[j - gap];
                    cntSwaps++;
                }

                arr[j] = tmp;
            }

            gap /= shrinkRatio;
        }
        System.out.println(cntCmpOps + " " + cntSwaps + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_size = ShellSort.MAX_SIZE;

        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int[] arr = new int[max_size];

            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                arr[j] = in.nextInt();
            }

            shellSort(arr, num);
        }

        in.close();
    }
}
