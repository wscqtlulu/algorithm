package algorithm.sort.quick;

import algorithm.CommUtil;

/**
 * @author taotao
 *
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] array, int low, int high){
        int l = low;
        int h = high;
        //取最后一个元素作为基准值
        int operationValue = array[high];
        while (l < h){
            //从前往后找到一个比基准值大的数的位置，将这个位置（l）的数（array[l]）跟现在基准值所在的位置（h）的数（array[h]）互换位置。
            while (l < h && array[l] < operationValue){
                l++;
            }
            if (l < h){
                int temp = array[h];
                array[h] = array[l];
                array[l] = temp;
                h--;
            }
            CommUtil.printArray(array);
            System.out.println();

            //从后往前找到一个比基准值小的数的位置，将这个位置（h）的数（array[h]）跟现在基准值所在的位置（l）的数（array[l]）互换位置。
            while (l < h && array[h] > operationValue){
                h--;
            }
            if (l < h){
                int temp = array[h];
                array[h] = array[l];
                array[l] = temp;
                l++;
            }
            CommUtil.printArray(array);
            System.out.println();
        }
        if (low < l){
            quickSort(array, low, l - 1);
        }
        if (high > h){
            quickSort(array, h + 1, high);
        }
    }
    public static void main(String[] args) {
        System.out.print("初始数组：");
        CommUtil.printArray(CommUtil.defaultArray);
        System.out.println();
        quickSort(CommUtil.defaultArray, 0, CommUtil.defaultArray.length - 1);
    }
}
