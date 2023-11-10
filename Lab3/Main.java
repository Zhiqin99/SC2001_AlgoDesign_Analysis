class Knapsack{

    static int getKnapsack(int C, int n, int[] w, int[] p){
        int profit[][] = new int[C+1][n+1];

        for(int i = 0; i <= n; i++) 
            profit[0][i] = 0;
        for(int i = 0; i <= C; i++)  
            profit[i][0] = 0;

        for(int i = 1; i <= C; i++){
            for(int j = 1; j <= n; j++){
                profit[i][j] = profit[i][j-1];
                if(w[j-1] < i){
                    if (profit[i][j] < profit[i-w[j-1]][j-1] + p[j-1])
                        profit[i][j] = profit[i-w[j-1]][j-1] + p[j-1];
                }
            }
        }
        printarr(profit);
        return(profit[C][n]);
    }

    static void printarr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }
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