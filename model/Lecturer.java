package model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Cip on 26-Feb-16.
 */
public class Lecturer extends Person {
    private int maxCapacity;
    private int leftCapacity;
    private List<Project> proposedProjects;
    private List<Student> preferredStudents;


    public Lecturer(String firstName, String lastName, String email, int maxCapacity, List<Project> proposedProjects,
                    List<Student> preferredStudents) {
        super(firstName, lastName, email);
        Preconditions.checkArgument(maxCapacity > 0, "Maximum capacity must be greater than zero.");
        this.maxCapacity = maxCapacity;
        this.leftCapacity = maxCapacity;
        this.proposedProjects = proposedProjects;
        this.preferredStudents = preferredStudents;
        if(proposedProjects != null) {
            for (Project project : proposedProjects) {
                project.setProposingLecturer(this);
            }
        }
    }

    public Lecturer(String firstName, String lastName, int maxCapacity) {
        this(firstName, lastName, null, maxCapacity, null, null);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(int leftCapacity) {
        this.leftCapacity = leftCapacity;
    }

    public List<Project> getProposedProjects() {
        return proposedProjects;
    }

    public void setProposedProjects(List<Project> proposedProjects) {
        Preconditions.checkNotNull(proposedProjects);
        this.proposedProjects = proposedProjects;
        for (Project project : proposedProjects) {
            project.setProposingLecturer(this);
        }
    }

    public List<Student> getPreferredStudents() {
        return preferredStudents;
    }

    public void setPreferredStudents(List<Student> preferredStudents) {
        this.preferredStudents = preferredStudents;
    }

    public List<Student> getAssignedStudents() {
        HashSet<Student> students = new HashSet<>();
        for(Project project : proposedProjects) {
            students.addAll(project.getAssignedStudents());
        }
        return new ArrayList<>(students);
    }

    @Override
    public boolean isFree() {
        return leftCapacity > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Lecturer)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Lecturer that = (Lecturer) obj;
        return this.proposedProjects.containsAll(that.getProposedProjects());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, proposedProjects, preferredStudents);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Profesorul ").append(firstName).append(" ").append(lastName).append("cu capacitatea maxima ");
        sb.append(maxCapacity).append(" si cu emailul ");
        sb.append(email).append(", are urmatoarele proiecte propuse: ");
        boolean first = true;
        for (Project project : proposedProjects) {
            if (!first) {
                sb.append(", ");
            }

            sb.append(project.getTitle());
            first = false;

        }

        sb.append(".\nStudentii preferati de el sunt, in aceasta ordine: ");
        first = true;
        for (Student student : preferredStudents) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(student.getFirstName()).append(" ").append(student.getLastName());
        }
        sb.append(".\n");
        return sb.toString();
    }

}
