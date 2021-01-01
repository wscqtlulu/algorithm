package algorithm.sort.bubble;

import algorithm.CommUtil;

/**
 * @author taotao
 *
 * 冒泡排序
 * 正序：遍历数组，数组前后两个元素对比，如果前一个元素比后一个元素大，则这两个元素交换位置，遍历完一次数组后，
 *      最大的元素会被压到数组最后一个位置，之后再遍历数组前len-1个元素。
 * 逆序则判断前一个元素比后一个元素小。
 */
public class BubbleSort1 {

    public static void bubbleSort(int[] array){
        int outLoopCount = 0;
        int inLoopCount = 0;
        int len = array.length;
        if (len == 0){
            System.out.println("数组无元素");
        } else if (len == 1){
            System.out.println(array[0]);
        } else {
            for (int i = len; i > 0; i--) {
                outLoopCount++;
                for (int j = 0; j < i - 1; j++) {
                    inLoopCount++;
                    if (array[j] > array[j + 1]){
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
            CommUtil.printArray(array, outLoopCount, inLoopCount);
        }
    }

    public static void main(String[] args) {
        bubbleSort(CommUtil.defaultArray);
    }
}
