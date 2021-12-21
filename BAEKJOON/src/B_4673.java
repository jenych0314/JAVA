public class B_4673 {
    public static int constructor_num(int n) {
        int ans = n;
        while (n != 0) {
            ans += n%10;
            n /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];
        for (int i = 1; i < arr.length; i++) {
            if (constructor_num(i) < arr.length) {
                arr[constructor_num(i)] = true;
            }
            if (arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}