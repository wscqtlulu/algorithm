package algorithm.others;

//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
//
//
// 'A' : Absent，缺勤
// 'L' : Late，迟到
// 'P' : Present，到场
//
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。
//
// 示例 1:
//
// 输入: "PPALLP"
//输出: True
//
//
// 示例 2:
//
// 输入: "PPALLL"
//输出: False
//
// Related Topics 字符串


//学生出勤记录1
//leetcode submit region begin(Prohibit modification and deletion)
class CheckRecord {
    public boolean checkRecord(String s) {
        int l = s.length();
        int aCount = 0;
        int lCount = 0;
        for (int i = 0; i < l; i++) {
            if ('A' == s.charAt(i)){
                aCount++;
                if (aCount > 1) {
                    return false;
                }
                lCount = 0;
            } else if ('L' == s.charAt(i)){
                lCount++;
                if (lCount > 2) {
                    return false;
                }
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

