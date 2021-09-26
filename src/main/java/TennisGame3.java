
public class TennisGame3 implements TennisGame {
    
    private int pointsPlayer2;
    private int pointsplayer1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (pointsplayer1 < 4 && pointsPlayer2 < 4 ) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[pointsplayer1];
            return (pointsplayer1 == pointsPlayer2) ? s + "-All" : s + "-" + p[pointsPlayer2];
        } else {
            if (pointsplayer1 == pointsPlayer2)
                return "Deuce";
            s = pointsplayer1 > pointsPlayer2 ? player1Name : player2Name;
            return ((pointsplayer1 - pointsPlayer2)*(pointsplayer1 - pointsPlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            this.pointsplayer1 += 1;
        else
            this.pointsPlayer2 += 1;
        
    }

}
