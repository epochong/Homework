package www.epochong.homework.java.Chapter3;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//构建大根堆
        }
        int size = arr.length;
        swap(arr, 0, --size);//交换根结点和最后一个结点，破坏了大根堆的结构
        while (size > 0) {//不断重复交换根结点和最后一个节点，并且每交换一次要进行一次重建堆的过程，交换的根结点不包含在内
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    /*
     *                       0
     *                1              2
     *            3       4        5   6
     *          7   8   9   10
     *
     *  (index - 1) / 2 是父结点的位置
     *  0 的父结点是自己
     *
     * */
    //从下向上建立大根堆
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {//当当前结点大于他的父节结点就交换位置，因为传过来的是当前结点，然后不断的向上
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;//大的数一步步向上到自己原来父结点的位置
        }
    }
    //交换首尾之后重建堆的过程，重建堆的时候小值顺着较大子树下去，最后一个位置的数不参与交换
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {//index 左右子树都全 或 只有左子树
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;//左右子树都全，且右子树大时，下标为右，不全，或左大为左
            largest = arr[largest] > arr[index] ? largest : index;//largest指向父结点和左右子树中较大值的下标
            if (largest == index) {//如果较大值不在子树而是父节点说明已经是大根堆了不用再重建堆
                break;
            }
            swap(arr, largest, index);//如果较大值在孩子中，就和父结点交换
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{25,24,12,76,101,96,28};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

