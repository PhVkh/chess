import java.util.ArrayList;
import java.util.List;

public class King extends Figure
{
    King(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BKing " : " WKing ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i != 0 && j != 0) {
                    Position pos = this.getPosition().change(i, j);
                    if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                        positions.add(pos);
                    }
                }
            }
        }
        return positions;
    }
}