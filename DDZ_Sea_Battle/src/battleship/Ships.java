package battleship;
import java.util.ArrayList;
import java.util.Random;

public class Ships {
    private final int CELL_SIZE;
    private ArrayList<Ship> ships = new ArrayList<>();
    private final int[] DECKS = {4,3,3,2,2,2,1,1,1,1};
    private Random random;
    private boolean hide;

    Ships(int fieldSize, int cellSize, boolean hide)
    {
        random = new Random();
        for (int i = 0; i < DECKS.length; i++)
        {
            Ship ship;
            do
            {
                int x = random.nextInt(fieldSize);
                int y = random.nextInt(fieldSize);
                int location = random.nextInt(2);
                ship = new Ship(x, y, DECKS[i], location);

            }while (ship.outOfField(0, fieldSize - 1)  || contact(ship));
        }
        CELL_SIZE = cellSize;
        this.hide = hide;
    }

    boolean contact(Ship sh)
    {
        for (Ship ship : ships)
        {
            if (ship.contact(sh))
                return true;
        }
        return false;
    }
}