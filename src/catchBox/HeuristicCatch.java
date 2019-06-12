package catchBox;

import agentSearch.Heuristic;

public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
        //TODO - Done
        return state.computeObjectDistances(problem.getGoalPosition());

    }

    @Override
    public String toString() {
        //TODO - Done
        return "Distance between objets";
    }
}