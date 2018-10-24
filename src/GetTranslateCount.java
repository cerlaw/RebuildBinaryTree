/**
 * @author zhanghongjie
 * @date 2018/10/12
 * @descrition 把数字翻译成字符串,例如0翻译成“a”，1翻译成“b”...。用来计算一个数字有多少种不同的翻译方法
 */
public class GetTranslateCount {
    public static int getTranslationCount(int number) {
        if (number <= 0) {
            System.out.print("number is 0 or negative");
            System.out.println();
            return 0;
        }
        if (number == 1) {
            System.out.print("number is 1");
            System.out.println();
            return 1;
        }
        return getTranslateCountCore(number);
    }

    private static int getTranslateCountCore(int number) {
        String s = String.valueOf(number);
        int f1 = 1;
        int f2 = 1;
        int g = 0;
        int temp = 0;
        int length = s.length();
        for (int i = length - 2; i >= 0; i--) {
            int currentNumber = Integer.valueOf(s.substring(i, i + 2));
            System.out.println(currentNumber);
            if (currentNumber >= 10 && currentNumber < 26) {
                System.out.println("set g to 1");
                g = 1;
            }else {
                System.out.println("set g to 0");
                g = 0;
            }
            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
        System.out.println(getTranslationCount(12222)); //6
    }
}
