/**
 * MinHeap
 */
public class MinHeap {
    // this whole file is a WIP pls dont touch :)
    public static void heapify(int[] arr, int root ){
        /*
         * if H is not leaf
            heapify left subtree
            heapify right subtree
            k = root of H
            fix heap
         */
        int k;
        for(int i = 0; i < arr.length; i++){
            int j = i+1;
            if(2*j > arr.length){
                heapify(arr, 2*j);
                heapify(arr, 2*j+1);
                k = j;
                heapSort(arr, k);
            }
        }
    }

    public static void heapSort(){
        int max;
        for(int i = arr.length-1; i > 0; i++){
            max = arr[0];
            arr = deleteIndex(arr, 0);
            arr[i] = max;
        }
    }

    public static int getMax(int[] arr){
        return arr[0];
    }
    
    public static void fixHeap(int[] arr, int k, int H){
        if(2*j > arr.length){
            int parent = Math.floor(H/2);
            arr[parent] = k;
        }
        else{
            int left = 2*H;
            int right = 2*H + 1;
        }
    }

    public static void deleteMax(int[] arr){
        int k = arr[arr.length-1];
        int[] res = new int[arr.length-1];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        fixHeap(res, k, 1);
    }
    
}