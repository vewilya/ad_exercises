package ch.hslu.ad.sw01.Palindrome;

public class Palindrome {

    public Palindrome() {}

    public boolean isPalindrome(final int number) {
        String word = Integer.toString(number);
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    public int getNumberOfPossiblePalindromes(int n) {
        if (n == 0)
            return (int) (9 * Math.pow(10, 0));
        else
            return (int) (9 * Math.pow(10, Math.ceil(((float) n - 2) / 2)));
    }

    public int findNextPalindrome(int number) {
        int next = number;

        while (!isPalindrome(next)) {
            next++;
        }
        return next;
    }

}
