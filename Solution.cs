
using System;

public class Solution
{
    private static readonly int NUMBER_OF_DIGITS = 10;

    public string GetHint(string secret, string guess)
    {
        int numberOfBulls = 0;
        int numberOfCows = 0;

        int[] nonBullFrequencyInSecret = new int[NUMBER_OF_DIGITS];
        int[] nonBullFrequencyInGuess = new int[NUMBER_OF_DIGITS];

        for (int i = 0; i < secret.Length; ++i)
        {
            if (secret[i] == guess[i])
            {
                ++numberOfBulls;
                continue;
            }
            ++nonBullFrequencyInSecret[secret[i] - '0'];
            ++nonBullFrequencyInGuess[guess[i] - '0'];
        }

        for (int digit = 0; digit < NUMBER_OF_DIGITS; ++digit)
        {
            numberOfCows += Math.Min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit]);
        }

        return numberOfBulls + "A" + numberOfCows + "B";
    }
}
