package aiss.model;



public class Player {

	private enum Position {GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER};

	private String id;
    private String name;
    private String surname;
    private String team;
    private String nationality;
    private int age;
    private Position position;

    public Player() {
    }


    public Player(String name, String surname, String team, String nationality, int age, Position position) {
        this.name = name;
        this.surname = surname;
        this.team = team;
        this.nationality = nationality;
        this.age = age;
        this.position = position ;
    }



    public Player(String id, String name, String surname, String team, String nationality, int age,
            Position position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.team = team;
        this.nationality = nationality;
        this.age = age;
        this.position = position;
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
    
    

}
