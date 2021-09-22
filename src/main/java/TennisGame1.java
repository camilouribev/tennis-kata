
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
        int tempScore=0;
        if (mScore1 == mScore2)
        {
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
        }

        else if (mScore1 >=4 || mScore2 >=4)
        {
            int minusResult = mScore1 - mScore2;
            if (minusResult==1) score.append("Advantage "+ player1Name);
            else if (minusResult ==-1) score.append("Advantage "+ player2Name);
            else if (minusResult>=2) score.append("Win for "+player1Name);
            else score.append("Win for "+player2Name);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = mScore1;
                else { score.append("-"); tempScore = mScore2;}
                switch(tempScore)
                {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }
}
