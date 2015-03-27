public class Police extends Actor {
	private static Position thiefPos;

	public Police(Map map) {
		super('P', map);
	}

	/**
	 * @return the thiefPos
	 */
	public static Position getThiefPos() {
		return thiefPos;
	}

	/**
	 * @param thiefPos
	 *            the thiefPos to set
	 */
	public static void setThiefPos(Position thiefPos) {
		Police.thiefPos = thiefPos;
	}

	public Direction getDirection(Map map) {
		Position[] neighb;
		neighb = Neighbor.getNeighb(this.pos,map);
		for (int i = 0; i < neighb.length; i++) {
			if(neighb[i]==null){
				i=i;
			}
			if(map.getPos(neighb[i])=='D'){
				return Direction.values()[i];
			}
		}
		return null;
	}

}
