package aiss.model;

public class Players {
	

		private String id;
		private String name;
		private String surname;
		private String team;
		private String nationality;
		private int age;
		private String position;
		
		
		public Players(String name, String surname, String team, String nationality, int age, String position) {
			super();
			this.name = name;
			this.surname = surname;
			this.team = team;
			this.nationality = nationality;
			this.age = age;
			this.position = position;
		}



		public Players(String id, String name, String surname, String team, String nationality, int age,
				String position) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			this.team = team;
			this.nationality = nationality;
			this.age = age;
			this.position = position;
		}
		
		
		public Players() {
			super();
		}
}
