package co.edu.udea.calidad.citasalud_automatizacion.models;

public class RegisterRequest {
    private String dni;
    private String password;
    private String firstName;
    private String lastName;
    private String department;
    private String city;
    private String address;
    private String email;
    private String numberPhone;

    public RegisterRequest() {}

    public RegisterRequest(String dni, String password, String firstName, String lastName,
                           String department, String city, String address, String email, String numberPhone) {
        this.dni = dni;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.city = city;
        this.address = address;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
