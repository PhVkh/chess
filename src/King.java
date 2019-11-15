import java.util.ArrayList;
import java.util.List;

public class King extends Figure
{
    King(Position pos, boolean color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color ? " BKing " : " WKing ";
    }

    List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (i != 0 && j != 0) {
                    Position pos = this.getPosition().change(i, j);
                    if (pos.isReasonable() && !desk.isBusy(pos, this.getColor())) {
                        positions.add(pos);
                    }
                }
            }
        }
        return positions;
    }
}