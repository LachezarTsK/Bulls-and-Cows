
import kotlin.math.min

class Solution {

    private companion object {
        const val NUMBER_OF_DIGITS = 10
    }

    fun getHint(secret: String, guess: String): String {
        var numberOfBulls = 0
        var numberOfCows = 0

        val nonBullFrequencyInSecret = IntArray(NUMBER_OF_DIGITS)
        val nonBullFrequencyInGuess = IntArray(NUMBER_OF_DIGITS)

        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                ++numberOfBulls
                continue
            }
            ++nonBullFrequencyInSecret[secret[i] - '0']
            ++nonBullFrequencyInGuess[guess[i] - '0']
        }

        for (digit in 0..<NUMBER_OF_DIGITS) {
            numberOfCows += min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit])
        }

        return numberOfBulls.toString() + "A" + numberOfCows + "B"
    }
}
