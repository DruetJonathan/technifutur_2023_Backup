package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import java.util.Arrays;
import java.util.List;

public class Position2D implements Position{
    private int line;
    private int column;

    public Position2D(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public List<Position2D> getVoisin() {
        return Arrays.asList(
                new Position2D(line-1,column),
                new Position2D(line +1, column),
                new Position2D(line,column-1),
                new Position2D(line,column+1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position2D that = (Position2D) o;

        if (line != that.line) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = line;
        result = 31 * result + column;
        return result;
    }

    @Override
    public String toString() {
        return "Position2D{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
