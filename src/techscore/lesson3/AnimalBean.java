package techscore.lesson3;

public class AnimalBean {
	private String name;

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public AnimalBean(){}
	public AnimalBean(String name){
		this.name = name;
	}
}
