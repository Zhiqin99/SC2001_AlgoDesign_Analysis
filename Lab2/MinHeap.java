/**
 * MinHeap
 */
public class MinHeap {
    public static void heapSort(int[] arr){
        int len = arr.length;
        
        heapify(arr, len);

        int end = len-1;
        while(end > 0){
            int temp = arr[end];
            arr[end] = arr[0];
            arr[0] = temp;

            fixHeap(arr, 0, end-1);
            end--;
        }
    }

    public static void heapify(int[] arr, int count){
        int start = (count - 2) / 2;

        while(start >= 0){
            fixHeap(arr, start, count-1);
            start--;
        }
    }

    public static void fixHeap(int[] arr, int start, int end){
        int root = start;
        while((root*2+1) <= end){
            int child = root * 2 + 1;
            
            if(child+1 <= end && arr[child] < arr[child+1]){
                child += 1;
            }

            if(arr[root] < arr[child]){
                int temp = arr[root];
                arr[root] = arr[child];
                arr[child] = temp;
                root = child;
            }
            else{
                return;
            }
        }
    }
    
}