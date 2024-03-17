package ch.hslu.ad.sw01.Palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void isPalindrome() {
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome(13331));
    }

    @Test
    void isPalindrome2() {
        Palindrome palindrome = new Palindrome();
        assertFalse(palindrome.isPalindrome(13332));
    }

    @Test
    void getNumberOfPossiblePalindromes() {
        Palindrome palindrome = new Palindrome();
        assertEquals(90, palindrome.getNumberOfPossiblePalindromes(3));
    }

    @Test
    void getNumberOfPossiblePalindromes2() {
        Palindrome palindrome = new Palindrome();
        assertEquals(90000, palindrome.getNumberOfPossiblePalindromes(10));
    }

    @Test
    void findNextPalindrome() {
        Palindrome palindrome = new Palindrome();
        assertEquals(13331, palindrome.findNextPalindrome(13322));
    }
}