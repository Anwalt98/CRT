package TestProject.User;

import Framework.BaseTableModel;
import java.util.Objects;

public class User extends BaseTableModel {
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public void setUniqueField(){
        uniqueField = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
