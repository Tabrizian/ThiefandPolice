public class Thief extends Actor {

	public Thief(Map map) {
		super('D', map);
	}

	public Direction getDirection(Map map) {
		int min = 10;
		Direction direction = null; // direction in which polices are minimum,
		Position[] neighbs = Neighbor.getNeighb(pos, map);
		// Checking if the in the neighbs there is a Police.
		for (int i = 0; i < neighbs.length; i++) {
			if (neighbs[i] != null)
				if (map.getPos(neighbs[i]) == 'P')
					return Direction.NORTH; // Thief must yield.
		}
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
				if (min == 0)
					break;
			}
		}
		return direction;

	}
}
