
public class Event {
	private boolean isPolice;
	private int number;
	private Direction direction;

	public Event(boolean isPolice, int number, Direction direction) {
		this.isPolice = isPolice;
		this.number = number;
		this.direction = direction;
	}
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public boolean isPolice() {
		return isPolice;
	}
	public void setPolice(boolean isPolice) {
		this.isPolice = isPolice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
