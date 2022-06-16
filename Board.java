public class Board {
	private Item[][] chessBoard;

	

	public Board(int xDimension, int yDimension){
		chessBoard = new Item[xDimension][yDimension];
	}

	public boolean isEmptyPosition(int xPosition, int yPosition){
		if (isInBounds(xPosition, yPosition)){
			if (chessBoard[xPosition][yPosition] == null)
				return true;
		}
		return false;
	}
	

	public boolean isInBounds(int xPosition, int yPosition){
		if (xPosition < 8 && xPosition >= 0 &&
				yPosition < 8 && yPosition >= 0)
			return true;
		return false;
	}
	

	public Item pieceAt(int xPosition, int yPosition){
		if (isInBounds(xPosition, yPosition)){
			return chessBoard[xPosition][yPosition];
		}
        else
        return null;	
	}
	

	public void displayBoard(){
			System.out.println("  0 1 2 3 4 5 6 7");
		for (int xBoard = 0; xBoard < 8; xBoard++){
			System.out.print(xBoard+" ");
			for (int yBoard = 0; yBoard < 8; yBoard++){
				if (chessBoard[xBoard][yBoard] == null)
					System.out.print("■ ");
				else{
					if (chessBoard[xBoard][yBoard] instanceof Pawn){
                        if(chessBoard[xBoard][yBoard].getColor()==0)
						System.out.print("♙ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
						System.out.print("♟ ");
                    }
					else if (chessBoard[xBoard][yBoard] instanceof Knight)
                    {
                        if(chessBoard[xBoard][yBoard].getColor()==0)
                        System.out.print("♘ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
                        System.out.print("♞ ");
                    }
					else if (chessBoard[xBoard][yBoard] instanceof Queen)
                    {
                        if(chessBoard[xBoard][yBoard].getColor()==0)
                        System.out.print("♕ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
                        System.out.print("♛ ");
                    }
						
					else if (chessBoard[xBoard][yBoard] instanceof King)
                    {
                        if(chessBoard[xBoard][yBoard].getColor()==0)
                        System.out.print("♔ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
                        System.out.print("♚ ");
                    }
						
					else if (chessBoard[xBoard][yBoard] instanceof Rook)
                    {
                        if(chessBoard[xBoard][yBoard].getColor()==0)
                        System.out.print("♖ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
                        System.out.print("♜ ");
                    }
					
					else if (chessBoard[xBoard][yBoard] instanceof Bishop)
                    {
                        if(chessBoard[xBoard][yBoard].getColor()==0)
                        System.out.print("♗ ");
                        else if(chessBoard[xBoard][yBoard].getColor()==1)
                        System.out.print("♝ ");
                    }
						
					
				}
			}
			System.out.println();
		}
	}
	

	
	public int getXDimension(){
		return chessBoard[0].length;
	}
	
	public int getYDimension(){
		return chessBoard.length;
	}
	
	public Item[][] getChessBoard(){
		return chessBoard;
	}

	public void removeFromBoard(Item removePiece){
		int oldXLocation = removePiece.getXLocation();
		int oldYLocation = removePiece.getYLocation();
		
		chessBoard[oldXLocation][oldYLocation] = null;
	}

	public void placePiece(Item chessPiece, int xPosition, int yPosition){
		if (isInBounds(xPosition, yPosition))
			chessBoard[xPosition][yPosition] = chessPiece;
	}

	public void nullTheBoard()
	{
		for (int xBoard = 0; xBoard < 8; xBoard++){
			for (int yBoard = 0; yBoard < 8; yBoard++){
				chessBoard[xBoard][yBoard]=null;
			}
		}
	}
}