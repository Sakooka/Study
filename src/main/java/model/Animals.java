package model;

public class Animals {

	private int id;
	private String name;
	private int votes;
	
	public Animals(int id,String name, int votes) {
		super();
		this.id =id;
		this.name = name;
		this.votes = votes;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
