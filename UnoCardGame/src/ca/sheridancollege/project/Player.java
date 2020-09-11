
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 */
public class Player {

    private String playerID; //the unique ID for this player
    private List<Card> hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }

    public Player() {
        this.hand = new ArrayList<Card>();
    }

    public List<Card> getHandOfCards() {
        return hand;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }
    

    @Override
    public String toString() {
        return String.format("Player: %s", this.playerID);
    }

}
