package Lab7;

import Lab6.Ammunition;

import java.lang.reflect.Array;
import java.util.*;

public class MyList implements List<Ammunition> {

    private int size;
    private Object[] data;
    private Ammunition[] ammunitions;


    public MyList(){
        data = new Object[15];
        size = 0;
    }


    public MyList(Ammunition ammunition){
        data = new Object[15];
        size = 0;
        data [size ++] = ammunition;
    }

    public MyList(Collection<? extends Ammunition>c ){
        data = new  Object[15];
        size = 0;
        this.addAll(c);
    }





    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean contains(Object o) {
       return indexOf(o) >=0;
    }


    @Override
    public Iterator<Ammunition> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Ammunition> {

       private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Ammunition next() {
            if (!hasNext());
            return (Ammunition)data[currentIndex++];
        }




        @Override
        public void remove() {
            MyList.this.remove(currentIndex-1);
            throw new UnsupportedOperationException();

        }

    }



    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Ammunition ammunition) {
        if (size >= data.length)
        addSpace();
        data[size++] = ammunition;
        return true;
    }

    private void addSpace() {
        Object[] ammun = Arrays.copyOf(data, size, data.getClass());
        int length = (int)(1.3 * data.length);
        data = new Object[length];
        System.arraycopy(ammun, 0, data, 0, size);
    }

    @Override
    public boolean remove(Object o) {
        int position = indexOf(o);
        if (position <0)
            return false;
        for (int i = position; i< size; i++){
            data[i] = data[i+1];
        }
        size --;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] ammunition = c.toArray();
        for (int i  =0; i <c.size(); i++){
            if(this.contains(ammunition[i]))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Ammunition> c) {
        boolean isCollectionChanged = false;
        for (Ammunition ammunition : c) {
            isCollectionChanged |= add(ammunition);
        }
        return isCollectionChanged;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Ammunition> c) {
        while(size + c.size() > data.length)
        addSpace();
        if(index < 0)
        index = 0;
        for(int i = size-1; i >= index; i--){
            data[i + c.size()] = data[i];
        }
        Iterator<Ammunition> Iterator = (Iterator<Ammunition>) c.iterator();
        while(Iterator.hasNext()){
            data[index++] = Iterator.next();
            size++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        Iterator<Ammunition> Iterator = (Iterator<Ammunition>) c.iterator();
        while(Iterator.hasNext()) {
            if (this.remove(Iterator.next()))
                result = true;
        }
        return  result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        MyList temp = new MyList(this);
        for (Ammunition current : temp) {
            if (!c.contains(current)) {
                this.remove(current);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void clear() {
    data = new  Object[15];
    size = 0;
    }

    @Override
    public Ammunition get(int index) {
        if(index>=size)
            throw new IndexOutOfBoundsException();
        return (Ammunition) data[index];
    }

    @Override
    public Ammunition set(int index, Ammunition element) {
        if(index >= size)
        throw new IndexOutOfBoundsException();
        Ammunition result = (Ammunition) data[index];
        data[index] = element;
        return result;
    }

    @Override
    public void add(int index, Ammunition element) {
        if(size >= data.length)
        addSpace();
        for(int i = size-1; i >= index; i++){
            data[i] = data[i-1];
        }
        data[index] = element;
    }

    @Override
    public Ammunition remove(int index) {
        Ammunition result = (Ammunition) data[index];
        for(int i = index; i < size; i++){
            data[i] = data[i+1];
        }
        size--;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
            if (data[i]==null)
                return i;
        } else {
            for (int i = 0; i < size; i++)
            if (o.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
            if (data[i]==null)
                return i;
        } else {
            for (int i = size-1; i >= 0; i--)
            if (o.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator<Ammunition> listIterator() {
        return new MyListIterator();
    }
    private class MyListIterator implements ListIterator<Ammunition> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Ammunition next() {
            try {
                if (!hasNext());
            } catch (NullPointerException e) {
                throw new NoSuchElementException();
            }
            return (Ammunition)data[currentIndex++];
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex >0;
        }

        @Override
        public Ammunition previous() {
            if (!hasNext())
                throw new NoSuchElementException();
            return (Ammunition)data[--currentIndex];
        }

        @Override
        public int nextIndex() {
            return currentIndex +1;
        }

        @Override
        public int previousIndex() {
            return currentIndex-1;
        }


        @Override
        public void remove() {
            MyList.this.remove(currentIndex-1);
            throw new UnsupportedOperationException();

        }


        @Override
        public void set(Ammunition ammunition) {
            MyList.this.set(currentIndex, ammunition);

        }

        @Override
        public void add(Ammunition ammunition) {
            MyList.this.add(currentIndex, ammunition);
        }
    }

    @Override
    public ListIterator<Ammunition> listIterator(int index) {
        return null;
    }

    @Override
    public List<Ammunition> subList(int fromIndex, int toIndex) {
        List<Ammunition> result = new MyList();
        for(int i = fromIndex; i < toIndex; i++){
            result.add(this.get(i));
        }
        return result;
    }


}




