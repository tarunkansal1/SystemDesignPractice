package TicTacToe;

public class Player {
    public String playerId;
    public PlayingPiece playingPiece;

    public Player(String playerId, PlayingPiece playingPiece){
        this.playerId = playerId;
        this.playingPiece = playingPiece;
    }
}
