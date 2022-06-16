public class Bishop extends Item{
	public Bishop(Board board, int color, int xLoc, int yLoc){
		super(board, color, xLoc, yLoc);
	}
	
	public boolean canMoveTo(int xPosition, int yPosition){
		if(canMoveGenerics(xPosition,yPosition)){
			return bishopMovement(xPosition, yPosition);
		}
		return false;
	}
	

	private boolean bishopMovement(int xPosition, int yPosition){
		return isMovingDiagonal(xPosition, yPosition);
	}
}