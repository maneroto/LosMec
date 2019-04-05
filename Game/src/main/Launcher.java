package main;

public class Launcher {

	public static void main(String[] args) {
		GameLoop game = new GameLoop("LosMec", 1280, 720);
		game.start();
	}
}
