import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class Figure
{
    private Position pos;
    String symbol;

    enum Color
    {
        WHITE, BLACK;
        Color invertColor() {
            if (this.equals(Color.WHITE)) return Color.BLACK;
            return Color.WHITE;
        }
    }
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public Position getPosition() {
        return this.pos;
    }

    abstract List<Position> moves(Board desk);

    public boolean isMovable(Board desk) {
        return this.moves(desk).size() > 0;
    }

    public Position move(Board desk) {
        List<Position> moves = this.moves(desk);
        Collections.shuffle(moves);
        Position move = moves.get(0);
        Iterator itr = desk.getFigures().iterator();

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