package club.yunzhi.cloud.entity;

import club.yunzhi.cloud.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    @CreatedDate
    private Calendar createTime;

    @LastModifiedDate
    private Calendar updateTime;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * 建造者模式构建课程信息
     */
    public UserInfo buildUserInfo() {
        return UserInfo.builder()
                .id(id)
                .username(username)
                .email(email)
                .build();
    }
}
