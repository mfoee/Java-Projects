package TicTacToe;

public class Players extends BoardGame{
	
	private String main;
	private String opponent;

	public Players(String main){
		this.main = main;
	}
	
	public String getMain(){
		return this.main;
	}
	
	public void setMain(String mainPlayer){
		this.main = mainPlayer;
		this.opponent = "x";
	}
	
	public String getOpponent(){
		return this.opponent;
	}
	
}
