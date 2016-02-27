package model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cip on 25-Feb-16.
 */
public class Project {
    private String title;
    private int leftCapacity;
    private int maxCapacity;
    private Lecturer proposingLecturer;
    private List<Student> assignedStudents;


    public Project(String title, int maxCapacity, Lecturer proposingLecturer) {
        Preconditions.checkNotNull(title, "Title cannot be null.");
        Preconditions.checkArgument(maxCapacity > 0, "Maximum capacity cannot be zero.");
        // Preconditions.checkNotNull(proposingLecturer, "Proposing lecturer cannot be null.");

        this.title = title;
        this.maxCapacity = maxCapacity;
        this.leftCapacity = maxCapacity;
        this.proposingLecturer = proposingLecturer;
        // at the construct time, the assigned students list must be empty.
        this.assignedStudents = new ArrayList<>();
    }

    public Project(String title, int maxCapacity) {
        this(title, maxCapacity, null);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(int capacity) {
        this.leftCapacity = capacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Lecturer getProposingLecturer() {
        return proposingLecturer;
    }

    public void setProposingLecturer(Lecturer proposingLecturer) {
        this.proposingLecturer = proposingLecturer;
    }


    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(List<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }


    public boolean isFree() {
        return (leftCapacity > 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Project)) {
            return false;
        }
        Project that = (Project) obj;
        return (this.title.equals(that.getTitle()) && this.maxCapacity == that.getMaxCapacity() &&
                this.proposingLecturer.equals(that.getProposingLecturer()));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, leftCapacity, proposingLecturer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proiectul ").append(title).append(" are capacitatea maxima ").append(maxCapacity);
        return sb.toString();
    }

}
