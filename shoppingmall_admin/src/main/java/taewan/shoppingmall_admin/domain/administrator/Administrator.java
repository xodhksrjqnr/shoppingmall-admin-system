package taewan.shoppingmall_admin.domain.administrator;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Administrator {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String email;
    private String password;
    @CreatedDate
    private LocalDateTime createdDate;

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
