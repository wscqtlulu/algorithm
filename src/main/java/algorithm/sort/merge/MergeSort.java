package algorithm.sort.merge;

import algorithm.CommUtil;

/**
 * @author taotao
 *
 * 归并排序
 * 将数组二拆分，拆分到每组只有一个元素时相当于这个单元素数组是有序数组，再将数组两两合并，需要使合并后的数组有序，之后再将多个数组逐步合并，保持每个数组合并后都有序。
 *
 * 数组合并方法：两个有序数组a[],b[]合并，新建一个临时数组temp[]，一开始比较两数组第一个元素，
 * 若a[0]>b[0]，将b[0]加入数组temp[0]，b[]数组坐标后移继续b[1]跟a[0]比较，
 * 比较之后继续把较小的数放入临时数组temp[]下一位，取出元素的那个数组坐标继续后移一位进行后面的比较，
 * 这样每次进入临时数组的数都是两数组剩余元素最小的元素，
 * 当其中一个数组元素比较完了，因为数组都是有序的，所以另一个数组剩余所有元素都是有序的，
 * 只要逐个放入临时数组，临时数组最后就是两个数组合并后依然有序的数组，将原数组跟临时数组替换即完成两数组的合并排序。
 */
public class MergeSort {

    public static void sort(int[] array, int[] temp, int left, int right){
        if (right <= left){
            return;
        }
        int midIndex = left + (right - left)/2;
        sort(array, temp, left, midIndex);
        sort(array, temp, midIndex + 1, right);
        merge(array, temp, left, midIndex + 1, right);
    }

    public static void merge(int[] array, int[] temp, int left, int mid, int right){
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int start = left;
        int end = right;

        for(int i = start; i <= end; i++){
            if (left > mid){
                array[i] = temp[mid++];
            } else if (mid > end){
                array[i] = temp[left++];
            } else if (temp[left] < temp[mid]){
                array[i] = temp[left++];
            } else {
                array[i] = temp[mid++];
            }
        }
    }

    public static void main(String[] args) {
        //未完成，有bug
        int[] array = CommUtil.defaultArray;
        int length = array.length;
        int[] temp = new int[length];
        sort(array, temp, 0, length - 1);
        CommUtil.printArray(array);
    }
}
