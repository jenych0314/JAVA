public class MathEx {
    public static void main(String[] args) {
        System.out.println(Math.PI); // 원주율 상수
        System.out.println(Math.ceil(3.14)); // 올림
        System.out.println(Math.floor(3.14)); // 내림
        System.out.println(Math.round(3.14)); // 반올림
        System.out.println(Math.sqrt(4)); // 제곱근
        System.out.println(Math.exp(2)); // e^2

        for(int i = 0; i < 5; i++) {
            System.out.print((int)(Math.random()*100 + 1) + " ");
            // [1, 100] 사이의 정수형 난수 5개 발생
        }
    }
}
