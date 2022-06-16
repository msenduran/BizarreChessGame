public class Item  {
	public static final int BLACK = 0;
	public static final int WHITE = 1;
	private int xLocation;
	private int yLocation;
	private int color;
	protected boolean hasMoved;
	protected Board chessBoard;
	
	public Item(Board board, int color){
		this.chessBoard = board;
		this.color = color;
		hasMoved = false;
		xLocation = -1;
		yLocation = -1;
	}
	
	public Item(Board board, int color, int xLoc, int yLoc){
		this.chessBoard = board;
		this.color = color;
		this.hasMoved = false;
		this.xLocation = xLoc;
		this.yLocation = yLoc;
		
		chessBoard.placePiece(this, xLoc, yLoc);
	}
	
	
	public boolean canMoveTo(int xPosition, int yPosition){
		return canMoveGenerics(xPosition, yPosition);
	}
	
	
	protected boolean canMoveGenerics(int xPosition, int yPosition){
		if (chessBoard.isInBounds(xPosition, yPosition)){
			Item location = chessBoard.pieceAt(xPosition, yPosition);
			
			if (location == null) return true;
			if (location.getColor() != this.color) return true; 
		}
		return false;
	}
	

	public void moveTo(int xPosition, int yPosition){	
			if (chessBoard.pieceAt(xLocation, yLocation) == this)
				chessBoard.removeFromBoard(this);
			this.xLocation = xPosition;
			this.yLocation = yPosition;
			
			Item target = chessBoard.pieceAt(xPosition, yPosition);
			if (target != null){
				this.capturePiece(target);
			}
			
			
			chessBoard.placePiece(this, xPosition, yPosition);
			hasMoved = true;
	}
	
	
	public void removePiece() {
		chessBoard.removeFromBoard(this);
		xLocation = -1;
		yLocation = -1;
	}
	
	
	public void capturePiece(Item capturedPiece){
		capturedPiece.removePiece();
	}
	
	
	public boolean onBoard(){
		if (chessBoard.isInBounds(xLocation, yLocation))
			return true;
		return false;
	}
	

	
	public int getXLocation(){
		return xLocation;
	}

	public void setYLocation()
	{
		if(this.getYLocation()>0)
	this.yLocation= this.getYLocation()-1;
		else if(this.getYLocation()==0)
		{
			this.yLocation= this.getYLocation()+7;
		}
	}
	
	public int getYLocation(){
		return yLocation;
	}

	
	public int getColor(){
		return color;
	}
	
	public Board getBoard(){
		return chessBoard;
	}


	protected boolean isMovingStraight(int xPosition, int yPosition) {
		int currX = this.getXLocation();
		int currY = this.getYLocation();
		
		int smallerVal;
		int largerVal;
		
	
		if (currX == xPosition){
			if (currY > yPosition){
				smallerVal = yPosition;
				largerVal = currY;
			}
			else if (yPosition > currY){
				smallerVal = currY;
				largerVal = yPosition;
			}
			else return false;
			
		
			smallerVal++;
			for(; smallerVal < largerVal; smallerVal++){
				if (chessBoard.pieceAt(currX, smallerVal) != null){
					return false;
				}
			}
			return true;
		}
		
		
		if (currY == yPosition){
			if (currX > xPosition){
				smallerVal = xPosition;
				largerVal = currX;
			}
			else if (xPosition > currX){
				smallerVal = currX;
				largerVal = xPosition;
			}
			else return false;
			
	
			smallerVal++;
			for(; smallerVal < largerVal; smallerVal++){
				if (chessBoard.pieceAt(smallerVal, currY) != null){
					return false;
				}
			}
			return true;
		}
		
		return false;
	}


	protected boolean isMovingDiagonal(int xPosition, int yPosition) {
		int xStart = 0;
		int yStart = 0;
		int xFinish = 1;

		

		int xTotal = Math.abs(xPosition - this.getXLocation());
		int yTotal = Math.abs(yPosition - this.getYLocation());
		
		if (xTotal == yTotal){
			if (xPosition < this.getXLocation()){
				xStart = xPosition;
				xFinish = this.getXLocation();
			}
			else if (xPosition > this.getXLocation()){
				xStart = this.getXLocation();
				xFinish = xPosition;
			}
			else
				return false;
			
			if (yPosition < this.getYLocation()){
				yStart = yPosition;

			}
			else if (yPosition > this.getYLocation()){
				yStart = this.getYLocation();

			}
			else
				return false;
			
			xStart++;
			yStart++;
			

			for(;xStart < xFinish; xStart++, yStart++){
				if (chessBoard.pieceAt(xStart, yStart) != null){
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
}