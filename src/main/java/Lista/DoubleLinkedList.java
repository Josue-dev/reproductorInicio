/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * @author Josue
 */
public interface DoubleLinkedList <E>{
    
    
    public void addFirst(E elemento);
    public void addLast(E elemento);
    public void add(E elemento, int index);
    public void removeFirst();
    public void removeLast();
    public void remove(int index);
    public boolean isEmpty();
    public int size();
    public E getFirst();
    public E getLast();
    public E get(int index);
    public boolean contains(E elemento);
    
}
