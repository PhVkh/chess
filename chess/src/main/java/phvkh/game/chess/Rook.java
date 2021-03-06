import java.util.ArrayList;
import java.util.List;

public class Rook extends Figure
{
    Rook(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BRook " : " WRook ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();

        for (int i = 1; i <= 7; ++i) {
            Position pos = this.getPosition().change(0, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = -1; i >= -7; --i) {
            Position pos = this.getPosition().change(0, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = 1; i <= 7; ++i) {
            Position pos = this.getPosition().change(i, 0);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = -1; i >= -7; --i) {
            Position pos = this.getPosition().change(i, 0);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        return positions;
    }
}