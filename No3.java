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
class LLNode {

    char data;
    LLNode next;

    public LLNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    LLNode head;
    LLNode tail;
    LLNode p; // Pointer tambahan

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.p = null;
    }

    public void addNode(char data) {
        LLNode newNode = new LLNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void setPointerP(char data) {
        LLNode current = head;
        while (current != null) {
            if (current.data == data) {
                p = current;
                break;
            }
            current = current.next;
        }
    }

    public void displayList() {
        LLNode current = head;
        while (current != null) {
            if (current == p) {
                System.out.print("(" + current.data + ") -> ");
            } else {
                System.out.print(current.data + " -> ");
            }
            current = current.next;
        }
        System.out.println("null");
    }
}

public class No3 {

    public static int hitungKemunculan(LLNode head, LLNode tail, char target) {
        if (head == null) {
            return 0;
        }

        if (head.next == null || head == tail) {
            if (head.data == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;
        LLNode current = head;
        while (current != null) {
            if (current.data == target) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public static void hapusNodeKeduaSetelahP(LLNode p) {
        // Tidak ada Node setelah Node kedua dari pointer p/pointer p kosong
        if (p == null || p.next == null || p.next.next == null) {
            return; 
        }

        // Simpan referensi ke Node yang akan dihapus
        LLNode nodeToDelete = p.next.next;

        // Menghubungkan Node sebelum dan setelah Node yang akan dihapus
        p.next.next = nodeToDelete.next;

        // Hapus Node yang ditunjuk oleh pointer p
        nodeToDelete.next = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addNode('a');
        list.addNode('m');
        list.addNode('a');
        list.addNode('o');
        list.addNode('a');
        list.addNode('e');
        list.addNode('z');
        
        list.setPointerP('o');
        
        char target = 'a'; // hitung jumlah kemunculan huruf 'a'
        int count = hitungKemunculan(list.head, list.tail, target);
        System.out.println("Jumlah kemunculan data '" + target + "' di dalam LinkedList: " + count);

        System.out.println("LinkedList sebelum penghapusan:");
        list.displayList();

        hapusNodeKeduaSetelahP(list.p);

        System.out.println("LinkedList setelah penghapusan:");
        list.displayList();

    }
}
