
public class Position {
	private int xPos;
	private int yPos;
	
	public Position(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Position(Position position) {
		this.xPos = position.getX();
		this.yPos = position.getY();
	}
	
	public Position(){ 
//		this = null;
	}
	
	public int getX() {
		return xPos;
	}
	public void setX(int xPos) {
		this.xPos = xPos;
	}
	public void increseX(){
		xPos++;
	}
	public void increseY(){
		yPos++;
	}
	public void decreseX(){
		xPos--;
	}
	public void decreseY(){
		yPos--;
	}
	public int getY() {
		return yPos;
	}
	public void setY(int yPos) {
		this.yPos = yPos;
	}
	public Position getNextPos (Direction direction,Map map) throws ArrayIndexOutOfBoundsException{
		Position pos = new Position(this);
		if(direction == Direction.NORTH){
			pos.increseX();
		}
		else if(direction == Direction.NORTH_EAST){
			pos.increseX();
			pos.increseY();
		}
		else if(direction == Direction.EAST){
			pos.increseX();
		}
		else if(direction == Direction.SOUTH_EAST){
			pos.increseX();
			pos.decreseY();
		}
		else if(direction == Direction.SOUTH){
			pos.decreseY();
		}
		else if(direction == Direction.SOUTH_WEST){
			pos.decreseY();
			pos.decreseX();
		}
		else if(direction == Direction.WEST){
			pos.decreseX();
		}
		else if(direction == Direction.NORTH_WEST){
			pos.decreseX();
			pos.increseY();
		}
		map.getPos(pos);
		return pos;
	}
	
	
}
