public class Event {
    
	public static void main(String[] args) {
		GameScorer myGame = new GameScorer();

        // Q12a: set instance variables
        // set gameName
        myGame.setGameName("Chess");

        // set gameLevel
        myGame.setGameLevel(7);

        // set duration
        myGame.setDuration(5);


        // Q12b: print instance variables
        System.out.println("gameName: " + myGame.getGameName());
        System.out.println("gameLevel: " + myGame.getGameLevel());
        System.out.println("duration: " + myGame.getDuration());


	}


}
