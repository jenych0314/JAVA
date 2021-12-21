// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.util.Hashmap;
// import java.util.Arrays;

// public class B_10989 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         int N = Integer.parseInt(br.readLine());
//         Hashmap<Integer, Integer> map = new Hashmap<Integer, Integer>();
//         int value;

//         for (int i = 0; i < N; i++) {
//             int num = Integer.parseInt(br.readLine());
//             if (map.containsKey(num) == true) {
//                 value = map.get(num);
//                 map.put(num, value + 1);
//             }
//             else {
//                 map.put(num, 1);
//             }
//         }

//         Arrays.sort(map);
//         StringBuilder sb = new StringBuilder();
//         for (Integer key : map.keySet()) {
//             value = map.get(key);
//             for (int i = 0; i < value; i++) {
//                 bw.write(key + "\n");
//             }
//         }

//         bw.write(sb.toString());
//         br.close();
//         bw.flush();
//         bw.close();
//     }
// }