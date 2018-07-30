import java.util.*;

public class TwoDArray {

	public static void printArray(int[][] x) {
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; x[i] != null && j < x[i].length; j++){
					System.out.print(x[i][j] + " ");
				}
				System.out.println();
			}
		}

	public static ArrayList<ArrayList<Integer>> initDynamicArray(int x, int y) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < x; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < y; j++) {
				temp.add(j);
			}
			result.add(temp);
		}
		return result;
	}

	public static void printDynamicArray(ArrayList<ArrayList<Integer>> test) {
		for (List<Integer> items : test) {
			for (int item: items) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}	

	public static void main(String[] args) {
		int[][] a = new int[2][3];
		printArray(a);

		ArrayList<ArrayList<Integer>> b = initDynamicArray(2,2);
		printDynamicArray(b);

	}
}