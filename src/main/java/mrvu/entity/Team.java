package mrvu.entity;

public class Team {
	private Integer pk;
	private String name;
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Team(Integer pk, String name) {
		super();
		this.pk = pk;
		this.name = name;
	}
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
