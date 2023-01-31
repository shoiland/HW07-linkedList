public class Node<E> {
    private E data;
    Node<E> next;

    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }
    public Node(E data){
        this(data, null);
    }

    //Setters and Getters
    public void setData(E data){
        this.data = data;
    }
    public E getData(){
        return this.data;
    }
    public Node<E> getNext(){
        return this.next;
    }
    public void setNext(Node<E> node){
        this.next = node;
    }
}
