import org.junit.Assert;

public class ArrayDequeTest {

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

    /** Adds a few things to the Array, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {
        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, ad2.isEmpty());

        ad2.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, ad2.isEmpty()) && passed;

        ad2.removeFirst();
        // should be empty
        passed = checkEmpty(true, ad2.isEmpty()) && passed;

        ad2.addLast(10);
        // should not be empty
        passed = checkEmpty(false, ad2.isEmpty()) && passed;

        ad2.removeLast();
        // should be empty
        passed = checkEmpty(true, ad2.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void getTest() {
        System.out.println("Get by index test.");
        ArrayDeque<String> ad3 = new ArrayDeque<>();

        int i = 0;
        while (i<19) {
            if (Math.random()>0.5){
                ad3.addFirst(""+i+Math.random());
            }
            else ad3.addLast(""+i+Math.random());
        i++;
        }
        while (i > 5) {
            if (Math.random()>0.5){
                ad3.removeFirst();
            }
            else ad3.removeLast();
            i--;
        }

        ad3.printDeque();

        ArrayDeque ad4 = new ArrayDeque(ad3);

        ad4.printDeque();

        Assert.assertArrayEquals(ad3.getItems(), ad4.getItems());

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
    }
}
