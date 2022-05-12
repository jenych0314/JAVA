public class C_20220318 { // ArrayLinearList
    private int N; // index of last element in list
    private int size; // array size
    private int increment; // array size increment
    private int[] itemList;

    public C_20220318() { // Constructor
        N = -1;
        size = 10;
        increment = 2;
        itemList = new int[size];
    }

    public boolean isEmpty() {
        return (N == -1) ? true : false;
    }

    public void insert(int x) {
        // 삽입할 원소의 위치값 초기화
        int idx = 0;

        if (N == size - 1) {// 가득 차 있을 경우
            // 사이즈를 increment양만큼 늘린다
            size += increment;
            // 늘린 사이즈로 새로운 배열을 만든다
            int[] tempList = new int[size];
            // 새로운 배열에 기존 배열을 복사한다
            for (int i = 0; i <= N; i++) {
                tempList[i] = itemList[i];
            }
            // 새로운 배열에서 새로운 숫자를 삽입할 index를 찾는다
            for (int i = 0; i <= N; i++) {
                if (x > tempList[i])
                    idx++;
            }
            // 새로운 배열의 우측, 큰 숫자부터 한 칸씩 오른쪽으로 민다
            for (int i = N + 1; i > idx; i--) {
                tempList[i] = tempList[i - 1];
            }
            // 새로운 배열에 새로운 숫자를 삽입한다
            tempList[idx] = x;
            // N을 1 증가시킨다
            N++;
            // 기존 배열을 변경한 사이즈로 다시 만든다
            itemList = new int[size];
            // 기존 배열에 새롭게 만든 배열을 다시 복사한다
            for (int i = 0; i <= N; i++) {
                itemList[i] = tempList[i];
            }
            // 새롭게 만든 배열은 삭제한다
        } else if (N == -1) {// empty
            // N을 증가시킨다. N은 가장 마지막 원소의 위치값인데 현재 -1이기에 증가시킴.
            N++;
            itemList[N] = x;
        } else {
            // x를 집어넣을 위치를 찾음
            for (int i = 0; i <= N; i++) {
                if (x > itemList[i])
                    idx++;
            }
            // 가장 마지막 원소부터 오른쪽으로 한칸씩 미룸.
            for (int i = N + 1; i > idx; i--) {
                itemList[i] = itemList[i - 1];
            }
            // 원소를 삽입함.
            itemList[idx] = x;
            // N을 1 증가시킴.
            N++;
        }
    }

    public void delete(int x) {
        if (isEmpty()) { // 배열이 비어있을 경우 출력
            System.out.println("List is Empty");
        } else {
            // 삭제할 원소의 위치값(idx) 초기화
            int idx = -1;
            // 삭제할 원소와 같은 원소인지 확인 -> 맞다면 idx값을 그 원소의 위치값으로 변경
            for (int i = 0; i <= N; i++) {
                if (x == itemList[i]) {
                    idx = i;
                }
            }

            if (idx == -1) { // 찾는 원소가 없을 경우
                System.out.println("삭제할 원소" + x + "가 없습니다.");
            } else {
                // 삭제할 원소의 위치부터 바로 다음 원소를 당겨옴.
                for (int i = idx; i < N; i++) {
                    itemList[i] = itemList[i + 1];
                }

                // N을 1 감소
                N--;
            }
        }
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(itemList[i] + ", ");
        }
        System.out.println(itemList[N]);
    }

    public static void main(String[] args) {
        C_20220318 list1 = new C_20220318();
        System.out.println("---insert---");

        for (int i = 0; i < 15; i++) {
            list1.insert(10 * (i + 1));
            list1.print();
        }

        for (int i = 0; i < 5; i++) {
            list1.insert(9 * (i + 1));
            list1.print();
        }

        System.out.println("---delete---");
        for (int i = 0; i < 10; i++) {
            list1.delete(9 * (i + 1));
            list1.print();
        }

        for (int i = 10; i >= 0; i--) {
            list1.delete(10 * (i + 1));
            list1.print();
        }

        System.out.println("isEmpty? " + list1.isEmpty());
    }
}
