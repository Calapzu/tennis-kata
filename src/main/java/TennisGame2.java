
public class TennisGame2 implements TennisGame {
    public  int p1Point = 0;
    public  int p2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        if (equals()) {
            score = equalsScore(p1Point);
        } else if (selectionAdvange()) {
            score = advantagePlayers(p1Point, p2Point);
        }else{
            score = moveScore(p1Point) + "-" + moveScore(p2Point);
        }

        return score;
    }

    private String moveScore(int pointPlayer){
        String score[]={"Love","Fifteen", "Thirty", "Forty"};
        return score[pointPlayer];
    }

    private String advantagePlayers(int pointPlayer1, int pointPlayer2) {
        int minusResult = pointPlayer1 - pointPlayer2;
        switch (minusResult) {
            case 1:
                return advantagePlayer(this.player1Name);
            case -1:
                return advantagePlayer(this.player2Name);
            default:
                return playerWin(minusResult);
        }
    }

    private String advantagePlayer(String playerName) {
        return "Advantage " + playerName;
    }

    private String playerWin(int minusResult) {
        return minusResult >= 2 ? "Win for " + this.player1Name : "Win for " + this.player2Name;
    }

    private boolean selectionAdvange() {
        return (p1Point >= 4 || p2Point >= 4);
    }

    private boolean equals() {
        return (p1Point == p2Point);
    }

    private String equalsScore(int pointPlayer) {
        String score[] = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"};
        return score[pointPlayer];
    }

    public void p1Score() {
        p1Point++;
    }

    public void p2Score() {
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            p1Score();
        } else {
            p2Score();
        }

    }
}