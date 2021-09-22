
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
        return  (mScore1 >=4 || mScore2 >=4) ? someoneIsAbove4(score): playersAreUnder4(score);


    }

    private String playersAreUnder4(StringBuilder score) {
        score.append(getDescriptionScore(mScore1)+"-"+getDescriptionScore(mScore2));
        return score.toString();

    }


    public String getDescriptionScore(int scorePlayer){
        String marker="";
        switch(scorePlayer)
        {
            case 0:
                marker = "Love";
                break;
            case 1:
                marker = "Fifteen";
                break;
            case 2:
                marker = "Thirty";
                break;
            case 3:
               marker = "Forty";
                break;
            default:
                break;
        }
        return marker;
    }


    private String someoneIsAbove4(StringBuilder score) {
        int minusResult = mScore1 - mScore2;

        if (minusResult==1) score.append("Advantage "+ player1Name);
        else if (minusResult ==-1) score.append("Advantage "+ player2Name);
        else if (minusResult>=2) score.append("Win for "+player1Name);
        else score.append("Win for "+player2Name);

        return score.toString();
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
