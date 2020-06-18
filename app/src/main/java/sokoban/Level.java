package sokoban;

import android.graphics.Point;

public class Level {
	
	protected Placeable[][] allPlaceables;
	
	private String levelName;
	private int x;
	private int y;
	private String initialLevelString;
	private int completedCount;
	
	public int moveCount;
	public int targetCount;
	
	
	public Level(String newLevelName, int newY, int newX, String newinitialLevelString) {
		
		this.levelName = newLevelName;
		this.x = newX;
		this.y = newY;
		this.initialLevelString = newinitialLevelString;
		this.moveCount = 0;
		this.completedCount = 0;
		this.allPlaceables = new Placeable[newX][newY];
		
		this.targetCount = this.initialLevelString.length() - this.initialLevelString.replace("+", "").length();
		
		//Putting level string into place-able array
		int placableNum = 0;
		
		for (int y = 0; y < this.y; y++) {
			
			for (int x = 0; x < this.x; x++) {
				
				switch (newinitialLevelString.charAt(placableNum)) {
				
					case '#':
						
						this.allPlaceables[x][y] = new Wall(x,y);
						break;
					
					case '.':
						
						this.allPlaceables[x][y] = new Empty(x,y);
						break;
					
					case 'x':
						
						// The crate must be inside/on top of an empty square
						Empty crateInEmpty = new Empty(x,y);
						crateInEmpty.addCrate(new Crate(x,y));
						this.allPlaceables[x][y] = crateInEmpty;
						break;
					
					case 'w':
						
						// The worker must be inside/on top of an empty square
						Empty workerInEmpty = new Empty(x,y);
						workerInEmpty.addWorker(new Worker(x,y));
						this.allPlaceables[x][y] = workerInEmpty;
						break;
					
					case '+':
						
						this.allPlaceables[x][y] = new Target(x,y);
						break;
				
				}
				
				placableNum++;
				
			}
			
		}
		
	}
	
	public Point getWorkerLocation() {
		
		for (int y = 0; y < this.y; y++) {
			
			for (int x = 0; x < this.x; x++) {
				
				if (this.allPlaceables[x][y].symbol == 'w' || this.allPlaceables[x][y].symbol == 'W') {
					
					return this.allPlaceables[x][y].location;
					
				}
				
			}
			
		}
		
		return null;	
		
	}
	
	public String toString() {
		
		String result = this.levelName + "\n";
		int currIndex = 0;
		
		for (int y = 0; y < this.y; y++) {
			
			for (int x = 0; x < this.x; x++) {
				
				result = result + this.initialLevelString.charAt(currIndex);
				
				currIndex++;
				
			}

			result = result + "\n";
			
		}
		
		result = result + "move " + this.getMoveCount() + "\n";
		
		result = result + "completed " + this.getCompletedCount() + " of " + this.targetCount + "\n";
		
		return result;

	}
	
	public String getInitialLevelString() {
		
		return this.initialLevelString;
	}
	
	public int getWidth() {
		
		return this.x;
		
	}

	public char getXY(int x, int y) {

		return allPlaceables[x][y].symbol;

	}

	
	public int getHeight() {
		
		return this.y;
		
	}
	
	public int getMoveCount() {
		
		return this.moveCount;
	}
	
	public String getName() {
		
		return this.levelName;

	}
	
	public int getCompletedCount() {
		
		return this.completedCount;
		
	}
	
	public void setCompletedCount() {
		
		int count = 0;
		
		for (Placeable[] placeableArray : allPlaceables) {
			
			for (Placeable placable: placeableArray) {
				
				if (placable instanceof Target) {
					
					if (((Target)placable).crateOnTarget) {
						
						count++;
						
					}
					
				}
				
			}
			
		}
		
		this.completedCount = count;
		
	}

}
