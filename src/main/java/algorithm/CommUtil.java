package algorithm;

/**
 * @author taotao
 */

public class CommUtil {

    public static int[] defaultArray = {3, 4, 11, 0, 55, 32, 11, 4, 23};

    public static void printArray(int[] array){
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (i != 0){
                System.out.print("," + array[i]);
            } else {
                System.out.print(array[i]);
            }
        }
    }

    public static void printArray(int[] array, int... loopCount){
        int arrayLen = array.length;
        int loopLen = loopCount.length;
        for (int i = 0; i < loopLen; i++) {
            if (i != 0){
                System.out.print("," + loopCount[i]);
            } else {
                System.out.print(loopCount[i]);
            }
        }
        System.out.println("\n");
        for (int i = 0; i < arrayLen; i++) {
            if (i != 0){
                System.out.print("," + array[i]);
            } else {
                System.out.print(array[i]);
            }
        }
    }
}
