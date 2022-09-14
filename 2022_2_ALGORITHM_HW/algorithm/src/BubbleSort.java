import java.util.Scanner;

class BubbleSort {
    static int MAX_SIZE = 1000;

    static int[] swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    static void copyArr(int[] arr1, int[] arr2, int size) {
        for (int i = 0; i < size; i++) {
            arr1[i] = arr2[i];
        }
    }

    static void bubbleSort(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= size - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    cntSwaps++;
                }
                cntCmpOps++;
            }
        }

        System.out.print(cntCmpOps + " " + cntSwaps + " ");
    }

    static void bubbleSortImprove1(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        for (int i = 1; i < size; i++) {
            boolean swapped = false;

            for (int j = 1; j <= size - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    swapped = true;
                    cntSwaps++;
                }
                cntCmpOps++;
            }

            if (!swapped)
                break;
        }

        System.out.print(cntCmpOps + " " + cntSwaps + " ");
    }

    static void bubbleSortImprove2(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        int lastSwappedPos = size;

        while (lastSwappedPos > 0) {
            int swappedPos = 0;

            for (int i = 1; i < lastSwappedPos; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    swappedPos = i;
                    cntSwaps++;
                }
                cntCmpOps++;
            }

            lastSwappedPos = swappedPos;
        }

        System.out.println(cntCmpOps + " " + cntSwaps);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max_size = BubbleSort.MAX_SIZE;

        int numTestCases = in.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            int[] arr1 = new int[max_size];
            int[] arr2 = new int[max_size];

            int num = in.nextInt();
            for (int j = 0; j < num; j++) {
                arr2[j] = in.nextInt();
            }

            copyArr(arr1, arr2, num);
            bubbleSort(arr1, num);

            copyArr(arr1, arr2, num);
            bubbleSortImprove1(arr1, num);

            copyArr(arr1, arr2, num);
            bubbleSortImprove2(arr1, num);
        }

        in.close();
    }
}