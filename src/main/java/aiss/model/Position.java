package aiss.model;

public enum Position {
	
	STRIKER("Striker"), 
    CENTERFORWARD("Center Forward"), 
    WINGER("Winger"), 
    LEFTMID("Left Mid"),
	RIGHTMID("Right Mid"), 
    CENTERMID("Center Mid"), 
    ATTACKINGMID("Attacking Mid"), 
    DEFENSIVEMID("Defensive Mid"),
	CENTERBACK("Center Back"), 
    FULLBACK("Full Back"), 
    WINGBACK("Wing Back"), 
    GOALKEEPER("Goalkeeper");

	private String position;
	 
    Position(String position) {
        this.position = position;
    }
 
    public String getPosition() {
        return position;
    }

	void setPosition(String position2) {
		// TODO Auto-generated method stub
		
	}
}
