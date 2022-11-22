import java.util.Scanner;

public class ReverseNumberCourseWork2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число, яке не містить 0:");
        int myNumber = scanner.nextInt();
        if (numberWithoutZero(myNumber)) {
            System.out.println("Інверсійне число першим методом з розрядами числа: " + reverseVer1(myNumber));
            System.out.println("Інверсійне число другим методом з класом StringBuilder: " + reverseVer2(myNumber));
            System.out.println("Інверсійне число третім методом з масивом: " + reverseVer3(myNumber));
            System.out.println("Інверсійне число четвертим методом з .substring ();: " + reverseVer4(myNumber));
            System.out.println("Інверсійне число п'ятим методом з charAt();: " + reverseVer5(myNumber));
        }
        else System.out.println("Число містить 0");
    }

    static boolean numberWithoutZero (int a) {              // Перевірка на 0
        String s = Integer.toString(a);
        boolean zero = false;
        if (s.indexOf('0') == -1) zero = true;              // якщо число не містить 0, значення s.indexOf('0') дорівнює -1
        return zero;
    }

    static int reverseVer1(int a) {                        // Версія з розрядами числа
        int result = 0;
        int digitOfNumber = 0;
        for (int j = 1; j <= a * 10; j *= 10) {               // знаходимо найбільший розряд числа
            if (a / j == 0) digitOfNumber = j / 10;
        }
        for (int i = 1; i <= a; i *= 10) {
            int b = a % (10 * i);                           // знаходимо одиниці/десятки і т д початкового числа
            a -= b;                                         // позбавляємось від найменшого розряду початкового числа
            result += b / i * digitOfNumber;                // формуємо інверсне число
            digitOfNumber /= 10;                            // переходимо на формування меншого розряду інверсного числа
        }
        return result;
    }

    static int reverseVer2(int a) {                        // Версія з класом StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder number = stringBuilder.append(a);
        StringBuilder result = number.reverse();
        return Integer.parseInt(result.toString());
    }

    static int reverseVer3(int a) {                         // Версія з масивом
        String s = Integer.toString(a);
        char[] arrayReverse = new char[s.length()];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            arrayReverse[i] = array[array.length - 1 - i];
        }
        s = String.valueOf(arrayReverse);
        return Integer.parseInt(s);
    }

    static int reverseVer4(int a) {                         // Версія з .substring ();
        String s = Integer.toString(a);
        String number = new String();
        for (int i = s.length(); i > 0; i--) {
            String partOfNumber = s.substring((i - 1), i);
            number += partOfNumber;
        }
        return Integer.parseInt(number);
    }

    static int reverseVer5(int a) {                         // Версія з charAt();
        String s = Integer.toString(a);
        String number = new String();
        for (int i = s.length(); i > 0; i--) {
            char partOfNumber = s.charAt(i - 1);
            number += partOfNumber;
        }
        return Integer.parseInt(number);
    }
}
