public class Queen extends Item{
	public Queen(Board board, int color, int xLoc, int yLoc){
		super(board, color, xLoc, yLoc);
	}
	
	public boolean canMoveTo(int xPosition, int yPosition){
		if(canMoveGenerics(xPosition,yPosition)){
			return queenMovement(xPosition, yPosition);
		}
		return false;
	}
	

	private boolean queenMovement(int xPosition, int yPosition){
		if (isMovingStraight(xPosition, yPosition) ||
				isMovingDiagonal(xPosition, yPosition))
				return true;
		return false;
	}
}