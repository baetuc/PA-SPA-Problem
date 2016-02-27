package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cip on 27-Feb-16.
 */
public class Problem {
    private List<Lecturer> lecturers;
    private List<Student> students;

    public Problem() {
        lecturers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Informatii despre profesori: \n\n");
        for(Lecturer lecturer : lecturers) {
            sb.append(lecturer.toString()).append("\n");
        }
        sb.append("\nInformatii despre studenti:\n\n");
        for(Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        sb.append("\nInformatii despre proiecte:\n\n");
        for(Lecturer lecturer : lecturers) {
            for(Project project : lecturer.getProposedProjects()) {
                sb.append(project.toString()).append("\n");
            }
        }
        return sb.toString();
    }





}
