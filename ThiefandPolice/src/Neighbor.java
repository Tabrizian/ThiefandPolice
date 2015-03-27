
public class Neighbor {
	public static Position[] getNeighb(Position pos,Map map){
		Position[] neighb = new Position[8];
		for (int i = 0; i < neighb.length; i++) {
			neighb[i] = new Position();
		}
		for (int i = 0; i < neighb.length; i++) {
			try {
				neighb[i] = pos.getNextPos(Direction.values()[i],map);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
			}
		}
		return neighb;
	}
//	public static Position[] getSecondNeighb(){
//		
//	}
}
