import org.junit.Assert;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {
		System.out.println("Running add/remove test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		lld1.addLast(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeLast();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void getTest() {
		System.out.println("Get by index test. (by iteration)");
		LinkedListDeque<Double> lld2 = new LinkedListDeque<>();

		lld2.addFirst(2.0);
		lld2.addFirst(1.0);
		lld2.addLast(3.0);
		lld2.addLast(4.0);

		Double[] expected = new Double[]{1.0, 2.0, 3.0, 4.0};

		Double[] actual = new Double[4];
		for (int i = 0; i < 4; i++) {
			actual[i] = lld2.get(i);
		}

		Assert.assertArrayEquals(expected, actual);

	}

	private static void getRecursiveTest() {
		System.out.println("Get by index test. (by recursive)");
		LinkedListDeque<Double> lld2 = new LinkedListDeque<>();

		lld2.addFirst(2.0);
		lld2.addFirst(1.0);
		lld2.addLast(3.0);
		lld2.addLast(4.0);

		double expected = 3.0;
		double actual = lld2.getRecursive(2);

		Assert.assertEquals(expected, actual, 3.0);

	}

	private static void deepCopyTest() {
		System.out.println("Deep copy test.");
		LinkedListDeque<Double> lld2 = new LinkedListDeque<>();

		lld2.addFirst(2.0);
		lld2.addFirst(1.0);
		lld2.addLast(3.0);
		lld2.addLast(4.0);

		LinkedListDeque lld3 = new LinkedListDeque<>(lld2);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		getTest();
		getRecursiveTest();
		deepCopyTest();
	}
}