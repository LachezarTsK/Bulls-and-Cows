
import "fmt"

const NUMBER_OF_DIGITS = 10

func getHint(secret string, guess string) string {
    numberOfBulls := 0
    numberOfCows := 0

    nonBullFrequencyInSecret := [NUMBER_OF_DIGITS]int{}
    nonBullFrequencyInGuess := [NUMBER_OF_DIGITS]int{}

    for i := range secret {
        if secret[i] == guess[i] {
            numberOfBulls++
            continue
        }
        nonBullFrequencyInSecret[secret[i] - '0']++
        nonBullFrequencyInGuess[guess[i] - '0']++
    }

    for digit := range NUMBER_OF_DIGITS {
        numberOfCows += min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit])
    }

    return fmt.Sprint(numberOfBulls) + "A" + fmt.Sprint(numberOfCows) + "B"
}
