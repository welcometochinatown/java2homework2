package ru.home.java2.homework;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        /*
        1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

        2 Далее метод должен пройтись по всем элементам массива,
        преобразовать в int и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например,
        в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

        3 В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
        при условии что подали на вход корректный массив).

        Заметка: Для преобразования строки к числу используйте статический метод класса Integer:
        Integer.parseInt(сюда_подать_строку);

        Заметка: Если Java не сможет преобразовать входную строку (в строке число криво написано),
        то будет сгенерировано исключение NumberFormatException.
         */

        String[][] strings = {
//                Test1 i length == 5
//                {"1", "2", "3", "4", "5"},
//                {"1", "2", "3", "4", "5"},
//                {"1", "2", "3", "4", "5"},
//                {"1", "2", "3", "4", "5"}

//                Test2 j length == 5
//                {"1", "2", "3", "4"},
//                {"1", "2", "3", "4"},
//                {"1", "2", "3", "4"},
//                {"1", "2", "44", "4"},
//                {"1", "2", "3", "4"}

//                Test 3 good data to convert
//                {"1", "2", "3", "4"},
//                {"1", "2", "3", "4"},
//                {"1", "2", "44", "4"},
//                {"1", "2", "3", "4"}

//                Test 4 bad data in arrays
                {"1", "2", "c3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "44", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println("Сумма элементов в массиве: " + takeArrays(strings));
        } catch (MyArrayDataException | MyArraySizeException dataAndSizeException) {
            dataAndSizeException.printStackTrace();
        }
    }

    public static int takeArrays(String[][] strings) {
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings.length > 4) {
                throw new MyArraySizeException("Неправильный размер массива");
            }
            for (int j = 0; j < strings[i].length; j++) {
                if (strings[i].length > 4) {
                    throw new MyArraySizeException("Неправильный размер массива");
                }
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException formatException) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
