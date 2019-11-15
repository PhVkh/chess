import java.util.ArrayList;
import java.util.List;

public class Board
{
    List<Figure> figures = new ArrayList<>();

    boolean isBusy(Position position, boolean color) {
        for (Figure f : figures) {
            if (f.getPosition().equals(position) && color == f.getColor()) {
                return true;
            }
        }
        return  false;
    }

    List<Figure> figuresByColor(Boolean color) {
        List<Figure> sameColor= new ArrayList<>();
        for (Figure f : figures) {
            if (f.getColor() == color) {
                sameColor.add(f);
            }
        }
        return sameColor;
    }

    void printDesk() {
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