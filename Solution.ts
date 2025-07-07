
function getHint(secret: string, guess: string): string {
    const NUMBER_OF_DIGITS = 10;
    const ASCII_ZERO = 48;
    let numberOfBulls = 0;
    let numberOfCows = 0;

    const nonBullFrequencyInSecret = new Array(NUMBER_OF_DIGITS).fill(0);
    const nonBullFrequencyInGuess = new Array(NUMBER_OF_DIGITS).fill(0);

    for (let i = 0; i < secret.length; ++i) {
        if (secret.charAt(i) === guess.charAt(i)) {
            ++numberOfBulls;
            continue;
        }
        ++nonBullFrequencyInSecret[secret.codePointAt(i) - ASCII_ZERO];
        ++nonBullFrequencyInGuess[guess.codePointAt(i) - ASCII_ZERO];
    }

    for (let digit = 0; digit < NUMBER_OF_DIGITS; ++digit) {
        numberOfCows += Math.min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit]);
    }

    return numberOfBulls + "A" + numberOfCows + "B";
};
