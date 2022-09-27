package dataStructures;

public class Stack {
    private int[] s;
    int top;

    public Stack(int size) {
        s = new int[size];
    }

    public boolean stackEmpty() {
        return top == 0;
    }

    public void push(int x) {
        if (top < s.length - 1) {
            top++;
            s[top] = x;
        } else {
            //нужно обработать ошибку
        }
    }

    public int pop() {
        if (stackEmpty()) {
            return -1;
        } else {
            top--;
            return s[top + 1];
        }
    }
}
