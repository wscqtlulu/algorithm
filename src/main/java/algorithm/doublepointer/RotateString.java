package algorithm.doublepointer;

//给定两个字符串, A 和 B。
//
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
//，A 能变成B，那么返回True。
//
//
//示例 1:
//输入: A = 'abcde', B = 'cdeab'
//输出: true
//
//示例 2:
//输入: A = 'abcde', B = 'abced'
//输出: false
//
// 注意：
//
//
// A 和 B 长度不超过 100。
//
//


//旋转字符串
//leetcode submit region begin(Prohibit modification and deletion)
class RotateString {
    public boolean rotateString(String s, String goal) {
        if ("".equals(s)){
            if ("".equals(goal)) {
                return true;
            } else {
                return false;
            }
        }
        char[] sChar = s.toCharArray();
        char[] gChar = goal.toCharArray();
        if (sChar.length != gChar.length) {
            return false;
        }
        int sIndex = 0;
        int gIndexS = 0;
        int gIndexE = gIndexS;
        while (gIndexS != gChar.length) {
            if (sChar[sIndex] == gChar[gIndexE]){
                sIndex++;
                gIndexE++;
                if (gIndexE == gChar.length) {
                    gIndexE = 0;
                }
                if (gIndexE == gIndexS) {
                    return true;
                }
            } else {
                sIndex = 0;
                gIndexS++;
                gIndexE = gIndexS;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

