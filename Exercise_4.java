public class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        //Your code here
        int n1= m-l+1;
        int n2=r-m;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i]= arr[l+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j]= arr[m+j+1];
        }
        int i=0;
        int j=0;
        int k=l;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        //Write your code here
        if(l<r) {
            int mid =l+ (r -l) / 2;

            //Call mergeSort from here
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}