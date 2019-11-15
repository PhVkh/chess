import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure
{
    private int turn = 0;
    Pawn(Position pos, boolean color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color ? " BPawn " : " WPawn ";
    }

    List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();
        int i = this.getColor() ? 1 : -1;
        if (turn < 1) {
            Position pos = this.getPosition().change(0, 2 * i);
            boolean a = pos.isReasonable();
            boolean b = !desk.isBusy(pos, this.getColor());
            if (pos.isReasonable() && !desk.isBusy(pos, this.getColor()) && !desk.isBusy(pos, !this.getColor())) {
                positions.add(pos);
            }
        }
        Position pos = this.getPosition().change(0, i);
        if (pos.isReasonable() && !desk.isBusy(pos, this.getColor()) && !desk.isBusy(pos, !this.getColor())) {
            positions.add(pos);
        }

        pos = this.getPosition().change(-1, i);
        if (pos.isReasonable() && !desk.isBusy(pos, this.getColor()) && desk.isBusy(pos, !this.getColor())) positions.add(pos);

        pos = this.getPosition().change(1, i);
        if (pos.isReasonable() && !desk.isBusy(pos, this.getColor()) && desk.isBusy(pos, !this.getColor())) positions.add(pos);
        return positions;
    }

    Position move(Board desk) {
        Position pos = super.move(desk);
        ++this.turn;
        return pos;
    }
}