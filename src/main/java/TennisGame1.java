
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
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder("");
        if (mScore1 == mScore2) return caseDraw(score);
        return  (mScore1 >=4 || mScore2 >=4) ? someoneIsOver4Points(): playersAreUnder4Points(score);


    }

    private String playersAreUnder4Points(StringBuilder score) {
        score.append(getDescriptionScore(mScore1)+"-"+getDescriptionScore(mScore2));
        return score.toString();

    }

    public String getDescriptionScore(int scorePlayer){
        String description = "";
        switch(scorePlayer)
        {
            case 0:
                description = "Love";
                break;
            case 1:
                description = "Fifteen";
                break;
            case 2:
                description = "Thirty";
                break;
            case 3:
               description = "Forty";
                break;
            default:
                break;
        }
        return description;
    }


    private String someoneIsOver4Points() {
        int minusResult = mScore1 - mScore2;

        if (minusResult>0) return playerWinning(player1Name, Math.abs(minusResult));
        return playerWinning(player2Name, Math.abs(minusResult));

    }

    private String playerWinning(String playerName, int minusResult){
        if (minusResult==1) return "Advantage "+ playerName;
        else return "Win for "+playerName;
    }


    private String caseDraw(StringBuilder score) {
        switch (mScore1)
        {
            case 0:
                    score.append("Love-All");
                break;
            case 1:
                    score.append("Fifteen-All");
                break;
            case 2:
                    score.append("Thirty-All");
                break;
            default:
                    score.append("Deuce");
                break;

        }
        return score.toString();
    }
}
