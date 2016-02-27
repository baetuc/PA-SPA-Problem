package model;

import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by Cip on 25-Feb-16.
 */
public class Student extends Person {
    private List<Project> preferredProjects;
    private Project assignedProject;


    public Student(String firstName, String lastName, String email, List<Project> preferredProjects, Project assignedProject) {
        super(firstName, lastName, email);
        this.preferredProjects = preferredProjects;
        this.assignedProject = assignedProject;
    }

    public Student(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.preferredProjects = null;
        this.assignedProject = null;
    }

    public List<Project> getPreferredProjects() {
        return preferredProjects;
    }

    public void setPreferredProjects(List<Project> preferredProjects) {
        this.preferredProjects = preferredProjects;
    }


    public Project getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
    }

    @Override
    public boolean isFree() {
        return (assignedProject == null);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Student otherStud = (Student) obj;
        return (this.assignedProject.equals(otherStud.getAssignedProject()));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, preferredProjects, assignedProject);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Studentul ").append(firstName).append(" ").append(lastName).append(", ");
        sb.append("cu emailul ").append(email).append(", prefera urmatoarele proiecte: ");
        boolean first = true;
        for (Project project : preferredProjects) {
            if(!first) {
                sb.append(", ").append(project.getTitle());
            }
            else {
                sb.append(project.getTitle());
                first = false;
            }
        }
        if (assignedProject != null) {
            sb.append(".\nAcesta are asignat proiectul cu titlul").append(assignedProject.getTitle()).append(".\n");
        } else {
            sb.append(".\nAcesta nu are asignat niciun proiect.\n");
        }
        return sb.toString();
    }
}
