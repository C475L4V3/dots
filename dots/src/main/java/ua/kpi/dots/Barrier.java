package ua.kpi.dots;

/**
 * @author Myhaylo Kotsyuruba
 * @version v.   08.04.13
 */
public class Barrier {
    private Dot dotA;
    private Dot dotB;

    public Barrier(Dot dotA, Dot dotB) {
        if (       !isCorrectDistance(dotA, dotB)
                || !dotA.isSamePlayer(dotB)
                || !dotA.isDifferentCoordinates(dotB)){
            throw new IllegalArgumentException();
        }
        this.dotA = dotA;
        this.dotB = dotB;
    }

    private boolean isCorrectDistance(Dot dotA, Dot dotB) {
        return (Math.abs(dotA.getX() - dotB.getX()) == 1)
                || (Math.abs(dotA.getY() - dotB.getY()) == 1);
    }

    public boolean isSame(Barrier line) {
        Dot dotA1 = line.dotA;
        Dot dotB1 = line.dotB;
        return (dotA1.equals(dotA) && dotB1.equals(dotB))
                || (dotA1.equals(dotB) && dotB1.equals(dotA));
    }


    @Override
    public Barrier clone() {
        return new Barrier(dotA.clone(), dotB.clone());
    }

    public Dot getDotA() {
        return dotA.clone();
    }

    public Dot getDotB() {
        return dotB.clone();
    }

    public boolean canConnect(Barrier previousLine) {
        return dotA.equals(previousLine.dotB);
    }

    public boolean contain(Dot dot) {
        return (dotA.equals(dot) || dotB.equals(dot));
    }
}
