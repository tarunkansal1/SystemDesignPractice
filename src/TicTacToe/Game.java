package TicTacToe;

import javafx.util.Pair;

import java.util.*;

public class Game {
    Deque<Player> playerList;
    Board board;
    Player winner;

    public void initializeGame(){
        PlayingPieceX playingPieceX = new PlayingPieceX();
        Player player1 = new Player("Tarun",playingPieceX);

        PlayingPieceO playingPieceO = new PlayingPieceO();
        Player player2 = new Player("Aman",playingPieceO);

        playerList = new LinkedList<>();

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3);
        //System.out.println("Check player list" + playerList);
    }

    public GameStatus startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = playerList.remove();
            board.printBoard();
            List<Pair<Integer,Integer>>freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            //Read the user input
            System.out.print("Player - " + playerTurn.playerId + "Please enter row,col: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            boolean validMove = board.addPiece(row,col,playerTurn.playingPiece);
            if(!validMove){
                System.out.println("Incorrect position try again");
                playerList.addFirst(playerTurn);
                continue;
            }else{
                playerList.addLast(playerTurn);
            }
            boolean isWinner = checkForWinner(row,col,playerTurn.playingPiece);
            if(isWinner){
                board.printBoard();
                winner=playerTurn;
                return GameStatus.WIN;
            }


        }
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row,int col,PlayingPiece playingPiece){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].pieceType != playingPiece.pieceType) {
                rowMatch = false;
                break;
            }
        }
        // Check column
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col] == null || board.board[i][col].pieceType != playingPiece.pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check Row
        for (int i = 0,j=0; i < board.size; i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != playingPiece.pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Row
        for (int i = 0,j=board.size-1; i < board.size; i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != playingPiece.pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return (rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch);
    }
}
