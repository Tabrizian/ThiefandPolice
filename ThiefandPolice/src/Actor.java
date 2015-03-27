import java.util.Random;

public class Actor {
	protected Position pos;

	public Actor(char type, Map map) {
		while (true) {
			Random rnd = new Random();
			int xPos = rnd.nextInt(map.getWidth());
			int yPos = rnd.nextInt(map.getHeight());
			if (map.getMap()[yPos][xPos] == '-') {
				map.getMap()[yPos][xPos] = type;
				pos = new Position(xPos,yPos);
				break;
			}
		}
	}

	public Event move(Direction direction,int number) {
		Event event = new Event(true, number, direction);
		return event;
	}
	
}
