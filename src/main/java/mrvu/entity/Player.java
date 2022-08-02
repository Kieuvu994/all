package mrvu.entity;

public class Player {
	private Integer pk;
	private String name;
	private String position;
	private Integer team_pk;
	public Player() {
		super();
		
	}
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getTeam_pk() {
		return team_pk;
	}
	public void setTeam_pk(Integer team_pk) {
		this.team_pk = team_pk;
	}
	public Player(Integer pk, String name, String position, Integer team_pk) {
		super();
		this.pk = pk;
		this.name = name;
		this.position = position;
		this.team_pk = team_pk;
	}
	
}
