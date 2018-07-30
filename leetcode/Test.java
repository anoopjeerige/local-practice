import java.io.*;

public class Test {

	/*
	* Convert String input into integer array
	*/
	public static int[] stringToIntegerArray(String input) {
		// Trim whitespaces
		input = input.trim();
		// Remove the first and last square brackets of the array representation
		input = input.substring(1, input.length() - 1);
		// if zero length input return empty int array
		if (input.length() == 0) {
			return new int[0];
		}

		// Split the string, parse each part and add to int array
		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	/*
	* Utility function to print integer array
	*/
	public static void printArray(int[] input) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(" ");
		}
		System.out.println("");
	}

	/*
	* Convert string input into linked list of type ListNode
	*/
	public static ListNode stringToListNode(String input) {
		// Convert string input into number array
		int[] nodeValues = stringToIntegerArray(input);
		// Convert number array to linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	/*
	* Convert linked list of type ListNode to String
	*/
	public static String listNodeToString(ListNode node) {
		
		// Check for null node
		if (node == null) {
			return "[]";
		}

		StringBuffer sb = new StringBuffer();
		
		while (node != null) {
			sb.append(String.valueOf(node.val));
			sb.append(", ");
			node = node.next;
		}
		
		return "[" + sb.toString().substring(0, sb.length() - 2) + "]";
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// Check if node are null
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }

		// Dummy node of the merged list to return
		ListNode dummyRoot = null;

		// Find first node
		if (l1.val <= l2.val) {
			dummyRoot = l1;
			l1 = l1.next;
		} else {
			dummyRoot = l2;
			l2 = l2.next;
		}

		// Pointer to form new list
		ListNode ptr = dummyRoot;

		// Loop and add middle nodes
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				ptr.next = l1;
				l1 = l1.next;
			} else {
				ptr.next = l2;
				l2 = l2.next;
			}
			ptr = ptr.next; 
		}

		// Add last node
		if(l1 != null ) {
			ptr.next = l1;
		} else {
			ptr.next = l2;
		}
		return dummyRoot;
	}

	/* LeetCode 26. Remove Duplicates from sorted array
	*/
	public static int removeDuplicates(int[] nums) {

		int globalIndex = 0;
		int current = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(current != nums[i]) {
				globalIndex++;
				nums[globalIndex] = nums[i];
				current = nums[i];
			}
		}
		return globalIndex + 1;
	}

	/* LeetCode 27. Remove Element
	*/
	public static int removeElement(int[] nums, int val) {

		int globalIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (val == nums[i]) {
				int j = i + 1;
				while (j < nums.length && nums[j] == val) {
					j++;
				}
				if (j >= nums.length) {
					break;
				}
				nums[globalIndex] = nums[j];
				nums[j] = val;
				globalIndex++;
			} else {
				globalIndex++;
			}
		}
		printArray(nums);
		return globalIndex;

	}

	/* LeetCode 27. Remove Element (better)
	*/
	public static int removeElement_B(int[] nums, int val) {
		int globalIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(val != nums[i]) {
				nums[globalIndex++] = nums[i];
			}
		}
		return globalIndex;
	}

	/* LeetCode 28. Implement strStr()
	*/
	public static int strStr(String haystack, String needle) {
		
		if (needle.length() == 0 || needle.length() > haystack.length()) {
			return 0;
		}

		int found = -1;
		char[] input = haystack.toCharArray();
		char[] seq = needle.toCharArray();
		char first = seq[0];

		for (int i = 0; i < input.length; i++) {
			if (first == input[i]) {
				int l = 0;
				for (int j = 0, k = i; j < seq.length && k < input.length; j++, k++) {
					if (seq[j] != input[k]) {
						break;
					} else {
						l++;
					}
				}
				if (l == seq.length) {
					found = i;
					break;
				}
			}
		}
		return found;
	}

	/** Leet Code contest - 848. Shifting Letters - Initial Solution
	*/ 
	public static String shiftingLetters_old(String S, int[] shifts) {

		char[] letters = S.toCharArray();

		for (int i = 0; i < shifts.length; i++) {
			int shift = shifts[i];
			for (int j = 0; j <= i; j++) {
				int tempAscii = (int)letters[j];
				if (tempAscii + (shift % 26) > 122) {
					tempAscii = ((tempAscii + (shift % 26)) % 122) + 96;
				} else {
					tempAscii += (shift % 26);
				}
				letters[j] = (char) tempAscii;
				System.out.println(String.valueOf(letters));
			}
		}
		return String.valueOf(letters);
	}

	/** Leet Code contest - 848. Shifting Letters - Better Solution
	*/ 
	public static String shiftingLetters(String S, int[] shifts) {
		
		// String builder to hold result
		StringBuilder sb = new StringBuilder(S);
		// Add the shift suffices
		for (int i = shifts.length - 2; i >= 0; i--) {
			shifts[i] = (shifts[i] + shifts[i+1]) % 26;
		}
		// Shift the characters (substracting 'a' auto typecasts to int)
		for (int i = 0; i < S.length(); i++) {
			sb.setCharAt(i, (char)((S.charAt(i) - 'a' + shifts[i]) % 26 + 'a'));
		}
		return sb.toString();
	}


	/*
	* LeetCode 38. Count and Say
	*/
	public static String countAndSay(int n) {
		String result = "1";
		for (int i = 1; i < n; i++) {
			char test = result.charAt(0);
			StringBuffer sb = new StringBuffer();
			int count = 1;
			for (int j = 1; j < result.length(); j++) {
				if (test == result.charAt(j)) {
					count++;
				} else {
					sb.append(count);
					sb.append(test);
					count = 1;
					test = result.charAt(j);
				}
			}
			sb.append(count);
			sb.append(test);
			result = sb.toString();
		}
		return result;
	}

	/*
	* LeetCode - 2. Add Two Numbers - Initial Solution
	*/

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = l1;
		ListNode ptr = l1;
		ListNode last = null;
		int carry = 0;
		while (ptr != null || l2 != null || carry == 1) {

			if (ptr != null) {
				if (l2 != null) {
					// ptr l2 carry so add as usual
					if ((ptr.val + l2.val + carry) >= 10) {
						ptr.val = (ptr.val + l2.val + carry) % 10;
						carry = 1;
						last = ptr;
						ptr = ptr.next;
						l2 = l2.next;
					} else {
						ptr.val = ptr.val + l2.val + carry;
						carry = 0;
						last = ptr;
						ptr = ptr.next;
						l2 = l2.next;
					}
				} else {
					if (carry == 1) {
						// carry and ptr
						if ((ptr.val + carry) >= 10) {
							ptr.val = (ptr.val + carry) % 10;
							carry = 1;
							last = ptr;
							ptr = ptr.next;
						} else {
							ptr.val = ptr.val + carry;
							carry = 0;
							last = ptr;
							ptr = ptr.next;
						}
					} else {
						// ptr
						ptr = ptr.next;
					}
					
				}
			} else {
				if (l2 != null) {
					//System.out.println("a" + l2.val);
					if (carry == 1) {
						// carry and l2
						if ((l2.val + carry) >= 10) {
							ListNode temp = new ListNode((l2.val + carry) % 10);
							//ptr = last;
							last.next = temp;
							last = temp;
							carry = 1;
							l2 = l2.next;
							ptr = temp.next;
						} else {
							ListNode temp = new ListNode(l2.val + carry);
							//System.out.print(temp);
							//ptr = last;
							last.next = temp;
							last = temp;
							carry = 0;
							l2 = l2.next;
							ptr = temp.next;
						}
					} else {
						// l2 only
						//System.out.print("b" + l2.val);
						ListNode temp = new ListNode(l2.val + carry);
						
						//ptr = last;
						
						last.next = temp;
						last = temp;
						carry = 0;
						l2 = l2.next;
						ptr = temp.next;
					}
				} else {
					// carry = 1
					ListNode temp = new ListNode(1);
					last.next = temp;
					carry = 0;
				}
			}
		}
		return dummy;
	}

	public static ListNode addLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, current = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			// Set values for p and q
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = x + y + carry;
			// check for new carry
			carry = sum / 10;
			// append lsb of sum
			current.next = new ListNode(sum % 10);
			current = current.next;
			// move p and q to next values
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			current.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	/*
	* LeetCode - 58. Length of Last Word
	*/
	public static int lengthOfLastWord(String s) {

		if (s.trim().length() == 0) return 0;
		String[] strs = s.split(" ");
		return strs[strs.length - 1].length();
	}

	/*
	* LeetCode 66. Plus One
	*/
	public static int[] plusOne(int[] digits) {

		int len = digits.length;
		int sum = digits[len - 1] + 1;
		int carry = sum / 10;
		digits[len - 1] = sum % 10;
		while (carry != 0 && len >=0) {
			len--;
			sum = digits[len - 1] + carry;
			carry = sum / 10;
			digits[len] = sum % 10;
		}
		return digits;
	}

	public static String addBinary(String a, String b) {
        
        int carry = 0;
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        System.out.println(first + " " + second);
        int n = first.length;
        int m = second.length;
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();
        int x = Character.digit(first[i--], 2);
        int y = Character.digit(second[j--], 2);

        int sum = x + y + carry; 
        carry = sum / 2;
        int result = sum % 2;
        System.out.println(x + " " + y + " " + sum + " " + carry + " " + result);
        
        sb.append(result);
        
        while(i >= 0 || j >= 0) {
        	if (i >= 0) {
        		x = Character.digit(first[i--], 2);
        	} else {
        		x = 0;
        	}

        	if (j >= 0) {
        		y = Character.digit(second[j--], 2);
        	} else {
        		y = 0;
        	}
            sum = x + y + carry;
            carry = sum / 2;
            result = sum % 2;
            System.out.println(x + " " + y + " " + sum + " " + carry + " " + result);
            sb.append(result);
        }

        if (carry == 1) {
        	sb.append(1);
        }

        return sb.reverse().toString();
    }

	/*
	* Main function to test
	*/
	public static void main(String[] args) throws IOException {
		
		// Buffered reade to read the user provided input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;

		// // Read two lines for listnode 1 and listnode 2
		// while ((line = in.readLine()) != null) {
		// 	ListNode l1 = stringToListNode(line);
		// 	line = in.readLine();
		// 	ListNode l2 = stringToListNode(line);

		// 	// solution to merge
		// 	ListNode res = mergeTwoLists(l1, l2);

		// 	System.out.println(listNodeToString(res));
		// }

		// Test LeetCode 26. Remove Duplicates from sorted array
		// line = in.readLine();
		// int[] input = stringToIntegerArray(line);
		// System.out.println(removeDuplicates(input));

		// Test LeetCode 27. Remove Element
		// line = in.readLine();
		// int[] input = stringToIntegerArray(line);
		// int val = Integer.parseInt(in.readLine());
		// System.out.println(removeElement(input, val));

		// // Test LeetCode 28. Implement strStr()
		// String line1 = in.readLine();
		// String line2 = in.readLine();
		// System.out.println(strStr(line1, line2));

		// Test Leet Code contest - 848. Shifting Letters
 		// int[] test = {70, 41, 71, 73, 84};
		// System.out.println(shiftingLetters("xrdof", test));

		// Test LeetCode 38. Count and Say
		//System.out.println(countAndSay(2));

		// Test LeetCode - 2. Add Two Numbers
		// while ((line = in.readLine()) != null) {
		// 	ListNode l1 = stringToListNode(line);
		// 	line = in.readLine();
		// 	ListNode l2 = stringToListNode(line);

		// 	// add two
		// 	ListNode res = addTwoNumbers(l1, l2);

		// 	System.out.println(listNodeToString(res));
		// }

		// Test LeetCode - 58. Length of Last Word
		// while ((line = in.readLine()) != null) {
		// 	System.out.println(lengthOfLastWord(line));
		// }

		// Test LeetCode 66. Plus One
		// while ((line = in.readLine()) != null) {
		// 	int[] test = stringToIntegerArray(line);
		// 	test = plusOne(test);
		// 	printArray(test);
		// }

		// Test 67 Add Binary
		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));
	}
}