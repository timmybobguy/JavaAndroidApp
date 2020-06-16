package sokoban;

import java.awt.Point;
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
		
		switch (direction) {
		
			case UP:
						
				Placeable movingToUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y-1];
				Placeable secondUp;
				
				if (workerPosition.y-2 < 0) {
					
					secondUp = movingToUp;
					
				} else {
					
					secondUp = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y-2];
					
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
			
				break;
			
			case DOWN:
				
				Placeable movingToDown = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y+1];
				Placeable secondDown;
				
				if (workerPosition.y+2 > selectedLevel.getHeight()-1) {
					
					secondDown = movingToDown;
					
				} else {
					
					secondDown = selectedLevel.allPlaceables[workerPosition.x][workerPosition.y+2];
					
				}
						
				if (movingToDown.symbol == '.') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Empty) movingToDown).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Empty) movingToDown).addWorker(worker);
					}	
					
				} else if (movingToDown.symbol == '+') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Target) movingToDown).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Target) movingToDown).addWorker(worker);
					}
					
					
				} else if (movingToDown.symbol == 'x' || movingToDown.symbol == 'X') {
					
					//See if crate can be moved, if true then move crate into next square, then move worker into square
					if (secondDown.symbol == '.' || secondDown.symbol == '+') {
						
						//First move crate into position
						if (secondDown.symbol == '.') {
							
							if (movingToDown instanceof Empty ) {
								
								Crate crate = ((Empty) movingToDown).extractCrate();
								((Empty) secondDown).addCrate(crate);
								
							} else {
								
								Crate crate = ((Target) movingToDown).extractCrate();
								((Empty) secondDown).addCrate(crate);
								
							}
							
							
						} else { //if target
							
							if (movingToDown instanceof Target) {
								
								Crate crate = ((Target) movingToDown).extractCrate();
								((Target) secondDown).addCrate(crate);
								
							} else {
								
								Crate crate = ((Empty) movingToDown).extractCrate();
								((Target) secondDown).addCrate(crate);
								
							}
							
						}
						
						//Then move worker into position
						
						if (movingToDown.symbol == '.') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Empty) movingToDown).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Empty) movingToDown).addWorker(worker);
							}	
							
						} else if (movingToDown.symbol == '+') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Target) movingToDown).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Target) movingToDown).addWorker(worker);
							}	
							
						}
						
					}	
					
				}
				
				break;
				
			case LEFT:
				
				Placeable movingToLeft = selectedLevel.allPlaceables[workerPosition.x-1][workerPosition.y];
				Placeable secondLeft;
				
				if (workerPosition.x-2 < 0) {
					
					secondLeft = movingToLeft;
					
				} else {
					
					secondLeft = selectedLevel.allPlaceables[workerPosition.x-2][workerPosition.y];
					
				}
				
						
				if (movingToLeft.symbol == '.') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Empty) movingToLeft).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Empty) movingToLeft).addWorker(worker);
					}	
					
				} else if (movingToLeft.symbol == '+') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Target) movingToLeft).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Target) movingToLeft).addWorker(worker);
					}
					
					
				} else if (movingToLeft.symbol == 'x' || movingToLeft.symbol == 'X') {
					
					//See if crate can be moved, if true then move crate into next square, then move worker into square
					if (secondLeft.symbol == '.' || secondLeft.symbol == '+') {
						
						//First move crate into position
						if (secondLeft.symbol == '.') {
							
							if (movingToLeft instanceof Empty ) {
								
								Crate crate = ((Empty) movingToLeft).extractCrate();
								((Empty) secondLeft).addCrate(crate);
								
							} else {
								
								Crate crate = ((Target) movingToLeft).extractCrate();
								((Empty) secondLeft).addCrate(crate);
								
							}
							
							
						} else { //if target
							
							if (movingToLeft instanceof Target) {
								
								Crate crate = ((Target) movingToLeft).extractCrate();
								((Target) secondLeft).addCrate(crate);
								
							} else {
								
								Crate crate = ((Empty) movingToLeft).extractCrate();
								((Target) secondLeft).addCrate(crate);
								
							}
							
						}
						
						//Then move worker into position
						
						if (movingToLeft.symbol == '.') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Empty) movingToLeft).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Empty) movingToLeft).addWorker(worker);
							}	
							
						} else if (movingToLeft.symbol == '+') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Target) movingToLeft).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Target) movingToLeft).addWorker(worker);
							}	
							
						}
						
					}	
					
				}
				
				break;
				
			case RIGHT:
				
				Placeable movingToRight = selectedLevel.allPlaceables[workerPosition.x+1][workerPosition.y];
				Placeable secondRight;
				
				if (workerPosition.x+2 > selectedLevel.getWidth()-1) {
					
					secondRight = movingToRight;
					
				} else {
					
					secondRight = selectedLevel.allPlaceables[workerPosition.x+2][workerPosition.y];
					
				}
						
				if (movingToRight.symbol == '.') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Empty) movingToRight).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Empty) movingToRight).addWorker(worker);
					}	
					
				} else if (movingToRight.symbol == '+') {
					
					if (currPosition instanceof Empty) {
						
						Worker worker = ((Empty) currPosition).extractWorker();
						((Target) movingToRight).addWorker(worker);
						
					} else {
						
						Worker worker = ((Target) currPosition).extractWorker();
						((Target) movingToRight).addWorker(worker);
					}
					
					
				} else if (movingToRight.symbol == 'x' || movingToRight.symbol == 'X') {
					
					//See if crate can be moved, if true then move crate into next square, then move worker into square
					if (secondRight.symbol == '.' || secondRight.symbol == '+') {
						
						//First move crate into position
						if (secondRight.symbol == '.') {
							
							if (movingToRight instanceof Empty ) {
								
								Crate crate = ((Empty) movingToRight).extractCrate();
								((Empty) secondRight).addCrate(crate);
								
							} else {
								
								Crate crate = ((Target) movingToRight).extractCrate();
								((Empty) secondRight).addCrate(crate);
								
							}
							
							
						} else { //if target
							
							if (movingToRight instanceof Target) {
								
								Crate crate = ((Target) movingToRight).extractCrate();
								((Target) secondRight).addCrate(crate);
								
							} else {
								
								Crate crate = ((Empty) movingToRight).extractCrate();
								((Target) secondRight).addCrate(crate);
								
							}
							
						}
						
						//Then move worker into position
						
						if (movingToRight.symbol == '.') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Empty) movingToRight).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Empty) movingToRight).addWorker(worker);
							}	
							
						} else if (movingToRight.symbol == '+') {
							
							if (currPosition instanceof Empty) {
								
								Worker worker = ((Empty) currPosition).extractWorker();
								((Target) movingToRight).addWorker(worker);
								
							} else {
								
								Worker worker = ((Target) currPosition).extractWorker();
								((Target) movingToRight).addWorker(worker);
							}	
							
						}
						
					}	
					
				}
				
				break;
		
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
