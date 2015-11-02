/**
 * Created by LxLiner on 05.10.2015.
 */
public class Sort {
    public static void doSort(Vector a) {
        for (int i = 0; i < a.getVectorLenght() - 1; i++) {
            for (int j = i + 1; j < a.getVectorLenght(); j++) {
                if (a.getVectorN(i) < a.getVectorN(j)) {
                    double buff = a.getVectorN(i);
                    a.setVectorN(i, a.getVectorN(j));
                    a.setVectorN(j, buff);
                }
            }
        }
    }
}
