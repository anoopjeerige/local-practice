import java.util.Arrays;

public class ArrayIntro {
	public static void main(String[] args){
		// Initialize
		int[] a0 = {1, 2, 3};
		int[] a1 = new int[3];

		// Length
		System.out.println("Length: " + a1.length);

		// Element
		System.out.println("Element at 1 index: " + a0[1]);

		// Access
		for (int i = 0; i < a0.length; i++) {
			System.out.println(a0[i]);
		}

		for (int item: a0) {
			System.out.println(item);
		}

		// Modify
		System.out.println(a0[1]);
		a0[1] = 5;
		System.out.println(a0[1]);

		// Sort
		Arrays.sort(a0);
		for (int item: a0) {
			System.out.println(item);
		}
	}
}