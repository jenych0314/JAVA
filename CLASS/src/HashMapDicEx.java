import java.util.Scanner;
import java.util.HashMap;

public class HashMapDicEx {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String, String>();

        dic.put("baby", "아기"); // key, value
        dic.put("apple", "사과");
        dic.put("love", "사랑");

        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("찾고 싶은 단어는?");
            String eng = in.next();
            if (eng.equals("exit")) {
                System.out.println("종료");
                break;
            }

            String kor = dic.get(eng);
            if (kor == null) {
                System.out.println(eng + "는 없는 단어");
            }
            else System.out.println(kor);
        }

        in.close();
    }
}
