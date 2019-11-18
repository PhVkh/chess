import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure
{
    Queen(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BQuee " : " WQuee ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>(new Bishop(this.getPosition(), this.getColor()).moves(desk));
        positions.addAll(new Rook(this.getPosition(), this.getColor()).moves(desk));
        return positions;
    }
}