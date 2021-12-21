import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter something: ");
            String s = in.next();
            a.add(s);
        }

        for (int i = 0; i < a.size(); i++) {
            String name = a.get(i);
            System.out.println(name);
        }

        int longestIndex = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(longestIndex).length() < a.get(i).length()) {
                longestIndex = i;
            }
        }
        System.out.println("가장 긴 것은: " + a.get(longestIndex));

        String toFind = "NaN";
        if (a.indexOf(toFind) == -1) {
            System.out.println("There's no " + toFind);
        }
        else System.out.println(a.get(a.indexOf(toFind)));

        in.close();
    }
}
