package ru.rusalitc.java.basic.homework11;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addFirst(T data) {   // Метод №1 - добавление в начало  
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {   // Метод №2 - добавление в конец 
        Node<T> newNode = new Node<>(data);
        if (last == null) {   // 
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T getFirst() {      // Метод №3 - возвращение перовго элемента
        if (first == null) {
            throw new NoSuchElementException("Список пустой");
        }
        return first.data;
    }

    public T getLast() {       // Метод №4 - возвращение последнего элемента
        if (last == null) {
            throw new NoSuchElementException("Список пустой");
        }
        return last.data;
    }

    public void add(int position, T data) { // Метод №5 - добавление элемента на указанную позицию
        if (position > size) {
            throw new IndexOutOfBoundsException("Недопустимая позиция");
        }
        if (position == 0) {
            addFirst(data);
        } else if (position == size) {
            addLast(data);
        } else {
            Node<T> temp = getNode(position);
            Node<T> newNode = new Node<>(data);
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
    }

    public T remove(int position) {  // Метод №6 - удаление элемента
        if (position >= size) {
            throw new IndexOutOfBoundsException("Недопустимая позиция");
        }
        Node<T> temp = getNode(position);
        if (temp.prev == null) {
            first = temp.next;
        } else {
            temp.prev.next = temp.next;
        }
        if (temp.next == null) {
            last = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }
        size--;
        return temp.data;
    }

    public T get(int position) {  // Метод №7 - возвращение элемента
        if (position >= size) {
            throw new IndexOutOfBoundsException("Недопустимая позиция");
        }
        Node<T> temp = getNode(position);
        return temp.data;
    }

    public int getSize() {  // Метод№8 - возвращение количества элементов
        return size;
    }

    private Node<T> getNode(int position) { // Доп.метод - возвращение элемента
        Node<T> temp;
        if (position < size / 2) {
            temp = first;
            for (int i = 0; i < position; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > position; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

   // public void print(MyLinkedList) {
//        Node<T> temp = first;
//        System.out.print("[ " + first);
//        for (int i = 0; i < size - 2; i++) {
//            temp = temp.next;
//            System.out.print(", " + temp + ", ");
//        }
//        System.out.println(last + " ]");


    }


