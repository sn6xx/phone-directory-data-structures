package dspe;

public class LLstack<E> {

    private Node<E> top;
    private int size;

    public LLstack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.getElement();
    }

    public void push(E elem) {
        Node<E> v = new Node<E>(elem, top);
        top = v;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

    //--------project four ADT methods.
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            LLstack<E> tempStack = new LLstack<>();
            while (!isEmpty()) {
                E ele = pop();
                System.out.println(ele);
                System.out.println("----------------------------------------------");
                tempStack.push(ele);
            }
            while (!tempStack.isEmpty()) {
                push(tempStack.pop());
            }
        }
    }

    public boolean didSearch(String number) {
        boolean found = false;
        LLstack<E> tempStack = new LLstack<>();
        while (!isEmpty()) {
            Contact c = (Contact) pop();
            if (c.getNumber().equals(number)) {
                found = true;
            }
            tempStack.push((E) c);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        return found;
    }

    public int countSearch(String number) {
        int count = 0;
        LLstack<E> tempStack = new LLstack<>();
        while (!isEmpty()) {
            Contact c = (Contact) pop();
            if (c.getNumber().equals(number)) {
                count++;
            }
            tempStack.push((E) c);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        return count;
    }

    public void mostRecentSearch() {
        if (isEmpty()) {
            System.out.println("Search history is empty.");
        } else {
            System.out.println("Latest Search: ");
            System.out.println(top());
        }
    }

    public void deleteAllSearchHistory() {
        while (!isEmpty()) {
            pop();
        }
        System.out.println("search deleted.");
    }

}
