package inf112.skeleton.app.boardtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.objects.Board;

/**
 * Unit test for simple App.
 */
public class BoardShould 
{
    Board brd;
    int standardBoardWidth;
    int standardBoardHeight;

    @Before
    public void instantiateBoard(){
        brd = new Board();
        standardBoardWidth = brd.getWidth();
        standardBoardHeight = brd.getHeight();
    }

    @Test
    public void be12x12WhenStandard()
    {
        assertEquals(12, standardBoardHeight);
        assertEquals(12, standardBoardWidth);
    }
    
    @Test
    public void haveATileInEveryPosition()
    {
        for (int i = 0; i < standardBoardWidth; i++){
            for (int j = 0; j < standardBoardHeight; j++){
                assertNotNull(brd.getPosition(i, j));
            }
        }
    }
}
