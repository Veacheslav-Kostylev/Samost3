import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class lab3_3 {
    public static void main(String[] args) {
        double[] firstArray = new double[]{};
        double[] array = new double[]{};
        double[] newArray = new double[]{};

        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Введите первый элемент массива: Для выхода введите exit: ");
        while (!in.hasNext("exit")) {
            while (true) {
                if (in.hasNextDouble()) {
                    firstArray = Arrays.copyOf(array, array.length + 1);
                    firstArray[firstArray.length - 1] = in.nextDouble();
                    array = Arrays.copyOf(firstArray, firstArray.length);
                    System.out.print("Введите следующий элемент массива: ");
                    break;
                }
                else if (!in.hasNext("exit")) {
                    System.out.print("Ошибка. Вы ввели не число, повторите ввод: ");
                    in.next();
                }
                else {
                    break;
                }
            }
        }

        System.out.println("Длинна исходного массива: " + firstArray.length);

        System.out.print("Исходный массив: ");
        for (double x : firstArray)
            if (x % 1 == 0) {
                System.out.print((int) x + " ");
            }
            else {
                System.out.print(x + " ");
            }

        double elem = firstArray[0];
        for (int i = 1; i < firstArray.length; i++) {
            int position;
            if (elem >= firstArray[i]) {
                position = i;
                newArray = new double[firstArray.length - 1];
                System.arraycopy(firstArray, 0, newArray, 0, position);
                System.arraycopy(firstArray, position + 1, newArray, position, firstArray.length - 1 - position);
                firstArray = Arrays.copyOf(newArray, newArray.length);
                i--;
            }
            else {
                elem = firstArray[i];
            }
        }

        System.out.print("Массив после обработки: ");
        if (newArray.length > 0) {
            for (double x : newArray)
                if (x % 1 == 0) {
                    System.out.print((int) x + " ");
                } else {
                    System.out.print(x + " ");
                }
        }
        else {
            for (double x : firstArray)
                if (x % 1 == 0) {
                    System.out.print((int) x + " ");
                } else {
                    System.out.print(x + " ");
                }
        }

        in.close();
    }
}
