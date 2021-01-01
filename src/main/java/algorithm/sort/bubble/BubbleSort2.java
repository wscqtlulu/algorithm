package algorithm.sort.bubble;

import algorithm.CommUtil;

/**
 * @author taotao
 *
 * 冒泡排序
 * 引入orderly判断数组是否已有序
 * orderly：是否有序的标志，如果进行完一次遍历（所以至少需要遍历一次此参数才有效）都没发生过一次交换，说明数组已经处于有序，可以直接退出循环
 */
public class BubbleSort2 {

    public static void bubbleSort(int[] array){
        int outLoopCount = 0;
        int inLoopCount = 0;
        int len = array.length;
        if (len == 0){
            System.out.println("数组无元素");
        } else if (len == 1){
            System.out.println(array[0]);
        } else {
            //是否有序的标志，如果进行完一次遍历（所以至少需要遍历一次此参数才有效）都没发生过一次交换，说明数组已经处于有序，可以直接退出循环
            boolean orderly = true;
            for (int i = len; i > 0; i--) {
                outLoopCount++;
                if (i == len){
                    for (int j = 0; j < i - 1; j++) {
                        inLoopCount++;
                        if (array[j] > array[j + 1]){
                            int temp = array[j + 1];
                            array[j + 1] = array[j];
                            array[j] = temp;
                            orderly = false;
                        }
                    }
                } else {
                    if (orderly){
                        break;
                    } else {
                        orderly = true;
                        for (int j = 0; j < i - 1; j++) {
                            inLoopCount++;
                            if (array[j] > array[j + 1]){
                                int temp = array[j + 1];
                                array[j + 1] = array[j];
                                array[j] = temp;
                                orderly = false;
                            }
                        }
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
