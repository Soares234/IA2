package catchBox;

import agentSearch.Action;
import agentSearch.Problem;
import agentSearch.State;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes

    private Cell goalPosition;
    private List<Action> actions;

    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);

        //TODO - Done
        actions = new LinkedList<Action>() {{
            add(new ActionDown());
            add(new ActionUp());
            add(new ActionRight());
            add(new ActionLeft());
        }};
        this.goalPosition = goalPosition;
    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
        List<S> successors = new LinkedList<>();

        for (Action action : actions) {
            if (action.isValid(state)) {
                S successor = (S) state.clone();
                action.execute(successor);
                successors.add(successor);
            }
        }
        return successors;
    }

    public Cell getGoalPosition() {
        return goalPosition;
    }

    public boolean isGoal(S state) {
        //TODO comParar o state line e column com o o atual catchline e catchol, saber se esta no fim ou não..
        return goalPosition.getLine() == state.getLineCatch() && goalPosition.getColumn() == state.getColumnCatch();
    }
}
