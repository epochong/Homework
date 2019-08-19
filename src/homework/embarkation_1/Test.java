package EmbarkationOne;

public class Test {
    public static void printArray(int[][] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
    /**
     *
     * @param maxSize
     * @param maxValue
     * @return 返回一个二维数组，maxSize行，2列，数组中的每个数都是随机的，随机大小在[0,maxValue]范围内
     */
    public static int[][] generateRandomArray(int maxSize,int maxValue) {
        int[][] arr = new int[maxSize][2];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = (int) ((maxValue + 1) * Math.random()) + 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = generateRandomArray(200,100000);
        printArray(arr);
    }
}

