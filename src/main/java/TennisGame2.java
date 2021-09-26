public class TennisGame2 implements TennisGame
{
    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        int diff = pointsPlayer1-pointsPlayer2;
        if (diff == 0) score = getScoreWhenEqualsAndUnder4Points(pointsPlayer1);

        score = ifDifference(score, diff);

        score = ifAdvantage(score, diff);

        score = ifWin(score, diff);

        return score;
    }

    private String ifWin(String score, int diff) {
        if (conditionWin(pointsPlayer1, pointsPlayer2, Math.abs(diff) >= 2))
        {
            score = "Win for "+(diff >0? player1Name:player2Name);
        }
        return score;
    }

    private String ifAdvantage(String score, int diff) {
        if (conditionAdvantage(diff))
        {
            score = "Advantage "+(diff>0? player1Name:player2Name);
        }
        return score;
    }

    private String ifDifference(String score, int diff) {
        if(conditionDifference(diff)) {
            score = getScoreWhenDifference(pointsPlayer1, pointsPlayer2);
        }
        return score;
    }

    private boolean conditionWin(int pointsPlayer1, int pointsPlayer2, boolean b) {
        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && b;
    }

    private boolean conditionAdvantage(int diff) {
        return conditionWin(pointsPlayer1,pointsPlayer2, diff != 0);
    }

    private boolean conditionDifference(int diff) {
        return pointsPlayer1 < 4 && pointsPlayer2 <4 && diff != 0;
    }

    private String getScoreWhenDifference(int pointsPlayer1, int pointsPlayer2) {
        String[] score={"Love","Fifteen","Thirty","Forty"};

        return score[pointsPlayer1]+"-"+score[pointsPlayer2];
    }

    private String getScoreWhenEqualsAndUnder4Points(int index) {
        String[] score={"Love-All","Fifteen-All","Thirty-All","Deuce","Deuce"};
        return score[index];
    }

    public void scorePlayer1(){
        pointsPlayer1++;
    }
    
    public void scorePlayer2(){
        pointsPlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name) )
            scorePlayer1();
        else
            scorePlayer2();
    }
}