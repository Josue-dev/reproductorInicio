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
public class DoubleLinked<E> implements DoubleLinkedList<E>{

    
    int size;
    Nodo<E> head;
    Nodo<E>tail;
    public DoubleLinked(){
        size=0;
        head=null;
        tail=null;
    }
    @Override
    public void addFirst(E elemento) {
        //añade por la cabecera izquierda
        
        if(this.isEmpty()){
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(null);
            this.head=newnode;
            this.tail=newnode;
            this.size=1;
        }else{
            //añadimos elementos cuando ya hay por la izquierda nodo2
             Nodo<E> newnode = new Nodo<E>();
             newnode.setElemento(elemento);
            newnode.setNext(this.head);
            newnode.setPrev(null);
            this.head.setPrev(newnode);//rescatamos el valor
            this.head=newnode;
            this.size++;
        }
    }

    @Override
    public void addLast(E elemento) {
        //añadir por el final de la lista
        if(this.isEmpty()){
            Nodo<E> newnode = new Nodo<E>();
            newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(null);
            this.head=newnode;
            this.tail=newnode;
            this.size=1;
        }else{
            //añadimos elementos cuando ya hay por la izquierda nodo2
             Nodo<E> newnode = new Nodo<E>();
             newnode.setElemento(elemento);
            newnode.setNext(null);
            newnode.setPrev(this.tail);
            this.tail.setNext(newnode);
            this.tail=newnode;
            this.size++;
        }
    }

    @Override
    public void add(E elemento, int index) {
        //añadimos elementos si nos dan un indice
        if(index==0){//en caso de que sea la posicion 1
            this.addFirst(elemento);
        }else if(index==this.size){//en caso de que sea la ultima posicion
            this.addLast(elemento);
        }else if(index>this.size()){
            System.out.println("El indice incorrecto");
        }else{//el indice se encuentra en medio construimos una nueva lista 
            DoubleLinked<E> nuevaLista = new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    nuevaLista.addLast(elemento);
                    contador++;
                }else{
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }
            }//fin while
            this.head = nuevaLista.head;
            this.tail=nuevaLista.tail;
            this.size = nuevaLista.size;
        }
    }

    @Override
    public void removeFirst() {
        if(this.isEmpty()){
            System.out.println("La lista esta vacia no elementos a eliminar");
        }else{
            this.head=head.getNext();
            this.size--;
        }
    }

    @Override
    public void removeLast() {
         if(this.isEmpty()){
            System.out.println("La lista esta vacia no elementos a eliminar");
        }else{
            this.tail = tail.getPrev();
            this.size--;
        }
    }

    @Override
    public void remove(int index) {
         if(index==0){//en caso de que sea la posicion 1
            this.removeFirst();
        }else if(index==this.size-1){//en caso de que sea la ultima posicion
            this.removeLast();
        }else if(index>=this.size()){
            System.out.println("El indice incorrecto");
        }else{//el indice se encuentra en medio construimos una nueva lista 
            DoubleLinked<E> nuevaLista = new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    this.removeFirst();
                    contador++;
                }else{
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }
            }//fin while
            this.head = nuevaLista.head;
            this.tail=nuevaLista.tail;
            this.size = nuevaLista.size;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.size==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size() {
       return size;
    }

    @Override
    public E getFirst() {
        E elemento;
        if(this.isEmpty()){
            elemento =null;
            System.out.println("La lista esta vacia");
        }else{
            elemento = head.getElemento();
        }
      
        return elemento;
    }

    @Override
    public E getLast() {
         E elemento;
        if(this.isEmpty()){
            elemento =null;
            System.out.println("La lista esta vacia");
        }else{
            elemento = tail.getElemento();
        }
      
        return elemento;
    }

    @Override
    public boolean contains(E elemento) {
        return true;
    }

    @Override
    public E get(int index) {
         E elemento=null;
        if(index==0){//en caso de que sea la posicion 1
            elemento =this.getFirst();
        }else if(index==this.size){//en caso de que sea la ultima posicion
            this.getLast();
        }else if(index>=this.size()){
            System.out.println("El indice incorrecto");
        }else{//el indice se encuentra en medio construimos una nueva lista 
            DoubleLinked<E> nuevaLista = new DoubleLinked<E>();
            int contador=0;
            while(this.isEmpty()==false){
                if(index==contador){
                    elemento = this.getFirst();
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }else{
                    nuevaLista.addLast(this.getFirst());
                    this.removeFirst();
                    contador++;
                }
            }//fin while
            this.head = nuevaLista.head;
            this.tail=nuevaLista.tail;
            this.size = nuevaLista.size;
        }
        return elemento;
    }
    
    
}
