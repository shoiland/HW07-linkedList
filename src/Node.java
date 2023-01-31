public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }
    public Node(E data){
        this(data, null);
    }

    public void setData(E data){
        this.data = data;
    }
    public E getData(){
        return this.data;
    }
    public void setNode(Node<E> node){
        this.next = node;
    }
    public Node<E> getNode(){
        return this.next;
    }
}
