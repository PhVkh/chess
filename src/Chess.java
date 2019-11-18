import java.util.Collections;
import java.util.List;

public class Chess
{
    final private static int TIME_BETWEEN_TURNS = 2_500;

    private static boolean makeMove(Board desk, Figure.Color color) {
        boolean movementDone = false;
        List<Figure> sameColor = desk.getFiguresByColor(color);
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
		desk.setFigures();
        desk.printDesk();


        int blacksCount = 16, blackTime = 0;
        int whitesCount = 16, whiteTime = 0;
        while (true) {
            if (!makeMove(desk, Figure.Color.WHITE)) {
                System.out.println("Whites cant make a move.");
                break;
            }
            if (!makeMove(desk, Figure.Color.BLACK)) {
                System.out.println("Blacks cant make a move.");
                break;
            }

            if (whitesCount == desk.getFiguresByColor(Figure.Color.WHITE).size()) {
            ++blackTime;
        } else {
                whitesCount = desk.getFiguresByColor(Figure.Color.WHITE).size();
                whiteTime = 0;
            }
            if (whitesCount == desk.getFiguresByColor(Figure.Color.WHITE).size()) {
            ++whiteTime;
        } else {
                whitesCount = desk.getFiguresByColor(Figure.Color.WHITE).size();
                whiteTime = 0;
            }
            if (blackTime > 10 && whiteTime > 10) {
                System.out.println("Boring game.");
                break;
            }
        }
    }
}