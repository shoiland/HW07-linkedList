import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    //private T content;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void addAtIndex(T data, int index){
        Node<T> newNode = new Node(data, null);
        Node<T> current = this.head;
        if (index < 0 || index > this.size){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null){
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        this.size++;
        if (index == 0){
            this.head = newNode;
            newNode.next = current;
            return;
        }
        int counter = 1;
        while ((counter) != index){
            counter++;
            current = current.next;
        }

        Node<T> temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    public T getAtIndex(int index){
        if (index < 0 || index > this.size - 1){
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
            current = current.next;
        }
        throw new NoSuchElementException("The data is not present in the list.");
    }

    public void clear(){
        this.head = null;
    }

    public boolean isEmpty(){
        return this.getHead() == null;
    }

    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.addAtIndex("Scott", 0);
        names.addAtIndex("Dad", 0);
        names.addAtIndex("Mom", 0);
        names.addAtIndex("Janelle", 0);
        names.addAtIndex("Kayla", 0);
        names.addAtIndex("Jude", 2);
        String data = names.getAtIndex(4);
        String removeData = names.removeAtIndex(3);
        System.out.println(removeData);
        String removedItem = names.remove("Dad");
        System.out.println("This is what I found in my search:" + removedItem);


    }
}

//Todo: Failed: Got a null next in a Node which was not the last node.

//Todo: addAtIndex_test_fields Failed: null

//Todo: Failed: Expected NoSuchElementException removing data-100 in what should be an empty list but got NullPointerException

//Todo: Running: remove_test_correct_variablesb Failed: Tail should not be null removing element at index 0 in list of size 188

//Todo:  Running: remove_test_correct_index Failed: Got a null next in a Node which was not the last node.

//Todo: Failed: The "data" field has to be private. expected:<[private]> but was:<[]>

//Todo: Need to set the tail

