package algorithm.sort.quick;

import algorithm.CommUtil;

public class QuickSort1 {

    public static void sort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int start = left;
        int end = right;
        int value = array[start];
        while (left < right){
            while (array[left] < value && left < right){
                left++;
            }
            while (array[right] > value && left < right){
                right--;
            }
            if (left < right){
                int t = array[left];
                array[left] = array[right];
                array[right] = t;
            }
        }
        array[start] = array[left];
        array[left] = value;
        CommUtil.printArray(array);
        System.out.println();
        sort(array, start, left - 1);
        sort(array, left + 1, end);
    }

    private static void sort1(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        CommUtil.printArray(arr);
        System.out.println();
        //切分
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort1(arr, startIndex, pivotIndex-1);
        sort1(arr, pivotIndex+1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];//取第一个元素为基准值

        while (true) {
            //从左往右扫描
            while (arr[left] <= pivot) {
                left++;
                if (left == right) {
                    break;
                }
            }

            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }

            //左右指针相遇
            if (left >= right) {
                break;
            }

            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //将基准值插入序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;
    }

    public static void sort(int[] arr) {
        sort1(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        int[] array = CommUtil.defaultArray;
        sort(array);
//        CommUtil.printArray(array);
    }
}
