class newSorting {
    public void newSorting(int[]A, int size) {
        if (A.length <= size) {
            quicksort(A, 0, A.length-1);
        }
        else {
            int mid = A.length / 2;
            int[] LH = new int[mid]; // creating the left half
            int[] RH = new int[A.length-mid]; //creating right half

            //POPULATE LH and RH with loops
            for (int i = 0; i < mid; i++) {
                LH[i] = A[i];
            }
            for (int j = 0; j < A.length-mid; j++) {
                RH[j] = A[j+mid];
            }

            if (LH.length >= 1) {
                newSorting(LH, size); //sort LH
                newSorting(RH, size); //sort RH
            }
            mergeSortedHalves(A, LH, RH);
        }

    }

    private void quicksort(int[] A, int L, int R) {
        if (L < R) {
            int pivot  = partitioning(A,L,R);
            quicksort(A, L,pivot-1);
            quicksort(A,pivot+1, R);
        }
    }

    private int partitioning(int[] A, int L, int R) {
        int pivot = A[L];
        int less = L + 1;
        int more = R;

        while (less <= more) {
            while (less <= R && A[less] <= pivot)
                less++;
            while (more >= L && A[more] > pivot)
                more--;

            if (less < more) {      //SWAP VALUES
                int temp = A[less];
                A[less] = A[more];
                A[more] = temp;
            }
        }

        int temp = A[L];
        A[L] = A[more];
        A[more] = temp;

        return more;
    }

    private void mergeSortedHalves(int[]A, int[] left, int[] right) {
        int start = 0;
        int L = 0;
        int R = 0;

        while (L < left.length && R < right.length) {
            if (left[L] <= right[R]) {
                A[start] = left[L];
                L++;
            }
            else {
                A[start] = right[R];
                R++;
            }
            start++;
        }

        while (L < left.length) {
            A[start] = left[L];
            L++;
            start++;
        }

        while (R < right.length) {
            A[start] = right[R];
            R++;
            start++;
        }
    }

    private void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}