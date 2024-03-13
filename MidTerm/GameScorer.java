public class GameScorer {

	private String gameName;
	private int gameLevel;
	private int duration;


	public static void main(String[] args) {
		
	}


	// Task 1
	public void setGameName(String name) {
		gameName = name;
	}
	
	public String getGameName() {
		return gameName;
	}

	public void setGameLevel(int level) {
		gameLevel = level;
	}

	public int getGameLevel() {
		return gameLevel;
	}

	public void setDuration(int durationTime) {
		duration = durationTime;
	}

	public int getDuration() {
		return duration;
	}


}
