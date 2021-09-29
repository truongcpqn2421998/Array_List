import java.util.Arrays;

public class MyList<E> {
    private int size =0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyList() {
        elements =new Object[DEFAULT_CAPACITY];
    }
    public MyList(int DEFAULT_CAPACITY){
        elements=new Object[DEFAULT_CAPACITY];
    }
    public static Object[] copyArray(Object[] array,int size){
        Object[] newArray=new Object[size];
        for (int i = 0; i < array.length; i++) {
                newArray[i]=array[i];
        }
        return newArray;
    }
    private void ensureCapa() {
        int newSize = elements.length +1;
        elements=copyArray(elements,newSize);
    }
    public void add(E element){
        if(size == elements.length){
            ensureCapa();
        }
        elements[size++]=element;
    }
    public void add(int index,E element){
        if(size == elements.length){
            ensureCapa();
        }
        for (int i = size-1,j=size; i >index; i--,j--) {
            elements[j]=elements[i];
        }
        elements[index]=element;
        size++;
    }

    public E remove(int index){
        E temp=(E) elements[index];
        for (int i = index; i <elements.length-1 ; i++) {
            elements[i]=elements[i+1];
        }
        size--;
        return temp;
    }

    public int getSize(){
        return size;
    }

    public MyList<E> clone(){
        return this;
    }
    public boolean contain(E o){
        for (int i = 0; i <size ; i++) {
            if (elements[i]==o){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        int index=-1;
        for (int i = 0; i < size; i++) {
            if(elements[i]==o){
                index=i;
            }
        }
        return index;
    }


    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

    public void clear(){
        while(size>=0){
            remove(0);
        }
    }

}
