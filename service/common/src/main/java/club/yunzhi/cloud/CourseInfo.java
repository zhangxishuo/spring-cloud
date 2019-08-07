package club.yunzhi.cloud;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CourseInfo {

    private Long id;

    private String name;

    private String type;

    private String icon;

    private String intro;
}
