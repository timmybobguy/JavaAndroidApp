package sokoban;

public class Target extends Immovable {
	
	private Crate storedCrate;
	private Worker storedWorker;
	
	public boolean crateOnTarget = false;

	public Target(int x, int y) {
		super(x, y);
		this.symbol = '+';
	}
	
	public void addCrate(Crate crate) {
		
		this.symbol = 'X';
		//Finish implementation
		this.storedCrate = crate;
		crateOnTarget = true;
		
	}
	
	public Crate extractCrate() {
		
		Crate result = this.storedCrate;
		this.storedCrate = null;
		this.symbol = '+';
		crateOnTarget = false;
		return result;
		
		
	}
	
	public void addWorker(Worker worker) {
		
		this.symbol = 'W';
		//Finish implementation
		this.storedWorker = worker;
		
	}
	
	public Worker extractWorker() {
		
		Worker result = this.storedWorker;
		this.storedWorker = null;
		this.symbol = '+';
		return result;
		
	}
	
}
