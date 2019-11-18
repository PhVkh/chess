import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure
{
    private int turn = 0;
    Pawn(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BPawn " : " WPawn ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();
        int i = this.getColor() == Color.BLACK ? 1 : -1;
        if (turn < 1) {
            Position pos = this.getPosition().change(0, 2 * i);
            boolean a = pos.isReasonable();
            boolean b = !desk.isBusyByColor(pos, this.getColor());
            if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())
                    && !desk.isBusyByColor(pos, this.getColor().invertColor())) {
                positions.add(pos);
            }
        }
        Position pos = this.getPosition().change(0, i);
        if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())
                && !desk.isBusyByColor(pos, this.getColor().invertColor())) {
            positions.add(pos);
        }

        pos = this.getPosition().change(-1, i);
        if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())
                && desk.isBusyByColor(pos, this.getColor().invertColor())) {
            positions.add(pos);
        }

        pos = this.getPosition().change(1, i);
        if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())
                && desk.isBusyByColor(pos, this.getColor().invertColor())) {
            positions.add(pos);
        }
        return positions;
    }

    public Position move(Board desk) {
        Position pos = super.move(desk);
        ++this.turn;
        return pos;
    }
}