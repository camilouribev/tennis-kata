
public class TennisGame3 implements TennisGame {
    
    private int pointsPlayer2;
    private int pointsPlayer1;
    private String player1Name;
    private String player2Name;


    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        int sumOfPoints = pointsPlayer1+pointsPlayer2;
        int pointDifference = pointsPlayer1-pointsPlayer2;

        if (isRegularDifference(sumOfPoints)) return caseRegularDifference(pointDifference);

        if (pointDifference==0) return "Deuce";

      return caseAdvantageOrWin(pointDifference);

    }

    private String caseRegularDifference(int pointDifference) {
        String score;
        String[] scoreDescriptions = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        score = scoreDescriptions[pointsPlayer1];
        return (pointDifference == 0) ? score + "-All" : score + "-" + scoreDescriptions[pointsPlayer2];
    }

    private boolean isRegularDifference(int sumOfPoints) {
        return sumOfPoints < 6 && (pointsPlayer1<4 && pointsPlayer2<4);
    }

    private String caseAdvantageOrWin(int pointDifference) {
        String name = pointsPlayer1 > pointsPlayer2 ? player1Name : player2Name;
        return (Math.abs(pointDifference)==1) ? "Advantage " + name : "Win for " + name;
    }


    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            pointsPlayer1++;
        else
            pointsPlayer2++;
        
    }

}
