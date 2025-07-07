
public class Solution {

    private static final int NUMBER_OF_DIGITS = 10;

    public String getHint(String secret, String guess) {
        int numberOfBulls = 0;
        int numberOfCows = 0;

        int[] nonBullFrequencyInSecret = new int[NUMBER_OF_DIGITS];
        int[] nonBullFrequencyInGuess = new int[NUMBER_OF_DIGITS];

        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++numberOfBulls;
                continue;
            }
            ++nonBullFrequencyInSecret[secret.charAt(i) - '0'];
            ++nonBullFrequencyInGuess[guess.charAt(i) - '0'];
        }

        for (int digit = 0; digit < NUMBER_OF_DIGITS; ++digit) {
            numberOfCows += Math.min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit]);
        }

        return numberOfBulls + "A" + numberOfCows + "B";
    }
}
