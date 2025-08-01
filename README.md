# BowlingScoreCalculator
Bowling score calculator


A bowling score calculator in Java, particularly one employing dynamic programming principles, involves calculating the score frame by frame, accounting for strikes and spares. While a purely "dynamic programming" solution might imply memoization or tabulation for optimal substructure, a bowling score calculation is inherently sequential, where the score of a frame depends on future rolls only in the case of strikes and spares.

Here's a conceptual outline for building such a calculator:

Representing the Game:
An array or list can store the scores of each roll. Since a game has 10 frames, and each frame can have up to two rolls (or three in the 10th frame with a strike/spare), an array of size 21 (for regular rolls) or slightly larger (to accommodate bonus balls) can be used.
Alternatively, a Frame object can represent each frame, storing its two (or three) rolls and whether it was a strike or spare.

Calculating Frame Scores:
Iterate through the 10 frames.
For each frame, calculate its base score (sum of the two rolls).

Strikes: If a strike (10 pins on the first ball) occurs, the frame's score is 10 plus the pins knocked down in the next two rolls. This requires looking ahead in the score array.

Spares: If a spare (10 pins across two balls) occurs, the frame's score is 10 plus the pins knocked down in the next single roll. This also requires looking ahead.
Normal Frames: If neither a strike nor a spare, the frame's score is simply the sum of its two rolls.

Handling the 10th Frame:
The 10th frame has special rules for bonus balls if a strike or spare is rolled.
If a strike in the 10th, two extra balls are awarded.
If a spare in the 10th, one extra ball is awarded. These bonus balls are crucial for the final score calculation.

Cumulative Score:
Maintain a running total score, adding each frame's calculated score to it.
