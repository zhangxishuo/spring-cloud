package club.yunzhi.cloud.service;

import club.yunzhi.cloud.UserInfo;
import club.yunzhi.cloud.request.UserRequest;
import club.yunzhi.cloud.response.UserCourseInfo;

public interface UserService {

    UserInfo createUser(UserRequest userRequest);

    UserInfo getUserInfo(Long id);

    UserCourseInfo getUserCourseInfo(Long id);
}
