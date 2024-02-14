package ru.rusalitc.java.basic.homework11;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList<>();
        list.addFirst(10);
        list.addFirst(15);
        list.addLast(20);
        System.out.println("ДЗ часть 1");
        System.out.println("Новый список MyLinkedList состоит из элементов:");
        print(list);
        int index = 2;
        int volue = 30;
        System.out.println("Добавляем новый элемент: " + volue + " на позицию: " + index);
        list.add(2, 30);
        print(list);
        System.out.println("Удаляем элемент с позиции: " + index);
        list.remove(2);
        print(list);
        System.out.println();

        System.out.println("ДЗ часть 2");

        int[] arrayLength = {10, 1000, 10000, 100000};

        for (int i = 0; i < 4; i++) {


            int[] array1 = new int[arrayLength[i]];
            for (int j = 0; j < array1.length; j++) {
                array1[j] = (int) (Math.random() * 100);
            }

            int[] array2 = array1.clone();

            System.out.println("Имеется массив из " + array1.length + " элементов:");


            Measure.stamp();
            sort1(array1);
            System.out.println("Массив отсортирован методом Пузырек");
            Measure.print();

            if (arrayLength[i] == 10) {
                System.out.println(Arrays.toString(array1));
            }

            Measure.stamp();
            sort2(array2);
            System.out.println("Массив отсортирован методом Слияние");
            Measure.print();
            if (arrayLength[i] == 10) {
                System.out.println(Arrays.toString(array2));
            }
            System.out.println();
        }
    }


    public static int[] sort1(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    private static void print(MyLinkedList list) {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void sort2(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }
        sort2(left);
        sort2(right);

        merge(array, left, right, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
