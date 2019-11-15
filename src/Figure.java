import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class Figure
{
    private Position pos;
    private boolean color;
    String symbol;

    void setColor(boolean color) {
        this.color = color;
    }

    boolean getColor() {
        return this.color;
    }

    void setPosition(Position pos) {
        this.pos = pos;
    }

    Position getPosition() {
        return this.pos;
    }

    abstract List<Position> moves(Board desk);

    boolean isMovable(Board desk) {
        return this.moves(desk).size() > 0;
    }

    Position move(Board desk) {
        List<Position> moves = this.moves(desk);
        Collections.shuffle(moves);
        Position move = moves.get(0);
        Iterator itr = desk.figures.iterator();

        while (itr.hasNext()) {
            Figure f = (Figure) itr.next();
            if (f.pos.equals(move)) {
                itr.remove();
            }
        }
        this.setPosition(move);
        return move;
    }
}