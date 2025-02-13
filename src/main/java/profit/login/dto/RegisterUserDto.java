package profit.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;

    private String phone;

    private String birth;

    private Integer point;

    private String nickname;

    // getters and setters here...
    String setEmail(String email){
        this.email = email;
        return this.email;
    }

    String setPassword(String password){
        this.password = password;
        return this.password;
    }

    String setFullName(String fullName){
        this.fullName = fullName;
        return this.fullName;
    }
}