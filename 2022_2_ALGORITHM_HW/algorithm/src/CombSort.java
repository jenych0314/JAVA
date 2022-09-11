import java.util.Scanner;

class CombSort {
    static int MAX_SIZE = 1000;

    static int[] swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    static void combSort(int[] arr, int size) {
        int cntCmpOps = 0;
        int cntSwaps = 0;

        int gap = size;
        double shrink = 1.3;
        boolean sorted = false;

        while(!sorted) {
            gap = (int)(gap / shrink);

            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            int i = 0;
            while(i + gap < size) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    sorted = false;
                    cntSwaps++;
                }
                cntCmpOps++;
                i++;
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

            combSort(arr, num);
        }

        in.close();
    }
}
