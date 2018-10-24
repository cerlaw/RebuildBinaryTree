/**
 * @author zhanghongjie
 * @date 2018/10/16
 * @descrition 请从字符串中找出一个最长的不包含重复字符的子字符串
 */
public class LongestSubstringWithoutDuplication {
    private int longestSubstringWithoutDuplication(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int curLength = 0;
        int maxLength = 0;

        int[] preIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            preIndex[i] = -1;
        }
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            int index = s.charAt(i) - 'a';
            if (preIndex[index] < 0 || i - preIndex[index] > curLength) {
                //该数字第一次出现或者该数字不在当前字符串中仍有长度加一
                curLength++;
            }else {
                //该数字出现了在当前字符串中
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                //更新当前字符串长度
                curLength = i - preIndex[index];
            }
            //更新该字符串上一次出现的位置
            preIndex[index] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutDuplication longestSubstringWithoutDuplication = new LongestSubstringWithoutDuplication();
        //4
        System.out.println(longestSubstringWithoutDuplication.longestSubstringWithoutDuplication("arabcacfr"));
        //6
        System.out.println(longestSubstringWithoutDuplication.longestSubstringWithoutDuplication("abcdef"));
        //0
        System.out.println(longestSubstringWithoutDuplication.longestSubstringWithoutDuplication(""));
        //1
        System.out.println(longestSubstringWithoutDuplication.longestSubstringWithoutDuplication("aaaaaa"));
        //1
        System.out.println(longestSubstringWithoutDuplication.longestSubstringWithoutDuplication("w"));
    }
}
