package club.yunzhi.cloud.entity;

import club.yunzhi.cloud.CourseInfo;
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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer type;

    private String icon;

    private String intro;

    @CreatedDate
    private Calendar createTime;

    @LastModifiedDate
    private Calendar updateTime;

    /**
     * 建造者模式构建用户信息
     */
    public CourseInfo buildCourseInfo() {
        return CourseInfo.builder()
                .id(id)
                .name(name)
                .type(type == 0 ? "免费课" : "实战课")
                .icon(icon)
                .intro(intro)
                .build();
    }
}
