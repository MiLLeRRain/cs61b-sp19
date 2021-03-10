import java.util.Scanner;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        normalFinder(in, minLength, palindrome);
        in = new In("../library-sp19/data/words.txt");
        palindrome = new Palindrome();
        offByOneFinder(in, minLength, palindrome);
        in = new In("../library-sp19/data/words.txt");
        palindrome = new Palindrome();
        OffByNFinder(in, minLength, palindrome);
    }

    public static void normalFinder(In in, int minLength, Palindrome palindrome) {
        System.out.println("Palindrome(Regular): ");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        System.out.println("----------------\nEnd\n----------------");
    }

    public static void offByOneFinder(In in, int minLength, Palindrome palindrome) {
        System.out.println("Palindrome(Off By One): ");
        CharacterComparator cc1 = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc1)) {
                System.out.println(word);
            }
        }

        System.out.println("----------------\nEnd\n----------------");
    }


    private static void OffByNFinder(In in, int minLength, Palindrome palindrome) {
        System.out.println("Palindrome(Off By N): ");
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an Integer number as N: ");
        int n = input.nextInt();
        CharacterComparator ccn = new OffByN(n);

        System.out.printf("Palindrome(Off By %d): \n", n);

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, ccn)) {
                System.out.println(word);
            }
        }

        System.out.println("----------------\nEnd\n----------------");
    }
}