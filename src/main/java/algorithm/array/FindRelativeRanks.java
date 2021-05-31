package algorithm.array;

//给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal",
// "Silver Medal", "Bronze Medal"）。
//
// (注：分数越高的选手，排名越靠前。)
//
// 示例 1:
//
//
//输入: [5, 4, 3, 2, 1]
//输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and
//"Bronze Medal").
//余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
//
// 提示:
//
//
// N 是一个正整数并且不会超过 10000。
// 所有运动员的成绩都不相同。
//
//


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//相对名次
//leetcode submit region begin(Prohibit modification and deletion)
class FindRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] strings = new String[score.length];
        LinkedList<Integer> temp = new LinkedList<Integer>();
        for (int i = 0; i < score.length; i++) {
            temp.add(score[i]);
        }
        Collections.sort(temp);
        Collections.reverse(temp);
        for (int i = 0; i < score.length; i++) {
            int index = temp.indexOf(score[i]);
            if (index == 0) {
                strings[i] = "Gold Medal";
            } else if (index == 1) {
                strings[i] = "Silver Medal";
            } else if (index == 2) {
                strings[i] = "Bronze Medal";
            } else {
                strings[i] = String.valueOf(index + 1);
            }
        }
        return strings;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

