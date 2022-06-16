public class Pawn extends Item{
	
	public Pawn(Board board, int color, int xLoc, int yLoc){
		super(board, color, xLoc, yLoc);
	}
	
	public boolean canMoveTo(int xPosition, int yPosition){
		if(canMoveGenerics(xPosition,yPosition)){
			return pawnMovement(xPosition, yPosition);
		}
		return false;
	}
	
	
	private boolean pawnMovement(int xPosition, int yPosition){
		int one_step;
		int two_step;
		Item target = chessBoard.pieceAt(xPosition, yPosition);
		
		if (this.getColor() == BLACK){
			one_step = 1;
			two_step = 2;
		}
		else{
			one_step = -1;
			two_step = -2;
		}
		

		if (xPosition - this.getXLocation() == one_step){

			if (yPosition == this.getYLocation() && target == null){
				return true;
			}

			if (Math.abs(this.getYLocation() - yPosition) == 1 && target != null){
				return true;
			}
		}

		else if (!hasMoved){
			if (xPosition - this.getXLocation() == two_step){
				if (yPosition == this.getYLocation() && target == null){
					return true;
				}
			}
		}

		return false;
	}
}