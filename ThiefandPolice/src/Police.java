public class Police extends Actor {
	
	public Police(Map map) {
		super('P', map);
	}

	public Direction getDirection(Map map) {
		Position[] neighb;
		neighb = Neighbor.getNeighb(this.pos, map);
		for (int i = 0; i < neighb.length; i++) {
			if (neighb[i] == null) {
				continue;
			}
			if (map.getPos(neighb[i]) == 'D') {
				return Direction.values()[i];
			}
		}

		Position[] secondNeighb = Neighbor.getSecondNeighb(neighb, map);

		for (int i = 0; i < secondNeighb.length; i++) {
			if (secondNeighb[i] == null) {
				continue;
			}
			if (map.getPos(secondNeighb[i]) == 'D') {
				return Direction.values()[i / 2];
			}
		}

		return null;
	}
}
