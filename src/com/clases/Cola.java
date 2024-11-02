package clases;

import java.util.LinkedList;

public class Cola<E> {
    private LinkedList<E> cola = new LinkedList<>();

    public Cola() {
    }

    public Cola(E[] arr){
        for(int i = 0; i < arr.length; i++)
            cola.addLast(arr[i]);
    }

    public E getFront() {
        return cola.getFirst();
    }

    public void enque(E elemento) {
        cola.addLast(elemento);
    }

    public E deque() {
        return cola.removeFirst();
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }
}
