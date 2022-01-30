package Lesson4;

public class Functions {
    public static boolean isPrime(Integer number) {

        if (number <= 0) return false;
        if (number <= 3) return true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;

        }
        return true;

    }

    public static boolean isPolindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
       return isPolindrome(word.substring(1, word.length() - 1));

    }
}
