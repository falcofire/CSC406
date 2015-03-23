
public class KnapSack {
	
	private static int[][] matrix;
	private static int[][] subsets;
	private static int[] S;
	private static int[] w;
	private static int[] v;
	
	//Constructor accepts two integers representing the number of elements and the maximum weight.
	public KnapSack(int N, int W){
		
		//S stores the elements.
		S = new int[N];
		//w stores the respective element weights.
		w = new int[N];
		//v stores the repective element values.
		v = new int[N];
		
		//Construct the initial arrays that hold objects, weights, and values.
		for (int i = 0 ; i < N; i++){
			S[i] = Tester.fileScanner.nextInt();
		}
		for (int i = 0; i < N; i++){
			w[i] = Tester.fileScanner.nextInt();
		}
		for (int i = 0; i < N; i++){
			v[i] = Tester.fileScanner.nextInt();
		}
		//This structure calculates the maximum values for each possibility for weight and number of elements.
		matrix = new int[N+1][W+1];
		//This structure holds values that indicate which elements where selected for each calculation.
		subsets = new int[N+1][W+1];
		
		for (int j = 0; j < W; j++){
				matrix[0][j] = 0;
		}		
		for (int i = 1; i <= N; i++){		
			for (int j = 0; j <= W; j++){
				if (j - w[i-1] >= 0){
					if (matrix[i-1][j] > (v[i-1] + matrix[i-1][j-w[i-1]])){
							matrix[i][j] = matrix[i-1][j];
							subsets[i][j] = -1;
					}		
					else{
						matrix[i][j] = v[i-1] + matrix[i-1][j-w[i-1]];
						subsets[i][j] = 1;
					}	
				}
				else
					matrix[i][j] = matrix[i-1][j];
			}
			
		}
		Tester.writer.println("\nMaximum knapsack value: " + matrix[N][W]);
		printSubset(N, W);
		
	}
	
	//Method to print out the optimal subset. It accepts two parameters despite the fact the integers
	//are statically available due to the fact that they are modified in the processing of the method.
	private void printSubset(int elements, int weight){
		String s = "Optimal subset: {";
		while (elements > 0){
			if (subsets[elements][weight] == 1){
				if (elements == 1)
					s += elements - 1 + " ";
				else
					s += elements - 1 + ", ";
				elements--;
				weight -= w[elements];
			}
			else
				elements--;
		}
		s += "}";
		Tester.writer.println(s);
	}
	
}
