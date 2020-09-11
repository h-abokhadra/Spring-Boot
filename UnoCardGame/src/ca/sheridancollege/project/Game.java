
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @modified by Sanjana 2020
 */
public class Game {

    private ArrayList<Player> players;// the players of the game
    GroupOfCards card = new GroupOfCards();
    Player player = new Player();

    public Game() {
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public void declareWinner() {

        if (card.cardPile.size() == 0) {
            System.out.println("It's a draw!");
        } else if (player.getHandOfCards().size() == 0) {
            System.out.println("Player 1 won!!!");
        } else {
            System.out.println("Player 2 won!!!");
        }

    }

}//end class
