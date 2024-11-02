package taewan.shoppingmall_admin.domain.administrator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrator {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String email;
    private String password;

    public Administrator() {}

    public Administrator(int id, String userId, String email, String password) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
