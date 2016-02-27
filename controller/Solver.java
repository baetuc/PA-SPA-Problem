package controller;

import model.Problem;
import model.Student;

/**
 * Created by Cip on 27-Feb-16.
 */
public abstract class Solver {
    protected Problem problem;

    public Solver(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public abstract void solve();

    public String printResult() {
        StringBuilder sb = new StringBuilder();
        for(Student student : problem.getStudents()) {
            sb.append("Studentul ").append(student.getFirstName()).append(" ").append(student.getLastName());
            if(student.getAssignedProject() != null) {
                sb.append(" are asignat proiectul ").append(student.getAssignedProject().getTitle()).append(".\n");
            }
            else {
                sb.append("nu are asignat niciun proiect.\n");
            }
        }
        return sb.toString();
    }

}
