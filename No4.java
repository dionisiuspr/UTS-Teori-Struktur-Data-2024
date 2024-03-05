/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTSTeori2024;

/**
 *
 * @author Dionisius
 */
class Node {

    int info;
    Node next;
    Node prev;

    public Node(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int info) {
        Node newNode = new Node(info);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public int sumBefore(int key) {
        int sum = 0;
        Node current = head;
        while (current != null && current.info < key) {
            sum += current.info;
            System.out.print(current.info);
            current = current.next;
            if (current != null && current.info < key) {
                System.out.print(" + ");
            }
        }
        if (sum > 0) {
            System.out.print(" = " + sum);
        } else {
            System.out.print("Tidak ada angka yang akan dijumlahkan.");
        }
        System.out.println();
        return sum;
    }
}

public class No4 {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(2);
        list.insert(5);
        list.insert(9);
        list.insert(12);
        list.insert(15);
        list.insert(20);
        list.insert(23);
        list.insert(25);

        int key1 = 9;
        int key2 = 2;
        int key3 = 15;
        int key4 = 10;

        System.out.println("Hasil sumBefore(" + key1 + "): " + list.sumBefore(key1));
        System.out.println("--------------");
        System.out.println("Hasil sumBefore(" + key2 + "): " + list.sumBefore(key2));
        System.out.println("--------------");
        System.out.println("Hasil sumBefore(" + key3 + "): " + list.sumBefore(key3));
        System.out.println("--------------");
        System.out.println("Hasil sumBefore(" + key4 + "): " + list.sumBefore(key4));
        System.out.println("--------------");
    }
}
