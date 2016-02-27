package application;

import model.Lecturer;
import model.Problem;
import model.Project;
import model.Student;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Cip on 27-Feb-16.
 *
 */
public class Main {
    private static Problem recreateExample() {
        Problem problem = new Problem();
        Project[] projects = new Project[8];
        projects[0] = new Project("P1", 2);
        projects[1] = new Project("P2", 1);
        projects[2] = new Project("P3", 1);
        projects[3] = new Project("P4", 1);
        projects[4] = new Project("P5", 1);
        projects[5] = new Project("P6", 1);
        projects[6] = new Project("P7", 1);
        projects[7] = new Project("P8", 1);

        Student[] students = new Student[7];
        students[0] = new Student("S1", "", "1@google.com", Arrays.asList(projects[0], projects[6]), null);
        students[1] = new Student("S2", "", "2@google.com", Arrays.asList(projects[0], projects[1], projects[2], projects[3],
                projects[4], projects[5]), null);
        students[2] = new Student("S3", "", "3@google.com", Arrays.asList(projects[1], projects[0], projects[3]), null);
        students[3] = new Student("S4", "", "4@google.com", Collections.singletonList(projects[1]), null);
        students[4] = new Student("S5", "", "5@google.com", Arrays.asList(projects[0], projects[1], projects[2], projects[3]), null);
        students[5] = new Student("S6", "", "6@google.com", Arrays.asList(projects[1], projects[2], projects[3], projects[4],
                projects[5]), null);
        students[6] = new Student("S7", "", "7@google.com", Arrays.asList(projects[4], projects[2], projects[7]), null);


        Lecturer[] lecturers = new Lecturer[3];
        lecturers[0] = new Lecturer("L1", "", "l1@gmail.com", 3, Arrays.asList(projects[0], projects[1], projects[2]),
                Arrays.asList(students[6], students[3], students[0], students[2], students[1], students[4], students[5]));
        lecturers[1] = new Lecturer("L2", "", "l2@gmail.com", 2, Arrays.asList(projects[3], projects[4], projects[5]),
                Arrays.asList(students[2], students[1], students[5], students[6], students[4]));
        lecturers[2] = new Lecturer("L2", "", "l2@gmail.com", 2, Arrays.asList(projects[6], projects[7]),
                Arrays.asList(students[0], students[6]));

        projects[0].setProposingLecturer(lecturers[0]);
        projects[1].setProposingLecturer(lecturers[0]);
        projects[2].setProposingLecturer(lecturers[0]);
        projects[3].setProposingLecturer(lecturers[1]);
        projects[4].setProposingLecturer(lecturers[1]);
        projects[5].setProposingLecturer(lecturers[1]);
        projects[6].setProposingLecturer(lecturers[2]);
        projects[7].setProposingLecturer(lecturers[2]);

        problem.setStudents(Arrays.asList(students));
        problem.setLecturers(Arrays.asList(lecturers));

        return problem;
    }

    public static void main(String[] args) {
        Problem problem = recreateExample();
        System.out.println(problem.toString());
    }
}
