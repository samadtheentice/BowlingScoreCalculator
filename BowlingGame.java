/**
 * <h1>Bowling score Game</h1>
 * <p>The BowlingScoreCalculator calculates the bowling scores
 * from 10 frames given as input and displays the total
 * score to the standard output.
 * </p>
 *
 * @author  Abdul Samad
 * @version 1.0
 * @since   2025-07-29
 */
public class BowlingGame {

    public static void main(String[] args) {

        int[][] bowlingFrame = {
                {1,2},{3,4},{10,0},{10,0},{9,1},{10,0},{2,2},{8,1},{10,0},{5,5,6}
        };

        int totalScore=0;

        //call the method to compute the score
        BowlingScoreCalculator scoreCalculator = new BowlingScoreCalculator();
        totalScore = scoreCalculator.traverseFrame(0,bowlingFrame,0);

        //print the score
        System.out.println("totalScore....."+totalScore);

    }
}

/**
 * <h1>Bowling score frame calculator</h1>
 * <p>The BowlingScoreCalculator calculates the bowling scores
 * from 10 frames given as input and displays the total
 * score to the standard output.
 * </p>
 *
 * @author  Abdul Samad
 * @version 1.0
 * @since   2025-07-29
 */
class BowlingScoreCalculator {

    /**
     * This method is used take the scores from the bowling frame
     * as input, iterate the frame and compute the total score.
     * @param frame frame counter
     * @param bowlingFrame bowling frame input
     * @param total total score
     * @return int This returns total score.
     */
    public int traverseFrame(int frame, int[][] bowlingFrame, int total) {
        if (frame >= 10) {
            return total;
        }
        int frameScore = bowlingFrame[frame][0] + bowlingFrame[frame][1];
        if (frame == 9) {
            total = total + bowlingFrame[9][0] + bowlingFrame[9][1] + bowlingFrame[9][2];
        } else if (bowlingFrame[frame][0] == 10) {
            total = total + frameScore;
            total = strikeWorth(frame + 1, bowlingFrame, total);
        } else if (frameScore == 10) {
            total = total + frameScore;
            total = spareWorth(frame + 1, bowlingFrame, total);
        } else {
            total = total + frameScore;
        }
        //System.out.println("frame.."+frame+"....frame count.. "+frameScore +"...total..."+total);
        return traverseFrame(frame + 1, bowlingFrame, total);
    }

    /**
     * Compute the strike worth.
     * @param currentFrame frame counter
     * @param bowlingFrame bowling frame input
     * @param total total score
     * @return int This returns total score.
     */
    private int strikeWorth(int currentFrame, int[][] bowlingFrame, int total) {
        int frameScore = bowlingFrame[currentFrame][0] + bowlingFrame[currentFrame][1];
        total = total + frameScore;
        if (bowlingFrame[currentFrame][0] == 10) {
            if (bowlingFrame[currentFrame + 1][0] == 10) {
                total = total + frameScore;
            } else {
                total = total + bowlingFrame[currentFrame + 1][0];
            }
        }
        return total;
    }

    /**
     * Compute the spare worth.
     * @param currentFrame frame counter
     * @param bowlingFrame bowling frame input
     * @param total total score
     * @return int This returns total score.
     */
    private int spareWorth(int currentFrame, int[][] bowlingFrame, int total) {
        int frameScore = bowlingFrame[currentFrame][0];
        if (bowlingFrame[currentFrame][0] == 10) {
            total = total + bowlingFrame[currentFrame][0];
        } else {
            total = total + frameScore;
        }
        return total;
    }
}

