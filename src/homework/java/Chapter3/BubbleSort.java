package www.epochong.homework.java.Chapter3;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr,i,i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {25,24,12,76,101,96,28};
        bubbleSort(arr);
        printArray(arr);
    }
}
