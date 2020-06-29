package sokoban;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Level> allMyLevels = new ArrayList<Level>();
	public Level selectedLevel;
	
	
	public void addLevel(String newLevelName, int newX, int newY, String newinitialLevelString) {
		
		Level newLevel = new Level(newLevelName, newX, newY, newinitialLevelString);
		this.allMyLevels.add(newLevel);
		this.selectedLevel = this.allMyLevels.get(this.allMyLevels.size()-1);
		
	}
	
	public int getLevelCount() {
		
		if (this.allMyLevels==null) {
			
			return 0;
			
		} else {
			
			return this.allMyLevels.size();
		}
		
	}
	
	public void move(Direction direction) {
		
		Point workerPosition = selectedLevel.getWorkerLocation();
		Placeable currPosition = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y];
		selectedLevel.moveCount++;
		Placeable secondUp;
		Placeable movingToUp;

		if (direction == Direction.UP) {

			movingToUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y-1];

		}
		else if (direction == Direction.DOWN) {

			movingToUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y+1];

		} else if (direction == Direction.LEFT) {

			movingToUp = selectedLevel.allPlaceables[workerPosition.x-1][workerPosition.y];

		} else {

			movingToUp = selectedLevel.allPlaceables[workerPosition.x+1][workerPosition.y];

		}


		if (workerPosition.y-2 < 0) {

			secondUp = movingToUp;

		} else {

			if (direction == Direction.UP) {

				secondUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y-2];

			}
			else if (direction == Direction.DOWN) {

				secondUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y+2];

			} else if (direction == Direction.LEFT) {

				secondUp = selectedLevel.allPlaceables[workerPosition.x-2][workerPosition.y];

			} else {

				secondUp = selectedLevel.allPlaceables[workerPosition.x+2][workerPosition.y];

			}
		}


		if (movingToUp.symbol == '.') {

			if (currPosition instanceof Empty) {

				Worker worker = ((Empty) currPosition).extractWorker();
				((Empty) movingToUp).addWorker(worker);

			} else {

				Worker worker = ((Target) currPosition).extractWorker();
				((Empty) movingToUp).addWorker(worker);
			}

		} else if (movingToUp.symbol == '+') {

			if (currPosition instanceof Empty) {

				Worker worker = ((Empty) currPosition).extractWorker();
				((Target) movingToUp).addWorker(worker);

			} else {

				Worker worker = ((Target) currPosition).extractWorker();
				((Target) movingToUp).addWorker(worker);
			}


		} else if (movingToUp.symbol == 'x' || movingToUp.symbol == 'X') {

			//See if crate can be moved, if true then move crate into next square, then move worker into square
			if (secondUp.symbol == '.' || secondUp.symbol == '+') {

				//First move crate into position
				if (secondUp.symbol == '.') {

					if (movingToUp instanceof Empty ) {

						Crate crate = ((Empty) movingToUp).extractCrate();
						((Empty) secondUp).addCrate(crate);

					} else {

						Crate crate = ((Target) movingToUp).extractCrate();
						((Empty) secondUp).addCrate(crate);

					}


				} else { //if target

					if (movingToUp instanceof Target) {

						Crate crate = ((Target) movingToUp).extractCrate();
						((Target) secondUp).addCrate(crate);

					} else {

						Crate crate = ((Empty) movingToUp).extractCrate();
						((Target) secondUp).addCrate(crate);

					}

				}

				//Then move worker into position

				if (movingToUp.symbol == '.') {

					if (currPosition instanceof Empty) {

						Worker worker = ((Empty) currPosition).extractWorker();
						((Empty) movingToUp).addWorker(worker);

					} else {

						Worker worker = ((Target) currPosition).extractWorker();
						((Empty) movingToUp).addWorker(worker);
					}

				} else if (movingToUp.symbol == '+') {

					if (currPosition instanceof Empty) {

						Worker worker = ((Empty) currPosition).extractWorker();
						((Target) movingToUp).addWorker(worker);

					} else {

						Worker worker = ((Target) currPosition).extractWorker();
						((Target) movingToUp).addWorker(worker);
					}

				}

			}
					

			

		
		}
		
		selectedLevel.setCompletedCount();
		
	}
	
	public String toString() { 
		
		if (this.getLevelCount() == 0) {
			
			return "no levels";
			
		} else {
			
			Level currLevel = this.allMyLevels.get(this.allMyLevels.size()-1);
			
			String result = currLevel.getName() + "\n";
			
			for (int y = 0; y < currLevel.getHeight(); y++) {
				
				for (int x = 0; x < currLevel.getWidth(); x++) {
					
					result = result + currLevel.allPlaceables[x][y].symbol;
					
				}
				
				result = result + "\n";
				
			}
			
			result = result + "move " + currLevel.getMoveCount() + "\n";
			
			result = result + "completed " + currLevel.getCompletedCount() + " of " + currLevel.targetCount + "\n";
			
			return result;
			
		}

	}
	
	public String getCurrentLevelName() {
		
		if (this.getLevelCount() == 0) {
			
			return "no levels";
			
		}
		
		return this.allMyLevels.get(this.allMyLevels.size()-1).getName();
		
	}
	
	public List<String> getLevelNames() {
		
		List<String> result = new ArrayList<String>();
		
		for (Level level : this.allMyLevels) {
			
			result.add(level.getName());
			
		}
		
		return result;
	}

}
