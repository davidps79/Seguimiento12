package model;

public class Node<E>{

    private E item;
    private Node<E> next;
    private int skipped;
    
    public Node(E e) {
        this.item = e;
        this.next = null;
        this.skipped=0;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

	public void addSkipped() {
		skipped++;
	}
	
	public int getSkipped() {
		return skipped;
	}
	
	@Override
	public String toString() {
		return item.toString();
	}
}
