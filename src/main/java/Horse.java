import java.util.ArrayList;
import java.util.List;

public class Horse extends Figure
{
    Horse(Position pos, Color color) {
        this.setPosition(pos);
        this.setColor(color);
        symbol = color == Color.BLACK ? " BHors " : " WHors ";
    }

    public List<Position> moves(Board desk) {
        List<Position> positions = new ArrayList<>();
        for (int i = 1; i <= 2; ++i) {
            for (int j = -1; j <= 1; j += 2) {
                for (int k = -1; k <= 1; k += 2) {
                    int x = i * j;
                    int y = (3 - i) * k;
                    Position pos = this.getPosition().change(x, y);
                    if (pos.isReasonable() && !desk.isBusyByColor(pos, this.getColor())) {
                        positions.add(pos);
                    }
                }
            }
        }
        return positions;
    }
}