package datastructures.heap;

import algorithm.CommUtil;

/**
 * @author taotao
 * 二叉堆
 * 小堆，任何一个父节点的值都小于或等于左右孩子节点
 */
public class BinaryHeap {

    /**
     * 上浮，小的数值上浮
     * @param arr
     */
    public static void upAdjust(int[] arr){
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1)/2;
        int temp = arr[childIndex];
        while (childIndex > 0 && temp < arr[parentIndex]){
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
        arr[childIndex] = temp;
    }

    /**
     * 下沉，父节点比任意一个子节点大，则跟最小的那个子节点交换位置
     * @param arr
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] arr, int parentIndex, int length){
        int temp = arr[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        //如果有子节点
        while (childIndex < length){
            //如果有右子节点且右子节点比左子节点小，则定位到右子节点，用右子节点跟父节点比较大小，否则还是用左子节点跟父节点比较大小
            if (childIndex + 1 < length && arr[childIndex] > arr[childIndex + 1]){
                childIndex ++;
            }
            //父节点比最小的子节点还小则不用下沉
            if (arr[childIndex] >= temp){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }

    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始依次下沉,最后一个非叶子节点 parentIndex = (child - 1)/2，child = arr.length - 1；
        for (int i = (array.length - 1 - 1)/2; i > 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        CommUtil.printArray(array);

        System.out.println();

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        CommUtil.printArray(array);
    }

}
