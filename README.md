# Mastermind
 The Mastermind Game written in Java but with 8 colors - playable on the console

 You will always play against the computer and you have to guess the colors it has picked

## History
[Mastermind or Master Mind is a code-breaking game for two players. The modern game with pegs was invented in 1970 by Mordecai Meirowitz, an Israeli postmaster and telecommunications expert. It resembles an earlier pencil and paper game called Bulls and Cows that may date back a century or more.](https://en.wikipedia.org/wiki/Mastermind_(board_game))

## Rules
- Color range of 8 different colors to guess - for easier use they will just be the numbers from 0 to 7
- Computer will generate its combination
- The player has to guess all 4 colors correctly to win
- Previous input of the player is visible for the duration of the round
- Infinite guesses/turns
- Correct color guesses are marked with a **`*`**
- Wrong color guesses are marked with a **`#`**

E.G.:

Computers combination is: Green (1), Green (1), Green (1), Blue (2)

Players guess is: Blue (2), Blue (2), Blue (2), Blue (2)

Output will be: `# # # * `