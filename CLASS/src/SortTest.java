import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SortTest extends SortMethod {
    public static int[][] fileRead() {
        int[][] arr = new int[7][];
        arr[0] = new int[100000];
        arr[1] = new int[200000];
        arr[2] = new int[500000];
        arr[3] = new int[1000000];
        arr[4] = new int[2000000];
        arr[5] = new int[5000000];
        arr[6] = new int[10000000];

        // int[][] arr = new int[10][];
        // for (int i = 1; i <= 10; i++)
        // arr[i - 1] = new int[i * 100000];

        try {
            File file = new File("C:\\Users\\jeony\\Downloads\\input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            int i = 0;
            while ((line = br.readLine()) != null) {
                for (int j = 0; j < arr.length; j++) {
                    if (i < arr[j].length)
                        arr[j][i] = Integer.parseInt(line);
                }
                i++;
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return arr;
    }

    public static void bubbleSortIterativeTest() {
        System.out.println("---bubbleSort---");
        int[][] data = fileRead();
        for (int i = 0; i < data.length; i++) {
            long beforeTime = System.currentTimeMillis();
            bubbleSortIterative(data[i]);
            long afterTime = System.currentTimeMillis();
            double diffTime = (afterTime - beforeTime) / 1000.0;
            System.out.format("arr size: %,d -> 정렬 시간(sec) : %,.3f%n", data[i].length, diffTime);
        }
    }

    public static void insertionSortIterativeTest() {
        System.out.println("---insertionSort---");
        int[][] data = fileRead();
        for (int i = 0; i < data.length; i++) {
            long beforeTime = System.currentTimeMillis();
            insertionSortIterative(data[i]);
            long afterTime = System.currentTimeMillis();
            double diffTime = (afterTime - beforeTime) / 1000.0;
            System.out.format("arr size: %,d -> 정렬 시간(sec) : %,.3f%n", data[i].length, diffTime);
        }
    }

    public static void SelectionSortIterativeTest() {
        System.out.println("---SelectionSort---");
        int[][] data = fileRead();
        for (int i = 0; i < data.length; i++) {
            long beforeTime = System.currentTimeMillis();
            SelectionSortIterative(data[i]);
            long afterTime = System.currentTimeMillis();
            double diffTime = (afterTime - beforeTime) / 1000.0;
            System.out.format("arr size: %,d -> 정렬 시간(sec) : %,.3f%n", data[i].length, diffTime);
        }
    }

    public static void QuickSortRecursiveTest() {
        System.out.println("---QuickSort---");
        int[][] data = fileRead();
        for (int i = 0; i < data.length; i++) {
            long beforeTime = System.currentTimeMillis();
            QuickSortRecursive(data[i]);
            long afterTime = System.currentTimeMillis();
            double diffTime = (afterTime - beforeTime) / 1000.0;
            System.out.format("arr size: %,d -> 정렬 시간(sec) : %,.3f%n", data[i].length, diffTime);
        }
    }

    public static void MergeSortRecursiveTest() {
        System.out.println("---mergeSort---");
        int[][] data = fileRead();
        for (int i = 0; i < data.length; i++) {
            long beforeTime = System.currentTimeMillis();
            MergeSortRecursive(data[i]);
            long afterTime = System.currentTimeMillis();
            double diffTime = (afterTime - beforeTime) / 1000.0;
            System.out.format("arr size: %,d -> 정렬 시간(sec) : %,.3f%n", data[i].length, diffTime);
        }
    }

    public static void main(String[] args) {
        bubbleSortIterativeTest();
        // insertionSortIterativeTest();
        // SelectionSortIterativeTest();
        // QuickSortRecursiveTest();
        // MergeSortRecursiveTest();
    }
}
