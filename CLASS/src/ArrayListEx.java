import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

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
        } else
            System.out.println(a.get(a.indexOf(toFind)));

        in.close();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            arr.add(i);
        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()) {
            int value = it.next();
            System.out.println(value);
        }
        for (int value : arr)
            System.out.println(value);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
