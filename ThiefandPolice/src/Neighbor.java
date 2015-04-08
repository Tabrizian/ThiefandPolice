public class Neighbor {
	public static Position[] getNeighb(Position pos, Map map) {
		Position[] neighb = new Position[8];
		for (int i = 0; i < neighb.length; i++) {
			try {
				neighb[i] = pos.getNextPos(Direction.values()[i], map);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return neighb;
	}

	public static Position[] getSecondNeighb(Position[] neighb, Map map) {
		Position[] secondNeighb = new Position[16];
		for (int i = 0; i < neighb.length; i++) {
			if (neighb[i] != null) {
				try {
					secondNeighb[2 * i] = neighb[i].getNextPos(
							Direction.values()[i], map);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				try {
					secondNeighb[2 * i + 1] = neighb[i].getNextPos(
							Direction.values()[i + 1], map);
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		return secondNeighb;
	}
}
