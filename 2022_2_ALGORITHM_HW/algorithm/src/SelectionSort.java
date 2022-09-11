import java.util.Scanner;

class SelectionSort {
    static int MAX_SIZE = 1000;

    static int[] swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    static void selectionSort(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;

            int j;
            for (j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
                cntCmpOps++;
            }

            if (min_idx != i){
                swap(arr, min_idx, j);
                cntSwaps++;
            }
        }

        System.out.println(cntCmpOps + " " + cntSwaps + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_size = BubbleSort.MAX_SIZE;

        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int[] arr = new int[max_size];
            
            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                arr[j] = in.nextInt();
            }

            selectionSort(arr, num);
        }

        in.close();
    }
}

// 3
// 9 1 2 3 4 5 6 7 8 9
// 9 9 8 7 6 5 4 3 2 1
// 9 9 6 3 1 2 4 5 7 8