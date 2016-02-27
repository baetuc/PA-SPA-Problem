package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * Created by Cip on 25-Feb-16.
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String email;

    public Person(String firstName, String lastName, String email) {
        Preconditions.checkNotNull(firstName, "First name must not be null.");
        Preconditions.checkNotNull(lastName, "Last name must not be null.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, null);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public abstract boolean isFree();

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        Person that = (Person) obj;
        return (firstName.equals(that.getFirstName()) && lastName.equals(that.getLastName()));
    }

}
