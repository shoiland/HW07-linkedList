import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    //private T content;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void addToRear(T data){
        Node<T> newNode = new Node(data);
        this.size++;
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node<T> current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void addAtIndex(T data, int index){
        Node<T> newNode = new Node(data, null);
        Node<T> current = this.head;
        int counter = 1;
        while ((counter) != index){
            counter++;
            current = current.next;
        }
        if (index == 0){
            this.head = newNode;
            newNode.next = current;
            return;
        }
        Node<T> temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    public T getAtIndex(int index){
        if (index < 0 || index > this.size){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        Node<T> current = this.getHead();
        int location = 0;
        while (location != index){
            current = current.next;
            location++;
        }
        return current.getData();
    }

    public T removeAtIndex(int index){
        if (index < 0 || index > this.size - 1){
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        Node<T> current = this.getHead();
        if (index == 0){
            this.head = current.next;
            return current.getData();
        }
        int location = 0;
        while ((location + 1) != index){
            current = current.next;
            location++;
        }
        Node<T> toRemove = current.next;
        current.next = current.next.next;
        return toRemove.getData();
    }

    public T remove(T data){
        if (data == null){
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        Node<T> current = this.getHead();
        if (current.getData() == data){
            this.head = current.next;
            return current.getData();
        }
        while (current.next != null){
            if (current.next.getData() == data){
                Node<T> toRemove = current.next;
                current.next = current.next.next;
                return toRemove.getData();
            }
        }
        throw new NoSuchElementException("The data is not present in the list.");
    }

    public void clear(){
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head != null;
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.addToRear("Scott");
        names.addToRear("Dad");
        names.addToRear("Mom");
        names.addToRear("Janelle");
        names.addToRear("Kayla");
        names.addAtIndex("Jude", 2);
        String data = names.getAtIndex(4);
        String removeData = names.removeAtIndex(3);
        System.out.println(removeData);
        String removedItem = names.remove("Dad");
        System.out.println("This is what I found in my search:" + removedItem);


    }
}
