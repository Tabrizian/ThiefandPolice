public class Map {
	private char[][] map;

	public Map(int width, int height) {
		map = new char[height][width];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = '-';
			}
		}
	}

	public Map(Map map) {
		this.map = new char[map.getHeight()][map.getWidth()];
		for (int i = 0; i < map.map.length; i++) {
			for (int j = 0; j < map.map[0].length; j++) {
				this.map[i][j] = map.map[i][j];
			}
		}
	}

	public boolean setPos(Position pos, char value)
			throws ArrayIndexOutOfBoundsException {
		if (map[pos.getY()][pos.getX()] == '-' || value == '-') {
			map[pos.getY()][pos.getX()] = value;
			return true;
		} else if ((map[pos.getY()][pos.getX()] == 'P' && value == 'D')
				|| (map[pos.getY()][pos.getX()] == 'D' && value == 'P')) {
			map[pos.getY()][pos.getX()] = 'P';
			return true;
		}
		return false;
	}

	public char getPos(Position pos) throws ArrayIndexOutOfBoundsException {
		return map[pos.getY()][pos.getX()];
	}

	public char[][] getMap() {
		return map;
	}

	public boolean isOccupied(Position position) {
		if (map[position.getY()][position.getX()] == '-')
			return false;
		else if (map[position.getY()][position.getX()] == 'P')
			return true;
		else {
			return false;
		}
	}

	public int getHeight() {
		return map.length;
	}

	public int getWidth() {
		return map[0].length;
	}
}
