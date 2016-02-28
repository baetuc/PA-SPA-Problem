package controller;

import com.google.common.base.Preconditions;
import model.Lecturer;
import model.Problem;
import model.Project;
import model.Student;
import org.apache.commons.collections4.ListUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Cip on 27-Feb-16.
 */
public class StabilStudentSolver extends Solver {

    public StabilStudentSolver(Problem problem) {
        super(problem);
    }

    private void removeImpossibleAssignmentsFromStudents() {
        List<Student> students = problem.getStudents();
        for (Student student : students) {
            if(student.getPreferredProjects() == null) {
                System.out.println(student.getFirstName() + "null");
            }
            // safe removing elements while iterating
            for (Iterator<Project> iterator = student.getPreferredProjects().iterator(); iterator.hasNext(); ) {
                Project project = iterator.next();
                // if the proposing lecturer of the project doesn't have the student in his list,
                // remove the project from student's list
                if(!project.getProposingLecturer().getPreferredStudents().contains(student)) {
                    iterator.remove();
                }
            }
        }
    }

    private void subscribeStudentToProject(Student student, Project project) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(project);

        Lecturer lecturer = project.getProposingLecturer();
        lecturer.setLeftCapacity(lecturer.getLeftCapacity() - 1);
        project.setLeftCapacity(project.getLeftCapacity() - 1);
        student.setAssignedProject(project);
        project.getAssignedStudents().add(student);
    }

    private void unsubscribeStudentFromProject(Student student, Project project) {
        Preconditions.checkNotNull(student);
        Preconditions.checkNotNull(project);

        Lecturer lecturer = project.getProposingLecturer();
        lecturer.setLeftCapacity(lecturer.getLeftCapacity() + 1);
        project.setLeftCapacity(project.getLeftCapacity() + 1);
        project.getAssignedStudents().remove(student);
        student.getPreferredProjects().remove(project);
        student.setAssignedProject(null);

    }

    private Student getWorstStudentAssignedToProject(Project project) {
        Lecturer lecturer = project.getProposingLecturer();
        List<Student> intersection = ListUtils.intersection(lecturer.getPreferredStudents(), project.getAssignedStudents());
        return intersection.get(intersection.size() - 1);
    }

    private Student getWorstStudentAssignedToLecturer(Lecturer lecturer) {
        List<Student> intersection = ListUtils.intersection(lecturer.getPreferredStudents(), lecturer.getAssignedStudents());
        return intersection.get(intersection.size() - 1);
    }

    @Override
    public void solve() {
        removeImpossibleAssignmentsFromStudents();
        boolean finished = false;
        while (!finished) {
            finished = true;
            for (Student student : problem.getStudents()) {
                if (student.isFree() && (student.getPreferredProjects().size() > 0)) {
                    finished = false;
                    Project mostDesiredProject = student.getPreferredProjects().get(0);
                    Lecturer projectOwner = mostDesiredProject.getProposingLecturer();
                    subscribeStudentToProject(student, mostDesiredProject);
                    if (mostDesiredProject.getLeftCapacity() < 0) {
                        Student worstStudentAssignedAtProject = getWorstStudentAssignedToProject(mostDesiredProject);
                        unsubscribeStudentFromProject(worstStudentAssignedAtProject, mostDesiredProject);
                    } else if (projectOwner.getLeftCapacity() < 0) {
                        Student worstStudentAssignedToLecturer = getWorstStudentAssignedToLecturer(projectOwner);
                        unsubscribeStudentFromProject(worstStudentAssignedToLecturer,
                                worstStudentAssignedToLecturer.getAssignedProject());
                    }
                    // TODO: Check for consistency. Is there any case when algorithm from paper should be implemented ad-literam?
                }
            }
        }
    }


    @Override
    public String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuplajul stabil, optimal din perspectiva studentilor este urmatorul: \n\n");
        sb.append(super.printResult());
        return sb.toString();
    }
}
