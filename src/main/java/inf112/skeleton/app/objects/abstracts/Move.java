package inf112.skeleton.app.objects.abstracts;

import inf112.skeleton.app.Player;
import inf112.skeleton.app.ui_objects.ProgramCard;

public class Move {
    private Player player;
    private ProgramCard programCard;

    public Move(Player player, ProgramCard programCard) {
        this.player = player;
        this.programCard = programCard;
    }

    public Player getPlayer(){
        return this.player;
    }
    
    public ProgramCard getProgramCard(){
        return this.programCard;
    }
}