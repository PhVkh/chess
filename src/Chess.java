import java.util.Collections;
import java.util.List;

public class Chess
{
    final private static int TIME_BETWEEN_TURNS = 2_500;

    private static boolean makeMove(Board desk, boolean color) {
        boolean movementDone = false;
        List<Figure> sameColor = desk.figuresByColor(color);
        Collections.shuffle(sameColor);
        for (Figure f : sameColor) {
            if (f.isMovable(desk)) {
                f.move(desk);
                movementDone = true;
                break;
            }
        }
        desk.printDesk();
        try {
            Thread.sleep(TIME_BETWEEN_TURNS);
        } catch (InterruptedException e) {
            System.out.println(":(");
            e.printStackTrace();
        }
        return movementDone;
    }

    public static void main(String[] args) {
        Board desk = new Board();

        for (int i = 0; i < 8; ++i) {
            desk.figures.add(new Pawn(new Position(i, 1), true));
        }
        desk.figures.add(new Rook(new Position(0, 0), true));
        desk.figures.add(new Rook(new Position(7, 0), true));
        desk.figures.add(new Horse(new Position(1, 0), true));
        desk.figures.add(new Horse(new Position(6, 0), true));
        desk.figures.add(new Bishop(new Position(2, 0), true));
        desk.figures.add(new Bishop(new Position(5, 0), true));
        desk.figures.add(new Queen(new Position(3, 0), true));
        desk.figures.add(new King(new Position(4, 0), true));

        for (int i = 0; i < 8; ++i) {
            desk.figures.add(new Pawn(new Position(i, 6), false));
        }
        desk.figures.add(new Rook(new Position(0, 7), false));
        desk.figures.add(new Rook(new Position(7, 7), false));
        desk.figures.add(new Horse(new Position(1, 7), false));
        desk.figures.add(new Horse(new Position(6, 7), false));
        desk.figures.add(new Bishop(new Position(2, 7), false));
        desk.figures.add(new Bishop(new Position(5, 7), false));
        desk.figures.add(new Queen(new Position(4, 7), false));
        desk.figures.add(new King(new Position(3, 7), false));

        desk.printDesk();

        while (true) {
            if (makeMove(desk, false)) {} else {
                System.out.println("Whites cant make a move.");
                break;
            }
            if (makeMove(desk, true)) {} else {
                System.out.println("Blacks cant make a move.");
                break;
            }
        }
    }
}