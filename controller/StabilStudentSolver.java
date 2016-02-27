package controller;

import model.Problem;

/**
 * Created by Cip on 27-Feb-16.
 */
public class StabilStudentSolver extends Solver {

    public StabilStudentSolver(Problem problem) {
        super(problem);
    }

    @Override
    public void solve() {

    }

    @Override
    public String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rezultatul optimal din punctul de vedere al studentilor: \n\n");
        sb.append(super.printResult());
        return sb.toString();
    }
}
