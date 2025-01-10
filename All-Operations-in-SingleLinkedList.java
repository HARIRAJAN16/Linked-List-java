import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Creation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at specified position");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete at specified position");
            System.out.println("7. Search for a node");
            System.out.println("8. Reverse the list");
            System.out.println("9. Display the list");
            System.out.println("10. Display size of the list");
            System.out.println("11. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int val1 = sc.nextInt();
                    head = insertAtBegin(val1, head);
                    System.out.println("Value inserted successfully.");
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    int val2 = sc.nextInt();
                    head = insertAtEnd(val2, head);
                    System.out.println("Value inserted successfully.");
                    break;
                case 3:
                    System.out.print("Enter value to insert: ");
                    int val3 = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    head = insertAtSpecifiedpos(val3, head, pos);
                    break;
                case 4:
                    head = DeleteAtBegin(head);
                    break;
                case 5:
                    head = DeleteAtEnd(head);
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int delPos = sc.nextInt();
                    head = DeleteAtSpecifiedLoc(head, delPos);
                    break;
                case 7:
                    System.out.print("Enter value to search: ");
                    int searchVal = sc.nextInt();
                    SearchNode(searchVal, head);
                    break;
                case 8:
                    head = reverse(head);
                    System.out.println("List reversed.");
                    break;
                case 9:
                    display(head);
                    break;
                case 10:
                    int size = getSize(head);
                    System.out.println("The size of the list is: " + size);
                    break;
                case 11:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Node insertAtBegin(int data, Node head) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node insertAtEnd(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static Node insertAtSpecifiedpos(int data, Node head, int pos) {
        if (pos <= 0) {
            System.out.println("Position must be greater than 0.");
            return head;
        }
        Node newNode = new Node(data);
        if (pos == 1) {
            return insertAtBegin(data, head);
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Invalid position. List size is smaller than position.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Value inserted successfully.");
        }
        return head;
    }

    public static Node DeleteAtBegin(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        System.out.println("Deleted value: " + head.data);
        return head.next;
    }

    public static Node DeleteAtEnd(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        if (head.next == null) {
            System.out.println("Deleted value: " + head.data);
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println("Deleted value: " + temp.next.data);
        temp.next = null;
        return head;
    }

    public static Node DeleteAtSpecifiedLoc(Node head, int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        if (pos <= 0) {
            System.out.println("Position must be greater than 0.");
            return head;
        }
        if (pos == 1) {
            return DeleteAtBegin(head);
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position.");
        } else {
            System.out.println("Deleted value: " + temp.next.data);
            temp.next = temp.next.next;
        }
        return head;
    }

    public static void SearchNode(int data, Node head) {
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Element not found.");
    }

    public static Node reverse(Node head) {
        if (head == null) {
            System.out.println("List is empty. Cannot reverse.");
            return null;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static int getSize(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
