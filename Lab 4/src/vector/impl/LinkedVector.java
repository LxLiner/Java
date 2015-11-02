package vector.impl;

import vector.IncompatibleVectorSizesException;
import vector.Vector;
import vector.VectorIndexOutOfBoundsException;

import java.io.Serializable;

/**
 * Created by LxLiner on 12.10.2015.
 */

public class LinkedVector implements Vector, Cloneable{

    public class Nod implements Serializable{
        public double element;
        public Nod next;
        public Nod prev;

        public Nod(double element) {
            this.element = element;
        }
    }

    protected Nod head;
    protected int size;

    public LinkedVector() {
        head = null;
        size = 0;
    }

    protected Nod goToElement(int index) {
        Nod result = head;
        int i=0;
        while (i != index) {
            result = result.next;
            i++;
        }
        return result;
    }

    protected void insertElementBefore(Nod current, Nod newNod) {
        newNod.next = current;
        newNod.prev = current.prev;
        current.prev.next = newNod;
        current.prev = newNod;
        size++;
    }

    protected void delElement(Nod current) {
        if (size == 1) {
            head = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            if (current == head) {
                head = current.next;
            }
        }
        size--;

    }

    @Override
    public double getElement(int n) {
        if (size <= n || n < 0) {
            throw new VectorIndexOutOfBoundsException();
        }
        return this.goToElement(n).element;
    }

    @Override
    public void setElement(int n, double value) {
        if (size <= n || n < 0) {
            throw new VectorIndexOutOfBoundsException();
        }
        this.goToElement(n).element = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void fillFromMass(double[] arr) {
        head = null;
        size = 0;

        for (int i = 0; i < arr.length; i++) {
            this.addElement(arr[i]);
        }
    }

    @Override
    public void fillFromVector(Vector a) {
        head = null;
        size = 0;

        for (int i = 0; i < a.getSize(); i++) {
            this.addElement(a.getElement(i));
        }
    }

    @Override
    public void mult(double value) {
        Nod current = head;
        for (int i = 0; i < size; i++) {
            current.element *= value;
            current = current.next;
        }
    }

    @Override
    public void sum(Vector a) throws IncompatibleVectorSizesException {
        if (this.getSize() == a.getSize()) {
            Nod current = head;
            for (int i = 0; i < size; i++) {
                current.element += a.getElement(i);
                current = current.next;
            }
        } else {
            throw new IncompatibleVectorSizesException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            if (this.getSize() == ((Vector) obj).getSize()) {
                for (int i = 0; i < this.getSize(); i++) {
                    if (this.getElement(i) != ((Vector) obj).getElement(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void addElement(double value) {
        Nod newNode = new Nod(value);
        if (size != 0) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        } else {
            head = newNode;
            head.next = head;
            head.prev = head;
        }
        size++;
    }

    @Override
    public void insertElement(double value, int pos) {
        if (size < pos || pos < 0) {
            throw new VectorIndexOutOfBoundsException();
        }
        Nod newNode = new Nod(value);
        Nod posEl = goToElement(pos);
        newNode.prev = posEl.prev;
        newNode.next = posEl;
        posEl.prev.next = newNode;
        posEl.prev = newNode;
        if (pos == 0) {
            head = newNode;
        }
        size++;
    }

    @Override
    public void deleteElement(int pos) {
        if (size <= pos || pos < 0) {
            throw new VectorIndexOutOfBoundsException();
        }

        Nod posEl = goToElement(pos);
        if (pos == 0) {
            head = head.next;
        }
        posEl.prev.next = posEl.next;
        posEl.next.prev = posEl.prev;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (this.getSize() == 0) {
            return new String(str);
        }

        str.append(this.head.element);
        Nod current = head.next;

        for (int i = 1; i < this.getSize(); i++){
            str.append(' ');
            str.append(current.element);
            current = current.next;
        }

        return new String(str);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LinkedVector result = (LinkedVector) super.clone();
        result.fillFromVector(this);
        return result;
    }
}