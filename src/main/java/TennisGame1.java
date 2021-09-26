
public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            mScore1++;
        else
            mScore2++;
    }

    public String getScore() {
        if (equalScoreValidation() != null) {
            return equalScoreValidation();
        }
        if (!differentScoreValidation().isEmpty()) {
            return differentScoreValidation();
        }

        return setPoint("");
    }

    private String equalScoreValidation() {

        if (mScore1 == mScore2) {
            return equalScore(mScore1);
        }
        return null;
    }

    private String differentScoreValidation() {
        String score = "";
        if (mScore1 >= 4 || mScore2 >= 4) {
            score = differentScore(mScore1, mScore2);
        }
        return score;
    }

    private String differentScore(int mScore1, int mScore2) {
        int minusResult = mScore1 - mScore2;
        switch (minusResult) {
            case 1:
            case -1:
                return playerAdventage(minusResult);
            default:
                return playerWin(minusResult);
        }


    }

    private String playerWin(int minusResult) {
        if (minusResult >= 2) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;


    }

    private String playerAdventage(int minusResult) {
        switch (minusResult) {
            case -1:
                return "Advantage " + player2Name;
            default:
                return "Advantage " + player1Name;
        }
    }

    private String equalScore(int mScore1) {
        switch (mScore1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String setPoint(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = mScore1;
            else {
                score += "-";
                tempScore = mScore2;
            }
            score += gameScore(tempScore);

        }
        return score;
    }

    private String gameScore(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";

        }

    }
}
