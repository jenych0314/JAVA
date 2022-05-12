import java.util.Scanner;

public class JavaDocFrameTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int maxNum = in.nextInt();

        int[] arr = new int[maxNum + 1];

        int data;
        for (int i = 0; i < size; i++) {
            data = in.nextInt();
            arr[data]++;
        }

        int MX, MN, nMX, nMN, mean;
        MX = 0;
        MN = maxNum;
        nMX = 1;
        nMN = size;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(
                    String.format("i: %d, arr[i]: %d, MX: %d, nMX: %d, MN: %d, nMN: %d", i, arr[i], MX, nMX, MN, nMN));
            if (nMX < arr[i]) {
                MX = i;
                nMX = arr[i];
            }
            if (nMN > arr[i]) {
                if (arr[i] == 0)
                    continue;
                MN = i;
                nMN = arr[i];
            }
        }
        mean = (MX + MN + nMX + nMN) / 4;

        System.out.println(MX);
        System.out.println(nMX);
        System.out.println(MN);
        System.out.println(nMN);
        System.out.println(mean);

        in.close();
    }
}
