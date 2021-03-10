public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        if (word.isEmpty()) {
            System.out.println("Empty String entered.");
            return null;
        }
        Deque<Character> toReturn = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            toReturn.addLast(word.charAt(i));
        }
        return toReturn;
    }

    /**
     * Normal Palindrome determination
     */
    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }

    public boolean isPalindromeHelper(Deque<Character> forTest) {
        if (forTest.size()<=1) return true;
        if (!forTest.removeFirst().equals(forTest.removeLast())) return false;
        return isPalindromeHelper(forTest);
    }

    /**
     * OffByOne/OffByN Palindrome determination
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelperByN(wordToDeque(word), cc);
    }

    private boolean isPalindromeHelperByN(Deque<Character> forTest, CharacterComparator cc) {
        if (forTest.size()<=1) return true;
        if (!cc.equalChars(forTest.removeFirst(), forTest.removeLast())) return false;
        return isPalindromeHelperByN(forTest, cc);
    }

}
