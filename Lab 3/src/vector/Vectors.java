package vector;

/**
 * Created by LxLiner on 07.10.2015.
 */
public class Vectors {
    public static void doSort(Vector a) {
        for (int i = 0; i < a.getSize() - 1; i++) {
            for (int j = i + 1; j < a.getSize(); j++) {
                if (a.getElement(i) < a.getElement(j)) {
                    double buff = a.getElement(i);
                    a.setElement(i, a.getElement(j));
                    a.setElement(j, buff);
                }
            }
        }
    }
}
