package Unit;

import IUnit.Attackable;

public class Tank extends Unit implements Attackable{
	boolean mode;

	void changeMode() {
		mode=!mode;
		System.out.println("ChangedMode"+mode);
	}
	public void attack(Unit a) {
		
	}
	
}
