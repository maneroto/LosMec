package main;

/**
 * Esta clase es la que ejecuta el gameloop de nuestro juego
 * @author Los mec
 *
 */
public class Launcher 
{

	public static void main(String[] args) {
		GameLoop game = new GameLoop("LosMec", 1280, 768);
		game.start();
	}
}
