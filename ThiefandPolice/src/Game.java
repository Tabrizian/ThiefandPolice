import java.util.ArrayList;
import java.util.Random;

public class Game {
	private int time;
	private Police[] polices;
	private Thief thief;
	private Map map;
	private boolean end = false;
	private ArrayList<Event> events;

	public Game(int width, int height, int numberOfPolice) {
		time = 0;
		polices = new Police[numberOfPolice];
		map = new Map(height, width);
		thief = new Thief(map);
		for (int i = 0; i < polices.length; i++) {
			polices[i] = new Police(map);
		}
		events = new ArrayList<Event>();
		show();
	}

	public void run() {
		while (true) {
			Random rnd = new Random();
			for (int j = 0; j < polices.length; j++) {
				Direction direction = polices[j].getDirection(map);
				if (direction == null) {
					events.add(polices[j].move(
							Direction.values()[rnd.nextInt(8)], j));
				} else {
					events.add(polices[j].move(direction, j));
				}
			}
			events.add(thief.move(Direction.values()[rnd.nextInt(8)], 0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			doEvents();
			updateEnd();
			show();
		}
	}

	private void show() {
		System.out.printf("%c[2J",0x1B);
		System.out.println("Time:" + time);
		for (int i = map.getMap().length - 1; i >= 0; i--) {
			for (int j = 0; j < map.getMap()[0].length; j++) {
				System.out.print(map.getMap()[i][j] + " ");
			}
			System.out.println();
		}
		if (end) {
			System.out.println("Game finished!");
			System.exit(0);
		}
	}

	public void addEvent(Event event) {
		events.add(event);
	}

	private void doEvents() {
		boolean posSet;
		while(events.size() != 1) {
			try {
				Position oldPos = new Position(polices[events.get(0)
						.getNumber()].pos);
				map.setPos(polices[events.get(0).getNumber()].pos, '-');
				polices[events.get(0).getNumber()].pos = polices[events.get(0)
						.getNumber()].pos.getNextPos(events.get(0)
						.getDirection(), map);
				posSet = map
						.setPos(polices[events.get(0).getNumber()].pos, 'P');
				if (posSet)
					events.remove(0);
				if (!posSet) {
					polices[events.get(0).getNumber()].pos = oldPos;
					map.setPos(oldPos, 'P');
					events.remove(0);
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				map.setPos(polices[events.get(0).getNumber()].pos, 'P');
				events.remove(0);
			}
		}
		updateEnd();
		if (!end) {
			try {
				Position oldPos = new Position(thief.pos);
				map.setPos(thief.pos, '-');
				thief.pos = thief.pos.getNextPos(events.get(0).getDirection(),
						map);
				posSet = map.setPos(thief.pos, 'D');
				if (!posSet)
					thief.pos = oldPos;
			} catch (ArrayIndexOutOfBoundsException e) {
				map.setPos(thief.pos, 'D');
			}
			events.remove(0);
		}
	}

	private void updateEnd() {
		for (int i = 0; i < map.getMap().length; i++) {
			for (int j = 0; j < map.getMap()[0].length; j++) {
				if (map.getMap()[i][j] == 'D') {
					end = false;
					return;
				}
			}
		}
		end = true;
	}

}
