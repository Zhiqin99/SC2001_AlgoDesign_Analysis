class Knapsack{

    private static int max(int i, int j){ 
        return (i > j) ? i : j; 
    } 

    static int getKnapsack(int C, int n, int[] w, int[] p){
        int profit[] = new int[C + 1]; 
          
        for(int i = 0; i <= C; i++){ 
            for(int j = 0; j < n; j++){ 
                if(w[j] <= i){ 
                    profit[i] = max(profit[i], profit[i - w[j]] + p[j]); 
                } 
            } 
        } 
        printarr(profit);
        return profit[C]; 
    }

    static void printarr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "  ");
        }System.out.println("");
    }

    public static void main(String args[]){
        int C = 14;
        int w1[] = {4, 6, 8};
        int p1[] = {7, 6, 9};
        int w2[] = {5, 6, 8};
        int p2[] = {7, 6, 9};
        int n = w1.length;
        int res1 = getKnapsack(C, n, w1, p1);
        System.out.println("P("+C+"): "+res1);

        int res2 = getKnapsack(C, n, w2, p2);
        System.out.println("P("+C+"): "+res2);
    }

}