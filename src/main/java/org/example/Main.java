package org.example;

// данны массив ордеред на выход сортированный

import java.util.Arrays;

public class Main {

    /*
        1) Создается новый массив squaredSortedArray той же длины, что и входной массив arr.
        2) Создаеи два индекса, leftIndex и rightIndex, указывающие на крайние элементы в отсортированном массиве.
        3) В if...else сравнение квадратов двух элементов и присвоение квадрата большего из них в новый массив.

     */
    private static int[] SquaredArray(int[] arr) {
        int[] squaredSortedArray = new int[arr.length];
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.pow(arr[leftIndex], 2) >= Math.pow(arr[rightIndex], 2)) {
                squaredSortedArray[arr.length - i - 1] = (int) Math.pow(arr[leftIndex], 2);
                leftIndex++;
            } else {
                squaredSortedArray[arr.length - i - 1] = (int) Math.pow(arr[rightIndex], 2);
                rightIndex--;
            }
        }
        return squaredSortedArray;
    }
    /*
        Решение которое я предлагал в пятницу без сравнения квадратов, а модулей чисе.
        Проблема заключается в том, что если использовать этот же массив для возращения данных, то во время сртировки
        и возведения в квадрат,то некторые крайние левые значения не будут отсортированы.

        Минусы постоянного сравнения модуля это дольше чем сразу возвести в квадрат и сравнивать квадраты.
     */

    public static void squareArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if(Math.abs(arr[0]) <= Math.abs(arr[i])){
                arr[i] = (int)Math.pow(arr[i],2);
            }else {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = (int)Math.pow(tmp,2);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-7, -4, -3, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Входной массив: " + Arrays.toString(arr));

        squareArray(arr);
        System.out.println("Выходной массив: "+ Arrays.toString(arr));
    }
}