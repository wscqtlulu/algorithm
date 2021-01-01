package algorithm.sort.insert;

import algorithm.CommUtil;

/**
 * @author taotao
 *
 * 插入排序
 * 首先将待排序数组的第一个元素作为一个初始元素个数为1的有序数组，之后将剩余所有元素逐个插入这个有序数组的正确的位置，使有序数组一直处于有序。
 * 跟打牌的时候一张一张整理牌的场景一样，首先有一组自己的牌堆，拿第一张到手上，此时手上的牌就是一个有序数组（一张牌的数组肯定是有序的），
 * 拿第二张牌跟手上的牌对比，比手上的牌大则放在手上的牌组里的最后一个位置，比手上的牌小则放在手上的牌组的第一个位置，
 * 拿第三张牌到手上的时候，需要从手牌最后一张牌（最大那张牌）开始做比较（从右到左），将牌放在手牌里正确的位置，使手牌永远有序，之后重复同样操作。
 */
public class InsertSort {

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            //待插入元素
            int insertValue = array[i];
            //数组元素比较的位置
            int index = i - 1;
            while (index >= 0 && array[index] > insertValue){
                array[index + 1] = array[index];
                index --;
            }
            array[index + 1] = insertValue;
        }
        CommUtil.printArray(array);
    }

    public static void main(String[] args) {
        insertSort(CommUtil.defaultArray);
    }
}
