package sokoban;

public class Empty extends Immovable {

	private Crate storedCrate;
	private Worker storedWorker;
	
	public Empty(int x, int y) {
		super(x, y);
		this.symbol = '.';
	}
	
	public void addCrate(Crate crate) {
		
		this.symbol = 'x';
		//Finish implementation
		this.storedCrate = crate;
		
	}
	
	public Crate extractCrate() {
		
		Crate result = this.storedCrate;
		this.storedCrate = null;
		this.symbol = '.';
		return result;
		
	}
	
	public void addWorker(Worker worker) {
		
		this.symbol = 'w';
		//Finish implementation
		this.storedWorker = worker;
		
	}
	
	public Worker extractWorker() {
		
		Worker result = this.storedWorker;
		this.storedWorker = null;
		this.symbol = '.';
		return result;
		
	}

}
