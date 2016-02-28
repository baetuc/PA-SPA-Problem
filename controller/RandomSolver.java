package controller;

import model.Problem;
import model.Project;
import model.Student;

import java.util.List;

/**
 * Created by Cip on 28-Feb-16.
 */
public class RandomSolver extends Solver {

    public RandomSolver(Problem problem) {
        super(problem);
    }

    @Override
    public void solve() {
        List<Student> students = problem.getStudents();
        for (Student student : students) {
            for (Project project : student.getPreferredProjects()) {
                if (project.isFree() && project.getProposingLecturer().isFree()) {
                    student.setAssignedProject(project);
                    project.setLeftCapacity(project.getLeftCapacity() - 1);
                    project.getProposingLecturer().setLeftCapacity(project.getProposingLecturer().getLeftCapacity() - 1);
                    break;
                }
            }
        }
    }

    @Override
    public String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Un cuplaj (neoptimal) este urmatorul: \n\n");
        sb.append(super.printResult());
        return sb.toString();
    }
}
