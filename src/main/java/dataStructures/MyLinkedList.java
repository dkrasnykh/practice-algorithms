package dataStructures;

public class MyLinkedList {
    int key;
    MyLinkedList head;
    MyLinkedList prev;
    MyLinkedList next;
    /*
    public MyLinkedList(int key) {
        this.key = key;
        this.head = this;
    }

    public MyLinkedList(){}

    public MyLinkedList search(int k) {
        MyLinkedList x = this.head;
        while (x != null && x.key != k) {
            x = x.next;
        }
        return x;
    }
    */
    public void insert(MyLinkedList x) {
        x.next = this.head;
        if (this.head != null) {
            this.head.prev = x;
        }
        this.head = x;
        x.prev = null;
    }

    public void delete(MyLinkedList x) {
        if (x.prev != null) {
            x.prev.next = x.next;
        } else {
            x.head = x.next;
        }
        if (x.next != null) {
            x.next.prev = x.prev;
        }
    }
}
