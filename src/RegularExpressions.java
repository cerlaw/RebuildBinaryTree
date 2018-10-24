/**
 * @author zhanghongjie
 * @date 2018/9/26
 * @descrition 正则表达式匹配，实现一个函数用来匹配'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）
 *
 */
public class RegularExpressions {
    private boolean match(char[] strings, char[] pattern) {
        if (strings == null || pattern == null) {
            return false;
        }
        if (strings.length == 0 && pattern.length == 0) {
            return true;
        }
        if (strings.length == 0 || pattern.length == 0) {
            return false;
        }
        return matchCore(strings, 0, pattern, 0);
    }

    private boolean matchCore(char[] strings, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == strings.length - 1 && patternIndex == pattern.length - 1) {
            return true;
        }
        if (strIndex != strings.length - 1 && patternIndex == pattern.length - 1) {
            return false;
        }

        char star = '*';
        char dot = '.';
        if (pattern[patternIndex + 1] == star) {
            if (pattern[patternIndex] == strings[strIndex] || (pattern[patternIndex] == dot && strIndex != strings.length - 1)) {
                return matchCore(strings, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(strings, strIndex + 1, pattern, patternIndex)
                        || matchCore(strings, strIndex, pattern, patternIndex + 2);
            }else {
                return matchCore(strings, strIndex, pattern, patternIndex + 2);
            }
        }

        if (pattern[patternIndex] == strings[strIndex] || (pattern[patternIndex] == dot && strIndex != strings.length - 1)) {
            return matchCore(strings, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressions re = new RegularExpressions();
//        char[] strings = new char[]{'a', 'a', 'a'};
//        char[] pattern = new char[]{'a', 'a', '.', 'a'};
//        String pattern = "ab*ac*a";
        String strings = "";
        String pattern = "";
        System.out.print(re.match(strings.toCharArray(), pattern.toCharArray()));
    }
}
