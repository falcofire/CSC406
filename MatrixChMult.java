import java.util.*;

public class MatrixChMult {
	
	Scanner scanner = new Scanner(System.in);
	protected static int[] dims;
	protected static String s = "";
	protected static int[][]matrixMults;
	public MatrixChMult(){

		//Reads in the number of matrices in the chain.
		int numMatrices = Tester.fileScanner.nextInt();
		matrixMults = new int[numMatrices][numMatrices];
		dims = new int[numMatrices+1];
		
		//Read in the dimensions of the matrices and store them in an array.
		for (int i = 0; i < numMatrices+1; i++){
			dims[i] = Tester.fileScanner.nextInt();
		}
		
		//Initialize the main diagonal to zeros.
		for (int i = 0; i < matrixMults.length; i++){
			matrixMults[i][i] = 0;
		}
	
		for (int b = 1; b < matrixMults.length; b++){
			for (int i = 0; i < (matrixMults.length - b); i++){
				int j = i + b;
				//Create a PQueue to store int arrays. Each int array holds a multiplication value and the
				//corresponding k-value.
				Queue<int[][]> queue = new PriorityQueue<int[][]>(kComparator);
				for (int k = i; k < j; k++){
					int first = matrixMults[i][k] + matrixMults[k+1][j] + (dims[i]*dims[k+1]*dims[j+1]);
					int[][] kvalues = new int[1][2];
					kvalues[0][0] = first;
					kvalues[0][1] = k;
					queue.add(kvalues);
				}
				int[][] min = queue.poll();
				matrixMults[i][j] = min[0][0];
				matrixMults[j][i] = min[0][1];
			}
		}
		int firstStop = matrixMults[matrixMults.length-1][0];
		printOrder(0, firstStop);
		printOrder(firstStop+1, matrixMults.length-1);
		Tester.writer.println("Parenthesization of matrices: \n" + s);
	}
		//Comparator method to compare edges.
		private static Comparator<int[][]> kComparator = new Comparator<int[][]>(){
			public int compare(int[][] o1, int[][] o2) {
				return (int) (o1[0][0] - o2[0][0]);
			}
		};
		
		//printOrder() prints out the correct order to multiply the matrices in.
		private static void printOrder(int i, int j){
			
			if (i == j)
				s += "A[" + i + "]";
			else{
				s += " (";
				printOrder(i, matrixMults[j][i]);
				printOrder(matrixMults[j][i]+1, j);
				s += ") ";
			}
			
		}
}
