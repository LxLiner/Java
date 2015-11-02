package vector.container;

import vector.Vector;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by LxLiner on 28.10.2015.
 */
public class VectorCollection implements Collection {

    protected Vector[] vector;

    protected int size;
    protected int maxsize;

    public VectorCollection() {
        vector = new Vector[10];
        size = 0;
        maxsize = 10;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (vector[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return vector;
    }

    @Override
    public boolean add(Object o) {
       if (size < maxsize) {
           size++;
       } else {
           maxsize += 10;
           Vector temp[] = new Vector[maxsize];
           for (int i = 0; i < size; i++) {
               temp[i] = vector[i];
           }
           vector = new Vector[maxsize];
           for (int i = 0; i < size; i++) {
               vector[i] = temp[i];
           }
           size++;
       }

        vector[size] = (Vector) o;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position;
        for (int i = 0; i < size; i++) {
            if (vector[i].equals(0)) {
                position = i;
                for (int j = position; j < size - 1; j++) {
                    vector[j] = vector[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (int i = size; i < c.size(); i++) {
            this.add(c.toArray()[i]);
        }
        return true;
    }

    @Override
    public void clear() {
        vector = new Vector[10];
        size = 0;
        maxsize = 10;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (int i = 0; i < size; i++) {
            boolean mustBeDeleted = true;
            for (int j = 0; j < c.size(); j++) {
                if(vector[i].equals(c.toArray()[j])) {
                    mustBeDeleted = false;
                }
            }
            if (mustBeDeleted) {
                this.remove(vector[i]);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (int i = 0; i < size; i++) {
            boolean mustBeDeleted = false;
            for (int j = 0; j < c.size(); j++) {
                if(vector[i].equals(c.toArray()[j])) {
                    mustBeDeleted = true;
                }
            }
            if (mustBeDeleted) {
                this.remove(vector[i]);
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(int i = 0; i < c.size(); i++) {
            if (!this.contains(c.toArray()[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length > this.size()) {
            for (int i = 0; i < size; i++) {
                a[i] = vector[i];
                return a;
            }
        }
        return toArray();
    }
}
