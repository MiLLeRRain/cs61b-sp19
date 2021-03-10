import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc1 = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < "persiflage".length(); i++) {
            actual.append(d.removeFirst());
        }
        assertEquals("persiflage", actual.toString());
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("TENET"));
//        assertTrue(palindrome.isPalindrome("dog"));
        assertFalse(palindrome.isPalindrome("cat"));
//        assertFalse(palindrome.isPalindrome("TENET"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", cc1));
        assertTrue(palindrome.isPalindrome("AtB", cc1));
        assertFalse(palindrome.isPalindrome("lol", cc1));
    }
}