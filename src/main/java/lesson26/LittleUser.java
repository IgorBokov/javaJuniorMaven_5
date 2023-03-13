package lesson26;

import java.time.LocalDate;
import java.util.Objects;

public class LittleUser {
    private String name;
    private LocalDate dob;

    public LittleUser() {
    }

    public LittleUser(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LittleUser that = (LittleUser) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        return result;
    }
}