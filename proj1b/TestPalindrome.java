import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /* Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testIsPalindromeCornerCases() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("A"));
    }
    @Test
    public void testIsPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("aaa"));
        assertTrue(palindrome.isPalindrome("aaaa"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("sunus"));
        assertTrue(palindrome.isPalindrome("abcdefghijklmnopqrstuvwxyzAzyxwvutsrqponmlkjihgfedcba"));
        assertTrue(palindrome.isPalindrome("AbcbA"));
    }
    @Test
    public void testIsPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("aA"));
        assertFalse(palindrome.isPalindrome("ba"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("aB"));
        assertFalse(palindrome.isPalindrome("Ba"));
        assertFalse(palindrome.isPalindrome("abcdefgfedcaa"));
        assertFalse(palindrome.isPalindrome("abccbc"));
        assertFalse(palindrome.isPalindrome("abAaba"));
        assertFalse(palindrome.isPalindrome("aba."));
    }
    CharacterComparator cc = new OffByOne();
    @Test
    public void testIsPalindromeTrue2() {
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("A", cc));
        assertTrue(palindrome.isPalindrome("aab", cc));
        assertTrue(palindrome.isPalindrome("baba", cc));
        assertTrue(palindrome.isPalindrome("rbcedas", cc));
        assertTrue(palindrome.isPalindrome("nopm", cc));
        assertTrue(palindrome.isPalindrome("rvnus", cc));
        assertTrue(palindrome.isPalindrome("AccbB", cc));
    }
    @Test
    public void testIsPalindromeFalse2() {
        assertFalse(palindrome.isPalindrome("aa", cc));
        assertFalse(palindrome.isPalindrome("aA", cc));
        assertFalse(palindrome.isPalindrome("bad", cc));
        assertFalse(palindrome.isPalindrome("Aa", cc));
        assertFalse(palindrome.isPalindrome("aB", cc));
        assertFalse(palindrome.isPalindrome("Ba", cc));
        assertFalse(palindrome.isPalindrome("abcdefgfedcaa", cc));
        assertFalse(palindrome.isPalindrome("brvnusb", cc));
        assertFalse(palindrome.isPalindrome("abAaba", cc));
        assertFalse(palindrome.isPalindrome("aba.", cc));
    }
}
