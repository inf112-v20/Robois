package inf112.skeleton.app.boardtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.objects.Board;

/**
 * Unit test for simple App.
 */
public class BoardShould {
    private Board brd;
    private int standardBoardWidth;
    private int standardBoardHeight;

    @Before
    public void instantiateBoard() {
        try {
            brd = new Board("b0.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
}
