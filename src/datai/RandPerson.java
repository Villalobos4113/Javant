package datai;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Fernando Villalobos Betancourt
 *
 */

public class RandPerson {

    // Attributes

    private final String[] data;

    // Constructors

    public RandPerson() {
        data = Datai.fullPerson();
    }

    public RandPerson(char gender) {
        data = Datai.fullPerson(gender);
    }

    // Equals & HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && Objects.requireNonNull(o).getClass() == String.class) return o.equals(data[6]);
        if (o == null || getClass() != o.getClass()) return false;
        RandPerson that = (RandPerson) o;
        return Objects.equals(data[5], that.data[5]);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    // To String

    @Override
    public String toString() {
        return "{Full Name: " + data[0] +
                ", Gender: " + data[3] +
                ", Age: " + data[4] +
                ", Born: " + data[5] +
                ", CURP: " + data[6] +
                ", RFC: " + data[7] +
                ", Phone: " + data[8] +
                ", Email: " + data[9] +
                ", Address: " + data[10] + "}";
    }

    // Getters

    public String getFullName() {
        return data[0];
    }

    public String getName() {
        return data[1];
    }

    public String getSurname() {
        return data[2];
    }

    public String getGender() { return data[3]; }

    public String getAge() {
        return data[4];
    }

    public String getBorn() {
        return data[5];
    }

    public String getCurp() {
        return data[6];
    }

    public String getRfc() {
        return data[7];
    }

    public String getPhone() {
        return data[8];
    }

    public String getEmail() {
        return data[9];
    }

    public String getAddress() {
        return data[10];
    }
}