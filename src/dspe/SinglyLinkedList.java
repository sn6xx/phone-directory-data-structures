package dspe;

public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();

        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else {
            E data = tail.getElement();
            if (size == 1) {
                head = tail = null;
            } else {
                Node temp1 = head;
                Node temp2 = null;
                while (temp1.getNext() != null) {
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }
                temp2.setNext(null);
                tail = temp2;
            }
            size--;
            return data;
        }
    }

    public void sortedInsert(E e) {

        Node<E> newNode = new Node<>(e, null);
        Node<E> current = head;
        Node<E> previous = null;

        while (current != null && (((Contact) e)).getName().getFirstName().compareTo(((Contact) current.getElement()).getName().getFirstName()) > 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            newNode.setNext(head);
            head = newNode;
        } else {
            previous.setNext(newNode);
            newNode.setNext(current);
        }

        // If inserted at the end, update tail
        if (newNode.getNext() == null) {
            tail = newNode;
        }

        size++;
    }

    public E remove(E item) {
        if (isEmpty()) {
            return null;
        }
        if (head.element == item) {
            E data = head.getElement();
            head = head.next;

            if (head == null) {
                tail = null;
            }
            size--;
            return data;
        }
        Node<E> current = head;
        while (current.next != null && current.next.element != item) {
            current = current.next;
        }
        if (current.next == null) {
            return null;
        }
        E data = current.next.getElement();

        current.next = current.next.next;

        if (current.next == null) {
            tail = current;
        }
        size--;
        return data;
    }

    //------------project 4 ADT methods-----------
    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            Node<E> current = head;
            while (current != null) {
                System.out.println(current.getElement());
                System.out.println("----------------------------------------------");
                current = current.getNext();
            }
        }
    }

    public SinglyLinkedList<Contact> contactsByGender(char gender) {
        SinglyLinkedList<Contact> cList = new SinglyLinkedList<>();

        Node<E> current = head;
        while (current != null) {
            Contact c = (Contact) current.getElement();
            if (c.getGender() == gender) {
                cList.addLast(c);
            }
            current = current.getNext();
        }
        return cList;
    }

    public Contact searchContactNumber(String number) {
        Node<E> current = head;
        while (current != null) {
            Contact c = (Contact) current.getElement();
            if (c.getNumber().equals(number)) {
                return c;
            }
            current = current.getNext();
        }
        return null;
    }

    public void mergeContactList(SinglyLinkedList<Contact> List2) {
        int s = size();
        for (int i = 0; i < s; i++) {
            Contact c = (Contact) List2.removeFirst();
            addLast((E) c);
            List2.addLast(c);

        }
    }

    public int countContactName(String firstName) {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            Contact c = (Contact) current.getElement();
            if (c.getName().getFirstName().equals(firstName)) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

}
