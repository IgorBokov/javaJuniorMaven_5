package lesson25;

import java.time.LocalDate;
import java.util.Objects;


public class User {
    private String firsName;
    private String lastsName;
    private String gender;
    private String email;
    private LocalDate dob;
    private String phone;
    private String country;

    public User() {
    }

    public User(String firsName, String lastsName, String gender, String email, LocalDate dob, String phone, String country) {
        this.firsName = firsName;
        this.lastsName = lastsName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.country = country;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastsName() {
        return lastsName;
    }

    public void setLastsName(String lastsName) {
        this.lastsName = lastsName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(firsName, user.firsName)) return false;
        if (!Objects.equals(lastsName, user.lastsName)) return false;
        if (!Objects.equals(gender, user.gender)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(dob, user.dob)) return false;
        if (!Objects.equals(phone, user.phone)) return false;
        return Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        int result = firsName != null ? firsName.hashCode() : 0;
        result = 31 * result + (lastsName != null ? lastsName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firsName='" + firsName + '\'' +
                ", lastsName='" + lastsName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

