package inf112.skeleton.app;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.abstracts.Move;
import inf112.skeleton.app.ui_objects.ProgramCard;
import inf112.skeleton.app.ui_objects.ProgramCardType;
import inf112.skeleton.app.utilities.RelativeDirection;

public class GameLoop{

    
    private Map<Integer, Move> moves;

    private boolean executeCards;
    private boolean executingRound;
    private ProgramCard[] hand;
    private int currentRound;
    private int maxRound = 5;

    private Game game;
    private Board board;
    
    private float timeSeconds = 0f;
    private float period = 0.3f;

    public GameLoop(Game game) {
        this.game = game;
        this.board = game.getBoard();

        this.moves = new HashMap<>();

        this.executeCards = false;
        this.executingRound = false;
        this.hand = new ProgramCard[5];
    }

    public void render() {
        if (executingRound){
            executeRound();
            if (executeCards) {
                execute();
            }
        }
        
    }
    
    private void execute() {
        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if(timeSeconds > period){
            timeSeconds-=period;
            
            if (moves.size() <= 0){
                this.executeCards = false;
                GamePhase.runPhaseChange(game);
                return;
            }

            Map.Entry<Integer, Move> minEntry = null;

            for (Map.Entry<Integer, Move> entry : this.moves.entrySet()) {
        
                if (minEntry == null|| entry.getKey().compareTo(minEntry.getKey()) < 0) {
                    minEntry = entry;
                }
            }

            this.moves.remove(minEntry.getKey());

            ProgramCardType c = minEntry.getValue().getProgramCard().getType();
            Player p = minEntry.getValue().getPlayer();
            if (p.getRobot() == null) return;
            Robot r = p.getRobot();
            executeCard(c, r);
        }
    }

    private void executeCard(ProgramCardType c, Robot r) {
        switch (c) {
            case MOVE1:
                GameMovement.move(1, r, board, game);
                break;
            case MOVE2:
                GameMovement.move(2, r, board, game);
                break;
            case MOVE3:
                GameMovement.move(3, r, board, game);
                break;
            case BACKUP:
                GameMovement.moveBackwards(1, r, board, game);
                break;
            case ROTATE_LEFT:
                GameMovement.rotate(RelativeDirection.LEFT, r);
                break;
            case ROTATE_RIGTH:
                GameMovement.rotate(RelativeDirection.RIGHT, r);
                break;
            case UTURN:
                GameMovement.rotate(RelativeDirection.LEFT, r);
                GameMovement.rotate(RelativeDirection.LEFT, r);
                break;
            default:
                break;
        }
    }

    public void addMove(ProgramCard c, Player p) {
        this.moves.put(c.getPriority(), new Move(p, c));
    }

    public void startRound(ProgramCard[] hand) {
        if (this.executingRound) return;
        for (int i = 0; i < hand.length; i++) {
            this.hand[i] = hand[i];
        }
        this.executingRound = true;
        this.currentRound = 0;
    }
    
    private void executeRound() {
        if (this.executeCards) return;
        this.currentRound++;
        this.moves.clear();

        this.addAIMove(game.getCurrentPlayer());
        
        for (int i = 0; i < hand.length; i++){
            ProgramCard c = hand[i];
            if (c != null){
                this.addMove(c, game.getCurrentPlayer());
                hand[i] = null;
                break;
            }
        }

        if (currentRound > maxRound) {
            this.executingRound = false;
            game.getGameRendering().resetCards();
            game.getGameRendering().resetLockedCards();
        }

        timeSeconds = 0f;
        this.executeCards = true;
    }

    private void addAIMove(Player exludedPlayer) {
        for (Player p : game.getPlayers()) {
            if (!p.equals(exludedPlayer)) {
                ProgramCardType t = ProgramCardType.getRandomCard();
                ProgramCard c = new ProgramCard(1, 1, 1, ProgramCardType.getRandomInt(t), t);
                addMove(c, p);
            }
        }
        
    }

    public void endGame() {
        this.executingRound = false;
        this.executeCards = false;
        this.moves.clear();
        this.currentRound = 0;
    }

    public boolean getExecutingRound() {
        return this.executingRound;
    }
}