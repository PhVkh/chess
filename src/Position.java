public class Position
{
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Position pos = (Position) obj;
        return (this.x == pos.getX() && this.y == pos.getY());
    }

    Position change(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    boolean isReasonable() {
        return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }
}