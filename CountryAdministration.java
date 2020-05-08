package com.company;
import java.util.Random;
import java.util.Scanner;

/**
 * @author IvanPetkov
 * Class направен с идея да помогне държавната администрация
 */
public class CountryAdministration {

    final public static Scanner SCANNER = new Scanner(System.in);
    final public static int ARRAY_LENGTH = arrayLength();

    public static void main(String[] args) {
        int[] ArrayOfNumbers = new int[ARRAY_LENGTH];
        System.out.print("Числата трябва да бъдат в интервал 1-100! \n");
        fillArray(ArrayOfNumbers);
        printArray(ArrayOfNumbers);


        do {
            printMenuOptions();
            int userMenuOption = takeInputUserMenuOption();
            switch (userMenuOption) {
                case 1:
                    sortArrayInAscendingOrder(ArrayOfNumbers);
                    printArray(ArrayOfNumbers); //Bubble Sort
                    break;
                case 2:
                    sortArrayInDescendingOrder(ArrayOfNumbers);
                    printArray(ArrayOfNumbers); // Bubble Sort
                    break;
                case 3:
                    findPositionOfWantedNumber(ArrayOfNumbers);
                    break;
                case 4:
                    randomizeArray(ArrayOfNumbers);
                    break;
                case 5:
                    System.out.print("Сумата на всички цифри е : " + sumNumberInArray(ArrayOfNumbers));
                    break;
                case 6:
                    System.out.print("Най-голямата цифра е : " + greatestNumberInArray(ArrayOfNumbers));
                    break;
                case 7:
                    System.out.print("Най-малката цифра е : " + smallestNumberInArray(ArrayOfNumbers));
                    break;
                case 8:
                    System.out.print("Средно аритметично на всички числа е : " + averageNumberInArray(ArrayOfNumbers));
                    break;
                case 9:
                    if (isArraySymmetric(ArrayOfNumbers)) System.out.print("Числата са симетрични");
                    else System.out.print("Числата не са симетрични");
                    break;
                case 10:
                    reverseArray(ArrayOfNumbers);
                    break;
                case 11:
                    System.out.println("Въведени числа:");
                    printArray(ArrayOfNumbers);
                    break;
                case 12: break ;



            }

        } while (doesUserWantsToContinue());

        System.out.print("Благодарим , че използвахте програмата ни!");
    }


    public static int arrayLength() {
        System.out.print("Въведете колко на брой числа ще въвеждате: ");
        return SCANNER.nextInt();
    }

    /**
     * @param array Takes array as parameter and fills it with user input data
     */
    public static void fillArray(int[] array) {
        int i = 0;
        while (i < ARRAY_LENGTH) {
            System.out.print(i + 1 + ": ");
            array[i] = SCANNER.nextInt();
            if (array[i] > 0 && array[i] <= 100) i++;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < ARRAY_LENGTH; i++) System.out.print(array[i] + " ");
    }

    public static void printMenuOptions() {
        System.out.print("\n\n Меню с опции:\n" +
                "1. Сортиране на въведените числа във възходящ ред\n" +
                "2. Сортиране на въведените числа в низходящ ред\n" +
                "3. Търсене на позиция на конкретно число\n" +
                "4. Разбъркване на числата\n" +
                "5. Изчисляване на сбора на всички числа\n" +
                "6. Намиране на най-голямото число\n" +
                "7 . Намиране на най-малкото число\n" +
                "8. Намиране средно-аритметично на числата\n" +
                "9. Проверка за симетричност на масива от числа\n" +
                "10. Обръщане на масива от числа\n" +
                "11. Визуализирай въведените числа\n" +
                "12. Изход\n" +
                " Изберете опция:  ");
    }

    /**
     * @return userMenuOption - стойноста е валидна и фукнцията присвоява стойност
     * takeInputUserMenuOption - стойноста е невалидна и се извършва рекурсия
     */
    public static int takeInputUserMenuOption() {
        int userMenuOption = SCANNER.nextInt();
        if (userMenuOption > 0 && userMenuOption < 13) {
            return userMenuOption;
        }
        System.out.print("\nНевалидна меню опция, опитайте отново :");
        return takeInputUserMenuOption();
    }

    /**
     * takes basic yes/no input
     *
     * @return If the program should continue or not
     */
    public static boolean doesUserWantsToContinue() {
        System.out.print("\nБихте ли желани да се върнете в главното меню ?: (yes/no) ");
        String Answer = SCANNER.next();
        if (Answer.equals("yes") || Answer.equals("Yes") || Answer.equals("YES")) return true;
        if (Answer.equals("no") || Answer.equals("No") || Answer.equals("NO")) return false;
        System.out.print("\nInvalid input, try again: ");
        return doesUserWantsToContinue();
    }

    /**
     * Bubble sort array
     *
     * @param array Takes array as parameter and sorts it in Ascending order
     */
    public static void sortArrayInAscendingOrder(int[] array) {
        {

            for (int i = 0; i < ARRAY_LENGTH - 1; i++)
                for (int j = 0; j < ARRAY_LENGTH - i - 1; j++)
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
        }
    }

    /**
     * Bubble sort array
     *
     * @param array Takes array as parameter and sorts it in Descending order
     */
    public static void sortArrayInDescendingOrder(int[] array) {
        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            for (int j = 0; j < ARRAY_LENGTH - i - 1; j++) {

                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void findPositionOfWantedNumber(int[] array) {
        System.out.print("Въведете числото, чиято позиция искате да намерите :");
        int Wanted = SCANNER.nextInt();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (array[i] == Wanted) {
                System.out.printf("\nЧислото %d , е намерено на позиция %d", array[i], i + 1);
            }
        }


    }

    private static void randomizeArray(int[] array) {
        int index, temp;
        Random rand = new Random();
        System.out.print("\nРазбърканите числа са: ");
        for (int i = ARRAY_LENGTH - 1; i >= 0; i--) {
            index = rand.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            System.out.print(array[i] + " ");
        }
    }

    private static int sumNumberInArray(int[] array) {
        int SUM = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            SUM += array[i];
        }
        return SUM;
    }

    private static int greatestNumberInArray(int[] array) {
        int MAX = array[0];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (array[i] > MAX) MAX = array[i];
        }
        return MAX;
    }

    private static int smallestNumberInArray(int[] array) {
        int MIN = array[0];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (array[i] < MIN) MIN = array[i];
        }
        return MIN;
    }

    private static int averageNumberInArray(int[] array) {
        int AVERAGE = 0;
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            AVERAGE += array[i];
        }
        return AVERAGE / ARRAY_LENGTH;
    }

    private static void reverseArray(int[] array) {
        for (int i = ARRAY_LENGTH - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     *
     * @param array
     * @return връща булева стойност дали масивът е симетричен
     */
    private static boolean isArraySymmetric(int[] array) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {

            if (!(array[i] == array[ARRAY_LENGTH - 1 - i] ) && i <= array[i] / 2) return false;
        }
    return true;
    }
}








