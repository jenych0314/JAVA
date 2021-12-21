import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_10818 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min_val = arr[0];
        int max_val = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (min_val > arr[i]) {
                min_val = arr[i];
            }
            if (max_val < arr[i]) {
                max_val = arr[i];
            }
        }

        System.out.printf("%d %d", min_val, max_val);

        br.close();

        // bw.flush();
        // bw.close();
    }
}
