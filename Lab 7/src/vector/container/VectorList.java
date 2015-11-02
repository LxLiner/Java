package vector.container;

import vector.Vector;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by LxLiner on 28.10.2015.
 */
public class VectorList extends VectorCollection implements List {


    @Override
    public boolean addAll(int index, Collection c) {
        Vector[] temp = new Vector[size];
        for (int i = index; i < size; i++) {
            temp[i] = vector[i];
        }

        this.clear();

        for (int i = 0; i < index; i++) {
            this.add(temp[i]);
        }
        for (int i = 0; i < c.size(); i++) {
            this.add(c.toArray()[i]);
        }
        for (int i = index; i < temp.length; i++) {
            this.add(temp[i]);
        }
        return true;
    }

    @Override
    public Object get(int index) {
        return vector[index];
    }

    @Override
    public Object set(int index, Object element) {
        Vector result = vector[index];
        vector[index] = (Vector) element;

        return result;
    }

    @Override
    public void add(int index, Object element) {
        Vector[] temp = new Vector[size];
        for (int i = index; i < size; i++) {
            temp[i] = vector[i];
        }

        this.clear();

        for (int i = 0; i < index; i++) {
            this.add(temp[i]);
        }
        this.add(element);

        for (int i = index; i < temp.length; i++) {
            this.add(temp[i]);
        }
    }

    @Override
    public Object remove(int index) {
        Vector[] temp = new Vector[size];
        for (int i = index; i < size; i++) {
            temp[i] = vector[i];
        }

        this.clear();

        for (int i = 0; i < index; i++) {
            this.add(temp[i]);
        }
        for (int i = index + 1; i < temp.length; i++) {
            this.add(temp[i]);
        }

        return temp[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (vector[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (vector[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        List result = new VectorList();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(this.get(i));
        }
        return result;
    }
}
