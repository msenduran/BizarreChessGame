import java.util.Scanner;

public class Game {
	public static final int BLACK = 0;
	public static final int WHITE = 1;
	
	Scanner userInput = new Scanner(System.in);
	
	private int currentPlayer;
	private Board chessBoard;
	private Item[] blackPieces;
	private Item[] whitePieces;

	private King blackKing;
	private King whiteKing;

    private Pawn blackPawn1;
    private Pawn blackPawn2;
    private Pawn blackPawn3;
    private Pawn blackPawn4;
    private Pawn blackPawn5;
    private Pawn blackPawn6;
    private Pawn blackPawn7;
    private Pawn blackPawn8;
    private Pawn whitePawn1;
    private Pawn whitePawn2;
    private Pawn whitePawn3;
    private Pawn whitePawn4;
    private Pawn whitePawn5;
    private Pawn whitePawn6;
    private Pawn whitePawn7;
    private Pawn whitePawn8;

    private Rook blackRook1;
    private Rook blackRook2;
    private Rook whiteRook1;
    private Rook whiteRook2;

	private Queen whiteQueen;
	private Queen blackQueen;

	private Bishop whiteBishop1;
	private Bishop whiteBishop2;
	private Bishop blackBishop1;
	private Bishop blackBishop2;

	private Knight whiteKnight1;
	private Knight whiteKnight2;
	private Knight blackKnight1;
	private Knight blackKnight2;

	
	public Game(){
		chessBoard = new Board(8,8);
		currentPlayer = WHITE;
		blackPieces = new Item[16];
		whitePieces = new Item[16];
		
		whiteKing = new King(chessBoard, WHITE, 6,4 );
        whitePawn1 = new Pawn(chessBoard,WHITE,7,0);
        whitePawn2 = new Pawn(chessBoard,WHITE,7,1);
        whitePawn3 = new Pawn(chessBoard,WHITE,7,2);
        whitePawn4 = new Pawn(chessBoard,WHITE,7,3);
        whitePawn5 = new Pawn(chessBoard,WHITE,7,4);
        whitePawn6 = new Pawn(chessBoard,WHITE,7,5);
        whitePawn7 = new Pawn(chessBoard,WHITE,7,6);
        whitePawn8 = new Pawn(chessBoard,WHITE,7,7);
        whiteRook1= new Rook (chessBoard,WHITE,6,0);
        whiteRook2= new Rook(chessBoard, WHITE, 6, 7);
		whiteQueen= new Queen(chessBoard,WHITE,6,3);
		whiteBishop1= new Bishop(chessBoard, WHITE, 6, 2);
		whiteBishop2= new Bishop(chessBoard, WHITE, 6, 5);
		whiteKnight1= new Knight(chessBoard, WHITE, 6, 1);
		whiteKnight2= new Knight(chessBoard, WHITE, 6, 6);


		blackKing = new King(chessBoard, BLACK, 1,4 );
        blackPawn1 = new Pawn(chessBoard,BLACK,0,0);
        blackPawn2 = new Pawn(chessBoard,BLACK,0,1);
        blackPawn3 = new Pawn(chessBoard,BLACK,0,2);
        blackPawn4 = new Pawn(chessBoard,BLACK,0,3);
        blackPawn5 = new Pawn(chessBoard,BLACK,0,4);
        blackPawn6 = new Pawn(chessBoard,BLACK,0,5);
        blackPawn7 = new Pawn(chessBoard,BLACK,0,6);
        blackPawn8 = new Pawn(chessBoard,BLACK,0,7);
        blackRook1= new Rook (chessBoard,BLACK,1,0);
        blackRook2= new Rook(chessBoard, BLACK, 1, 7);
		blackQueen= new Queen(chessBoard,BLACK,1,3);
		blackBishop1= new Bishop(chessBoard, BLACK, 1, 2);
		blackBishop2= new Bishop(chessBoard, BLACK, 1, 5);
		blackKnight1=new Knight(chessBoard, BLACK, 1, 1);
		blackKnight2=new Knight(chessBoard, BLACK, 1, 6);
		
		blackPieces [0]= blackKing; blackPieces [9]= blackRook1;
        blackPieces [1]= blackPawn1; blackPieces [10]= blackRook2;
        blackPieces [2]= blackPawn2; blackPieces [11]= blackQueen;
        blackPieces [3]= blackPawn3; blackPieces [12]= blackBishop1;
        blackPieces [4]= blackPawn4; blackPieces [13]= blackBishop2;
        blackPieces [5]= blackPawn5; blackPieces [14]= blackKnight1;
        blackPieces [6]= blackPawn6; blackPieces [15]= blackKnight2;
        blackPieces [7]= blackPawn7; 
        blackPieces [8]= blackPawn8; 

        whitePieces [0]= whiteKing; whitePieces [9]= whiteRook1;
        whitePieces [1]= whitePawn1; whitePieces [10]= whiteRook2;
        whitePieces [2]= whitePawn2; whitePieces [11]= whiteQueen;
        whitePieces [3]= whitePawn3; whitePieces [12]= whiteBishop1;
        whitePieces [4]= whitePawn4; whitePieces [13]= whiteBishop2;
        whitePieces [5]= whitePawn5; whitePieces [14]= whiteKnight1;
        whitePieces [6]= whitePawn6; whitePieces [15]= whiteKnight2;
        whitePieces [7]= whitePawn7; 
        whitePieces [8]= whitePawn8; 
     
	}
	
	
	
	
	
	public void gameLoop(){
		boolean continueGame = true;

		System.out.println("White's Turn");
		while(continueGame){
			chessBoard.displayBoard();
			int count =0;
			if (isGameOver()){
				break;
			}
			
			System.out.print("Which piece to move? Y/-Coordinates:");
			int nextX = userInput.nextInt();
			System.out.print("Which piece to move? X/-Coordinates:");
			int nextY = userInput.nextInt();
			
			Item target = chessBoard.pieceAt(nextX, nextY);
			if (target == null){
				System.out.println("That location is invalid");

			}
			else if (target.getColor() != currentPlayer){
				System.out.println("That is not your piece");

			}
			else {
				System.out.print("Where to move this piece? Y/-loc: ");
				nextX = userInput.nextInt();
				System.out.print("Where to move this piece? X/-loc: ");
				nextY = userInput.nextInt();
				
				if (target.canMoveTo(nextX, nextY)){
					target.moveTo(nextX, nextY);
                    switchPlayerTurn();
					if(count%2==0)
					System.out.println("Black's Turn");
					else 
					System.out.println("White's Turn");
				
					changeBoard();	
				}
				else {
					System.out.println("Cannot move there");
				}
			}
		}
	}
	
	
	public boolean isGameOver(){
		if (isCheckmate(BLACK) || isCheckmate(WHITE)){
			System.out.println("CHECKMATE");
			return true;
		}
		else if (!canMove(currentPlayer)){
			System.out.println("STALEMATE");
			return true;
		}
		return false;
	}
	

	public boolean isCheckmate(int color){	
		if (isKingInCheck(color)){
			if(!canMove(color))
				return true;
		}
		
		return false;
	}
	
	
	public boolean canMove(int player){
		int oldX, oldY;
		Item target;
		Item [] checkPieces;
		
		if (player == BLACK)
			checkPieces = blackPieces;
		else
			checkPieces = whitePieces;
		
		for (int x = 0; x < chessBoard.getXDimension(); x++){
			for (int y = 0; y < chessBoard.getYDimension(); y++){	
			
				for (Item currentPiece : checkPieces){
					if (currentPiece.canMoveTo(x, y)){
					
						target = chessBoard.pieceAt(x, y);
						oldX = currentPiece.getXLocation();
						oldY = currentPiece.getYLocation();
						
						currentPiece.moveTo(x, y);
						
						if (!isKingInCheck(player)){
							currentPiece.moveTo(oldX, oldY);
							if (target != null)
								target.moveTo(x, y);
							return true;
						} else {
							currentPiece.moveTo(oldX, oldY);
							if (target != null)
								target.moveTo(x, y);
						}
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean isKingInCheck(int color){
		boolean result = false;
		
		Item [] originalList;
		King kingInQuestion;
		
		if (color == BLACK){
			originalList = whitePieces;
			kingInQuestion = blackKing;
		} else {
			originalList = blackPieces;
			kingInQuestion = whiteKing;
		}
		
		int xKingLoc = kingInQuestion.getXLocation();
		int yKingLoc = kingInQuestion.getYLocation();
		
		for (Item currentPiece : originalList){
			if (currentPiece.canMoveTo(xKingLoc, yKingLoc)){
				result = true;
			}
		}
		
		return result;
	}
	
	
	
	public void switchPlayerTurn(){
		if (currentPlayer == WHITE)
			currentPlayer = BLACK;
		else currentPlayer = WHITE;
	}
	
	public int getPlayerTurn(){
		return currentPlayer;
	}
	
	public void setPlayer(int player){
		currentPlayer = player;
	}
	
	public King getBlackKing(){
		return blackKing;
	}
	
	public King getWhiteKing(){
		return whiteKing;
	}

	public void changeBoard()
	{
		chessBoard.nullTheBoard();
		for(int i=0;i<blackPieces.length;i++){
		blackPieces[i].setYLocation();
		blackPieces[i].chessBoard.placePiece(blackPieces[i], blackPieces[i].getXLocation(),blackPieces[i].getYLocation());
		}
		for(int i=0;i<whitePieces.length;i++){
		whitePieces[i].setYLocation();
		whitePieces[i].chessBoard.placePiece(whitePieces[i], whitePieces[i].getXLocation(),whitePieces[i].getYLocation());
		}

	}

	
}