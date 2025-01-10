import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoubleLinkedList {
    public static Node InsertAtEnd(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }
    }

    public static void displayFront(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void displayBack(Node tail) {
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
    }

    public static void main(String[] args) {
        Scanner si = new Scanner(System.in);
        int a = si.nextInt();
        Node head = null;
        for (int i = 0; i < a; i++) {
            head = InsertAtEnd(si.nextInt(), head);
        }
        displayFront(head);
        System.out.println();
        Node tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        displayBack(tail);
        si.close();
    }
}
