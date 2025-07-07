
#include <array>
#include <string>
using namespace std;

class Solution {

    static const int NUMBER_OF_DIGITS = 10;

public:
    string getHint(const string& secret, const string& guess) const {
        int numberOfBulls = 0;
        int numberOfCows = 0;

        array<int, NUMBER_OF_DIGITS> nonBullFrequencyInSecret{};
        array<int, NUMBER_OF_DIGITS> nonBullFrequencyInGuess{};

        for (int i = 0; i < secret.length(); ++i) {
            if (secret[i] == guess[i]) {
                ++numberOfBulls;
                continue;
            }
            ++nonBullFrequencyInSecret[secret[i] - '0'];
            ++nonBullFrequencyInGuess[guess[i] - '0'];
        }

        for (int digit = 0; digit < NUMBER_OF_DIGITS; ++digit) {
            numberOfCows += min(nonBullFrequencyInSecret[digit], nonBullFrequencyInGuess[digit]);
        }

        return to_string(numberOfBulls) + 'A' + to_string(numberOfCows) + 'B';
    }
};
