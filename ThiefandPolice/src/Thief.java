public class Thief extends Actor {

	public Thief(Map map) {
		super('D', map);
	}

	public Direction getDirection(Map map) {
		int min = 10;
		Direction direction = null; // direction in which polices are minimum,
		Position[] neighbs = Neighbor.getNeighb(pos, map);
		for (int i = 0; i < neighbs.length; i++) {
			for (Position position : neighbs) {
				int numberOfPolices = 0;
				if (position != null) {
					Position[] neighbsOfNeighbs = Neighbor.getNeighb(position,
							map);
					for (int j = 0; j < neighbsOfNeighbs.length; j++) {
						if (neighbsOfNeighbs[j] != null) {
							if (map.getPos(neighbsOfNeighbs[j]) == 'P')
								numberOfPolices++;
						}
					}
				}
				if (numberOfPolices < min) {
					min = numberOfPolices;
					direction = Direction.values()[i];
				}
			}
		}
		return direction;

	}
}
