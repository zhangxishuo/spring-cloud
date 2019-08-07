package club.yunzhi.cloud.vo;

import club.yunzhi.cloud.CourseInfo;
import club.yunzhi.cloud.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;

    private List<CourseInfo> courseInfos;
}
