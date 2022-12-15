import java.util.InputMismatchException;
import java.util.Scanner;

public class lab3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        while (true){
            try{
                int k = in.nextInt();
                if (k<=0){
                    System.err.println("Ошибка. Длина массива должна быть больше 0");
                    System.exit(1);
                    in.close();
                }
                int[] array = new int[k];
                for (int i = 0; i < k; i++) {
                    System.out.println("Введи элемент массива: ");
                    array[i] = in.nextInt();
                }
                System.out.print("Исходный массив: ");
                for (int elem :array){
                    System.out.print(elem+" ");
                }
                System.out.print("\n"+"Число к удалению: ");
                int delete = in.nextInt();
                System.out.print("Массив после обработки: ");
                for (int m = 0; m < array.length; m++) {
                    if (array[m] != delete) {
                        System.out.print(array[m]+" ");
                    }
                }

            }
            catch (InputMismatchException e){
                System.err.println("Ошибка, массив и число к удалению должны быть целыми");
                System.exit(1);
                in.close();
            }
        }
    }
}
