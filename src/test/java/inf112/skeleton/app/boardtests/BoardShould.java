package inf112.skeleton.app.boardtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.tiles.Flag;

/**
 * Unit test for simple App.
 */
public class BoardShould {
    Board brd;
    int standardBoardWidth;
    int standardBoardHeight;

    @Before
    public void instantiateBoard() {
        brd = new Board();
        standardBoardWidth = brd.getWidth();
        standardBoardHeight = brd.getHeight();
    }

    @Test
    public void be12x12WhenStandard() {
        assertEquals(12, standardBoardHeight);
        assertEquals(12, standardBoardWidth);
    }

    @Test
    public void haveATileInEveryPosition() {
        for (int i = 0; i < standardBoardWidth; i++) {
            for (int j = 0; j < standardBoardHeight; j++) {
                assertNotNull(brd.getTile(i, j));
            }
        }
    }

    @Test
    public void beAbleToAddATileToAPosition(){
        Flag testObject = new Flag();
        int i = 5; 
        int j = 5;

        brd.setTile(i, j, testObject);

        assertEquals(testObject, brd.getTile(i, j));
    }
}
