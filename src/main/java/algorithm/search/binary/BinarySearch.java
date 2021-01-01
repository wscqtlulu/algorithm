package algorithm.search.binary;

/**
 * @author taotao
 *
 * 二分查找
 * 需要数组有序，目标数a跟数组中间位置mid的数字比较，
 * 若a小，则说明a在数组中间位置前半段（左边）的地方，则在数组前半段继续相同的判断
 * 若a大，则说明a在数组中间位置后半段（右边）的地方，则在数组后半段继续相同的判断
 */
public class BinarySearch {

    private static int noQueries = -1;

    public static int binarySearch(int[] array, int a){
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low < high){
            //mid = (low + high)/2;//low和high太大时会溢出
            mid = low + (high - low)/2;
            if (array[mid] == a){
                return mid + 1;
            } else if (array[mid] > a){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return noQueries;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 11, 22, 33, 34, 36};
        int a = 33;
        int position = binarySearch(array, a);
        System.out.println(position == noQueries ? "未查询到该数字" : "a的位置在数组的第" + position + "位");
    }
}
