import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Figure> figures = new ArrayList<>();

    public void initializeFigures() {
		for (int i = 0; i < 8; ++i) {
            figures.add(new Pawn(new Position(i, 1), Figure.Color.BLACK));
        }
        figures.add(new Rook(new Position(0, 0), Figure.Color.BLACK));
        figures.add(new Rook(new Position(7, 0), Figure.Color.BLACK));
        figures.add(new Horse(new Position(1, 0), Figure.Color.BLACK));
        figures.add(new Horse(new Position(6, 0), Figure.Color.BLACK));
        figures.add(new Bishop(new Position(2, 0), Figure.Color.BLACK));
        figures.add(new Bishop(new Position(5, 0), Figure.Color.BLACK));
        figures.add(new Queen(new Position(3, 0), Figure.Color.BLACK));
        figures.add(new King(new Position(4, 0), Figure.Color.BLACK));

        for (int i = 0; i < 8; ++i) {
            figures.add(new Pawn(new Position(i, 6), Figure.Color.WHITE));
        }
        figures.add(new Rook(new Position(0, 7), Figure.Color.WHITE));
        figures.add(new Rook(new Position(7, 7), Figure.Color.WHITE));
        figures.add(new Horse(new Position(1, 7), Figure.Color.WHITE));
        figures.add(new Horse(new Position(6, 7), Figure.Color.WHITE));
        figures.add(new Bishop(new Position(2, 7), Figure.Color.WHITE));
        figures.add(new Bishop(new Position(5, 7), Figure.Color.WHITE));
        figures.add(new Queen(new Position(4, 7), Figure.Color.WHITE));
        figures.add(new King(new Position(3, 7), Figure.Color.WHITE));
	}

	public List<Figure> getFigures() {
        return figures;
    }
    public boolean isBusyByColor(Position position, Figure.Color color) {
        for (Figure f : figures) {
            if (f.getPosition().equals(position) && color == f.getColor()) {
                return true;
            }
        }
        return  false;
    }

    public List<Figure> getFiguresByColor(Figure.Color color) {
        List<Figure> sameColor= new ArrayList<>();
        for (Figure f : figures) {
            if (f.getColor() == color) {
                sameColor.add(f);
            }
        }
        return sameColor;
    }

    public void printDesk() {
        System.out.println("=======================================================");
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                int added = 0;
                for (Figure f: figures) {
                    if (f.getPosition().equals(new Position(j, i))) {
                        System.out.print(f.symbol);
                        added = 1;
                    }
                }
                if (added == 0) System.out.print("   #   ");
            }
            System.out.println("\n");
        }
        System.out.println("=======================================================");
    }
}