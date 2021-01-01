package algorithm.sort.quick;

import algorithm.CommUtil;

/**
 * @author taotao
 * 快排，单边扫描
 */
public class QuickSort2 {

    public static void sort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int partition = partition(arr, start, end);
        sort(arr, start, partition);
        sort(arr, partition + 1, end);
    }

    public static int partition(int[] arr, int start, int end){
        //mark记录比基准值小的数组边界
        int mark = start;
        int value = arr[start];
        for(int i = start + 1; i < end; i++){
            //找到一个比基准值小的元素，就把mark加1（指针往后移以为），然后把这个比基准值小的元素和当前mark位置的元素互换位置
            if(arr[i] < value){
                mark ++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        //遍历完成，mark最后一个位置跟基准值（数组首位）互换位置，则互换之后mark位置前的值都小于或等于mark位置的值，mark位置后面的值都大于mark位置的值
        arr[start] = arr[mark];
        arr[mark] = value;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = CommUtil.defaultArray;
        sort(arr, 0, arr.length);
        CommUtil.printArray(arr);
    }
}
