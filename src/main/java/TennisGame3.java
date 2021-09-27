
public class TennisGame3 implements TennisGame {

    private int pointPlayer2;
    private int pointPlayer1;

    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (joint()) {
            return playerPoints();
        } else {
            if (isDeuce()) {
                return "Deuce";
            }
            return advantageOrWin();
        }
    }

    public String advantageOrWin() {
        String player = "";
        if (operation()) {
            player = "Advantage " + higherPointPlayer();
        } else {
            player = "Win for " + higherPointPlayer();
        }
        return player;
    }

    public boolean operation() {
        return ((pointPlayer1 - pointPlayer2) * (pointPlayer1 - pointPlayer2) == 1);
    }

    public String higherPointPlayer() {
        String player = "";
        if (pointPlayer1 > pointPlayer2) {
            player = player1Name;
        } else {
            player = player2Name;
        }
        return player;
    }

    public String playerPoints() {
        String score = "";

        score = arrayPoints(pointPlayer1);
        return (pointPlayer1 == pointPlayer2) ? score + "-All" : score + "-" + arrayPoints(pointPlayer2);

    }

    public boolean joint(){
        return (playerPointIsEqual() && differentSumOfSix());
    }

    private boolean playerPointIsEqual() {
        return (pointPlayer1 < 4 && pointPlayer2 < 4);
    }

    private boolean differentSumOfSix() {
        return (!(pointPlayer1 + pointPlayer2 == 6));
    }

    private String arrayPoints(int pointPlayer1) {
        String[] point = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return point[pointPlayer1];
    }

    private boolean isDeuce() {
        return pointPlayer1 == pointPlayer2;
    }


    public void wonPoint(String playerName) {
        if (playerName.equals("player1") )
            this.pointPlayer1 += 1;
        else
            this.pointPlayer2 += 1;

    }

}
