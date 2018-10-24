public class Print1ToMaxOfNDigits<main> {
    private void Print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private void Print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            PrintNunber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private void PrintNunber(char[] number) {
        boolean beginningWith0 = true;
        int length = number.length;
        for (int i = 0; i < length; i++) {
            if (beginningWith0 && number[i] != '0') {
                beginningWith0 = false;
            }

            if (!beginningWith0) {
                System.out.printf("%c", number[i]);
            }
        }
        System.out.print("\t");
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits object = new Print1ToMaxOfNDigits();
        object.Print1ToMaxOfNDigits(3);
    }
}
