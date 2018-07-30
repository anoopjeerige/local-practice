class InsertionSort {
	public static int[] insertionSort(int[] nums) {
		int i = 1;
		while (i < nums.length) {
			int x = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > x) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = x;
			i++;
		}
		return nums;
	}

	/*
	* LeetCode 35. Search Insert Position
	*/
	public static int searchInsert(int[] nums, int target) {
		int i = 1;
		int j = 0;
		while (i < nums.length) {
			j = i;
			if (j >= 0 && nums[j] >	 target) {
				j--;
				break;
			}
			i++;
		}
		if (target > nums[j]) {
			return j + 1;
		}
		return j;
	}

	public static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			System.out.print(" ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] test = {2, 3, 1, 5, 4};
		printArray(insertionSort(test));
		System.out.println(searchInsert(test, 7));
	}
}