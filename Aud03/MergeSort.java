package Aud03;

public class MergeSort {

    int INF = 1000000;

    //Merging two sorted arrays [l, mid], [mid+1, r]
    //The result is a new sorted array
    void merge(int a[], int l, int mid, int r) {
        int numel = r - l + 1;
        int temp[] = new int[100]; //new array for temporary storing of elements
        int i, j, k = 0;

        i = l;
        j = mid + 1;

        while ((i <= mid) && (j <= r)) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (k = 0; k < numel; k++) {
            a[l + k] = temp[k];
//            System.out.println(temp[k]);
        }
//        System.out.println();
    }

    void mergesort(int a[], int l, int r) {
        if (l == r) {
            return;
        }

        int mid = (l + r) / 2;
        mergesort(a, l, mid);
        mergesort(a, mid + 1, r);
        merge(a, l, mid, r);
    }


    public static void main(String[] args) {
        int i;

        MergeSort dac = new MergeSort();

        int a[] = new int[]{9, 2, 4, 6, 0, 8, 7, 3, 1, 5};

        dac.mergesort(a, 0, 9);

        for (i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();


    }
}
