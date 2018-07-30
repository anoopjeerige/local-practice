public class IntroString {

	public static void main(String[] args) {

		// String is an array of unicode characters
		String s1 = "Hello";
		String s2 = s1;
		String s3 = new String(s1);

		// String comparison
		System.out.println("Using == (compares objects)");
		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s1 == s3 : " + (s1 == s3));

		System.out.println("Using equals");
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("s1.equals(s3): " + s1.equals(s3));

		//Immutable
		//s1[5] = "g"; #error
		System.out.println(s1);

		// For mutable strings charArray
		char[] cArray = s1.toCharArray();

		for (int i = 0; i < cArray.length; i++) {
			System.out.println(cArray[i]);
		}

		// For frequent appends use StringBuilder

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append("Doom!");
		}

		System.out.println(sb.toString());
	}
}