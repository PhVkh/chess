import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure
{
    Bishop(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BBish " : " WBish ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();

        for (int i = 1; i <= 7; ++i) {
            Position pos = this.getPosition().change(i, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = -1; i >= -7; --i) {
            Position pos = this.getPosition().change(i, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = 1; i <= 7; ++i) {
            Position pos = this.getPosition().change(-i, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        for (int i = -1; i >= -7; --i) {
            Position pos = this.getPosition().change(-i, i);
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                positions.add(pos);
            } else break;
        }

        return positions;
    }
}