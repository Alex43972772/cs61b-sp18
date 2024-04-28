import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOneTrue() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('r', 's'));
        assertTrue(offByOne.equalChars('s', 't'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('%', '&'));
    }
    @Test
    public void testOffByOneFalse() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('A', 'A'));
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('c', 'a'));
        assertFalse(offByOne.equalChars('B', 'b'));
        assertFalse(offByOne.equalChars('B', ' '));
        assertFalse(offByOne.equalChars(' ', 'b'));
        assertFalse(offByOne.equalChars('&', '&'));
        assertFalse(offByOne.equalChars('&', '3'));
    }
}
