import java.util.*;

public class DynamicArray {

	public static void main(String[] args) {

		// Initialize
		List<Integer> a0 = new ArrayList<>();
		List<Integer> a1;

		// Cast array to vector
		Integer[] a = {1, 2, 3};
		a1 = new ArrayList<>(Arrays.asList(a));

		// Copy
		List<Integer> a2 = a1;
		List<Integer> a3 = new ArrayList<>(a1);

		// Length
		System.out.println("Length: " + a3.size());

		// Access
		System.out.println("Access 1 index: " + a3.get(1));

		// Iterate
		System.out.println("Ver 1: ");
		for (int i = 0; i < a3.size(); i++) {
			System.out.println(a3.get(i));
		}
		System.out.println("------------");
		System.out.println("Ver 2: ");
		for (int item: a3) {
			System.out.println(item);
		}
		System.out.println("------------");
		System.out.println("Ver 3: ");
		for (Iterator<?> it = a3.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		System.out.println("------------");
		// Modify
		System.out.println("Original 1: " + a1.get(1) + " Reference: " + a2.get(1) + " Actual copy: " + a3.get(1));
		a1.set(1, 5);
		//a2.set(1, 6);
		//a3.set(1, 7);
		System.out.println("Original 1: " + a1.get(1) + " Reference: " + a2.get(1) + " Actual copy: " + a3.get(1));
		System.out.println("------------");
		// Sort
		Collections.sort(a1);
		for (Iterator<Integer> it = a1.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		System.out.println("------------");

		// Add at end
		a1.add(6);
		a1.add(1, 7);
		for (int item: a1) {
			System.out.println(item);
		}
		System.out.println("------------");
		// Delete at end
		a2.remove(a1.size() - 1);
		for (int item: a1) {
			System.out.println(item);
		}
	}
}