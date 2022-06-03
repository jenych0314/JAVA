class SortMethod {
    public static void swap(int[] data, int idx1, int idx2) {
        int tmp = data[idx1];
        data[idx1] = data[idx2];
        data[idx2] = tmp;
    }

    public static void printArr(int[] data) {
        for (int val : data) {
            System.out.print(val + ", ");
        }
        System.out.println();
    }

    public static void bubbleSortRecursive(int[] data) {
        bubbleSortRecursiveInternal(data, data.length - 1);
    }

    public static void bubbleSortRecursiveInternal(int[] data, int last) {
        if (last > 0) {
            for (int i = 1; i <= last; i++) {
                if (data[i - 1] > data[i])
                    swap(data, i - 1, i);
            }
            bubbleSortRecursiveInternal(data, last - 1);
        }
    }

    public static void bubbleSortIterative(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j])
                    swap(data, j - 1, j);
            }
        }
    }

    public static void insertionSortRecursive(int[] data) {
        insertionSortRecursiveInternal(data, 1);
    }

    public static void insertionSortRecursiveInternal(int[] data, int start) {
        if (start > data.length - 1)
            return;
        int insert = data[start], pos;
        for (pos = 0; pos < start; pos++) {
            if (data[pos] > insert)
                break;
        }
        for (int i = start; i > pos; i--)
            data[i] = data[i - 1];
        data[pos] = insert;
        insertionSortRecursiveInternal(data, start + 1);
    }

    public static void insertionSortIterative(int[] data) {
        int pos = 0, insert;
        for (int i = 1; i < data.length; i++) {
            insert = data[i];
            for (pos = 0; pos < i; pos++) {
                if (data[pos] > insert)
                    break;
            }
            for (int j = i; i > pos; j--)
                data[j] = data[j - 1];
            data[pos] = insert;
        }
    }

    public static void SelectionSortRecursive(int[] data) {
        SelectionSortRecursiveInternal(data, 0);
    }

    public static void SelectionSortRecursiveInternal(int[] data, int start) {
        if (start > data.length - 1)
            return;
        int minIdx = start;
        for (int i = start; i < data.length; i++) {
            if (data[i] < data[minIdx])
                minIdx = i;
        }
        swap(data, start, minIdx);
        SelectionSortRecursiveInternal(data, start + 1);
    }

    public static void SelectionSortIterative(int[] data) {
        int minIdx = 0;
        for (int i = 0; i < data.length - 1; i++) {
            minIdx = i;
            for (int j = i; j < data.length; j++) {
                if (data[j] < data[minIdx])
                    minIdx = j;
            }
            swap(data, i, minIdx);
        }
    }

    public static int partition(int[] data, int start, int end) {
        int pivot = data[(start + end) / 2];
        while (start <= end) {
            while (data[start] < pivot)
                start++;
            while (data[end] > pivot)
                end--;
            if (start <= end) {
                swap(data, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void QuickSortRecursive(int[] data) {
        QuickSortRecursiveInternal(data, 0, data.length - 1);
    }

    public static void QuickSortRecursiveInternal(int[] data, int start, int end) {
        int part2 = partition(data, start, end);
        if (start < part2 - 1)
            QuickSortRecursiveInternal(data, start, part2 - 1);
        if (part2 < end)
            QuickSortRecursiveInternal(data, part2, end);
    }

    public static void merge(int[] data, int[] divide, int start, int mid, int end) {
        for (int i = start; i <= end; i++)
            divide[i] = data[i];
        int pos1 = start, pos2 = mid + 1;
        int idx = start;
        while (pos1 <= mid && pos2 <= end) {
            if (divide[pos1] <= divide[pos2])
                data[idx] = divide[pos1++];
            else
                data[idx] = divide[pos2++];
            idx++;
        }
        for (int i = 0; i <= (mid - pos1); i++)
            data[idx + i] = divide[pos1 + i];
    }

    public static void MergeSortRecursive(int[] data) {
        int[] divide = new int[data.length];
        MergeSortRecursiveInternal(data, divide, 0, data.length - 1);
    }

    public static void MergeSortRecursiveInternal(int[] data, int[] divide, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        MergeSortRecursiveInternal(data, divide, start, mid);
        MergeSortRecursiveInternal(data, divide, mid + 1, end);
        merge(data, divide, start, mid, end);
    }
}