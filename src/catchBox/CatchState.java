package catchBox;

import agentSearch.Action;
import agentSearch.State;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes


    protected int[][] matrix;
    protected int lineCatch;
    protected int columnCatch;
    protected int lineGoal;
    protected int columnGoal;

    public CatchState(int[][] matrix) {
        //TODO
        this.matrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (matrix[i][j] == Properties.CATCH) {
                    lineCatch = i;
                    columnCatch = j;
                }
            }
        }
    }

    public void executeAction(Action action) {
        action.execute(this);
        fireUpdatedEnvironment();

            }

    public double computeObjectDistances(Cell goalPosition) {
        return Math.abs(goalPosition.getLine() - lineCatch)
                + Math.abs(goalPosition.getColumn() - columnCatch);

    }

    public boolean canMoveLeft() {
        //TODO-----------------Mesmo que canMoveRight()--------------------------------------
        if (columnCatch == 0 || matrix[lineCatch][columnCatch - 1] == Properties.WALL)
            return false;
        return true;
    }

    public boolean canMoveDown() {
        //  TODO -------------------------Se for sair da matriz ou o bloco NÃO for vazio, devolve false-----------------------------------
        if (lineCatch == matrix.length - 1 || matrix[lineCatch + 1][columnCatch] == Properties.WALL) {
            return false;
        }
        return true;

    }

    public boolean canMoveRight() {
        //TODO------------------------Mesmo que em canMoveRight()--------------------------------
        if (columnCatch == matrix[lineCatch].length - 1 || matrix[lineCatch][columnCatch + 1] == Properties.WALL) {
            return false;
        }
        return true;
    }

    public boolean canMoveUp() {
        //TODO---------------Mesmo que em canMoveDown()--------------------------
        if (lineCatch == 0 || matrix[lineCatch - 1][columnCatch] == Properties.WALL) {
            return false;
        }
        return true;
    }

    public void moveUp() {
        //TODO -----------Verifica se se consegue mexer, se sim siga -------------------

        setCellCatch(lineCatch - 1, columnCatch);

    }

    public void moveRight() {
        //TODO ---Same----------

        setCellCatch(lineCatch, columnCatch + 1);
    }

    public void moveDown() {
        //TODO SameSame

        setCellCatch(lineCatch + 1, columnCatch);
    }

    public void moveLeft() {
        //TODO SameSameSame

        setCellCatch(lineCatch, columnCatch - 1);
    }

    public int getNumBox() {
        //TODO
        return 0;
    }

    public int getLineCatch() {
        return lineCatch;
    }

    public int getColumnCatch() {
        return columnCatch;
    }

    public void setCellCatch(int line, int column) {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        lineCatch = line;
        columnCatch = column;
        matrix[lineCatch][columnCatch] = Properties.CATCH;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setGoal(int line, int column) {
        //TODO - Done
        lineGoal = line;
        columnGoal = column;
    }

    public int getSteps() {
        //TODO
        return 0;
    }

    public int getSize() {
        return matrix.length;
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        //TODO - Done
        return new CatchState(matrix);
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }

}
