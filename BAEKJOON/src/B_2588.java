import java.util.Scanner;

public class B_2588 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();
        
        System.out.println(A*(B%10));
        System.out.println(A*((B%100)/10));
        System.out.println(A*(B/100));
        System.out.println(A*B);

        in.close();
    }
}
