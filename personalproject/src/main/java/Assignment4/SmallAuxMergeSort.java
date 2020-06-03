package Assignment4;

public class SmallAuxMergeSort {
    private int[] a;
    private int[] aux;
    private int size;

    public SmallAuxMergeSort(int size, int[] a) {
        this.size = size;
        this.a = a;
        this.aux = new int[size / 2];
    }

    public void mergeSort() {
        int midPoint = size / 2;
        if (midPoint - 1 >= 0) System.arraycopy(a, 0, aux, 0, midPoint - 1);
        int j = 0;
        int k = 0;
        int i = midPoint;
        while (k < size) {
            if (i > size) {
                a[k++] = aux[j++];
            } else if (j > midPoint) {
                a[k++] = a[i++];
            } else if (aux[j] > a[i]) {
                a[k++] = a[i++];
            } else if (aux[j] < a[i]) {
                a[k++] = aux[j++];
            }
        }
    }

}



