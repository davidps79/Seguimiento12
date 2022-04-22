package model;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    public Node<E> getFirst() {
        return first;
    }
    
    public Node<E> getLast(){
    	return last;
    }

    public void add(E e) {
        Node<E> node = new Node<E>(e);
        
        if (first==null){
            first=node;
            last=node;
        }else{    
        	last.setNext(node);
        	last = node;
        }
        
        last.setNext(first);
        size++;
    }
    
	/* public void removeElement(E e) {
    	Node<E> node = new Node<E>(e);
    	
    	if (first!=null){
    		Node<E> search = searchElement(node);
            if (search!=null) {
            	Node<E> pre = search.getPrevious();
            	Node<E> pos = search.getNext();
            	if (pre!=null) {
            		// HAY ANTERIOR
            		if (pos!=null) {
            			// HAY ANTERIOR Y SIGUIENTE
                		pre.setNext(pos);
                		pos.setPrevious(pre);
                	}  else {
                		// HAY ANTERIOR PERO NO SIGUIENTE
                		last=pre;
                		pre.setNext(null);
                	}
            	} else {
            		// NO HAY ANTERIOR
            		if (pos!=null) {
            			// NO HAY ANTERIOR PERO SÍ SIGUIENTE
            			first=pos;
            			pos.setPrevious(null);
            		} else {
            			// NO HAY ANTERIOR NI SIGUIENTE
            			last=null;
            			first=null;
            		}
            	}
            	size--;
            }
        
        }
    } */

    public Node<E> get(int index) {
        return get(index, first);
    }

    private Node<E> get(int index, Node<E> temp) {
        if (index == 0) return temp;
        else return get(index - 1, temp.getNext());
    }
    
    public int size() {
        return size;
    }

	public boolean isVoid() {
		return (first==null);
	}

	public void removeFirst() {
		if (size==1) {
			first = null;
			last = null;
		} else {
			first = first.getNext();
			last.setNext(first);
			size--;
		}
	}

	public void moveFirst() {
		first = first.getNext();
		last = last.getNext();;
	}
	
	public String skipFirst() {
		if (first!=null) {
			first.addSkipped();
			String s = "";
			if (first.getSkipped()>=3) {
				s= "Se ha eliminado el turno " + first.getItem().toString() + " por haberlo saltado 3 veces";
				removeFirst();
			} else {
				s = "Se ha saltado el turno " + first.getItem().toString();
				moveFirst();
			}

			return s;
		} else {
			return "No hay turnos";
		}
	}
}