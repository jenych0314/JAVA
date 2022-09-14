import java.util.Scanner;

class InsertionSort {
    static int MAX_SIZE = 1000;

    static int[] swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    static void insertionSort(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                cntCmpOps++;
                if (!(arr[j - 1] > arr[j]))
                    break;
                swap(arr, j - 1, j);
                cntSwaps++;
            }
        }
        System.out.println(cntCmpOps + " " + cntSwaps + " ");
    }

    static void insertionSortImproved(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        for (int i = 1; i < size; i++) {
            int tmp = arr[i];

            int j;
            for (j = i; j > 0; j--) {
                cntCmpOps++;
                if (!(arr[j - 1] > tmp))
                    break;
                arr[j] = arr[j - 1];
                cntSwaps++;
            }
            arr[j] = tmp;
        }

        System.out.println(cntCmpOps + " " + cntSwaps + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_size = InsertionSort.MAX_SIZE;

        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int[] arr = new int[max_size];

            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                arr[j] = in.nextInt();
            }

            insertionSort(arr, num);
        }

        in.close();
    }
}
