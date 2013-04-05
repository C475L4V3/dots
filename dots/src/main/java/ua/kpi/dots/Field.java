package ua.kpi.dots;

public class Field {

    public static char EMPTY_CELL = '∙';
    public static char EMPTY_LINE_PLACE = ' ';

    private int size;
    Dot[][] dots;

    public Field(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        dots = new Dot[size][size];
    }

    public int getSize() {
        return size;
    }

    public void placeDot(int x, int y, Dot dot) {
        if (isValidPosition(x, y)) {
            dots[x][y] = dot;
        } else {
            throw new IllegalArgumentException();
        }

    }

    private boolean isValidPosition(int x, int y) {
        return (x < size) && (x >= 0) && (y < size) && (y >= 0) && isFree(x, y);
    }

    public boolean isFree(int x, int y) {
        return (dots[x][y] == null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < size*2 - 1; row++) {
            stringBuilder.append(buildLine(row));
        }
        return stringBuilder.toString();
    }

    private String buildLine(int row) {
        StringBuilder line = new StringBuilder();
        for (int column = 0; column < size*2 - 1; column++) {
            line.append(selectDotsSymbol(column, row));
        }
        line.append("\n");
        return line.toString();
    }

    private String selectDotsSymbol(int column, int row) {
        if(column%2 == 0 && row%2 == 0) {
            int x = column/2;
            int y = row/2;
            if (dots[x][y] == null) {
                return String.valueOf(EMPTY_CELL);
            } else {
                return dots[x][y].toString();
            }
        }
        return String.valueOf(EMPTY_LINE_PLACE); // Place for lines
    }

    public boolean isAvailableMove() {
        for (Dot[] dotRow : dots) {
            for (Dot dot : dotRow) {
                if (dot == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Dot[] findAccessiblyDots(Dot dot) {
        Dot[] result = new Dot[8];
        /* TODO написати пошук достуних точок в такому порядку:
         *
         * 1 0 7
         * 2 ● 6
         * 3 4 5
         */


        return result;
    }
}
