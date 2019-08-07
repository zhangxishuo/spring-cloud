package club.yunzhi.cloud.service.impl;

import club.yunzhi.cloud.CourseInfo;
import club.yunzhi.cloud.UserInfo;
import club.yunzhi.cloud.client.CourseClient;
import club.yunzhi.cloud.entity.User;
import club.yunzhi.cloud.entity.UserCourse;
import club.yunzhi.cloud.repository.UserCourseRepository;
import club.yunzhi.cloud.repository.UserRepository;
import club.yunzhi.cloud.request.UserRequest;
import club.yunzhi.cloud.response.UserCourseInfo;
import club.yunzhi.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final CourseClient courseClient;
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;

    @Autowired
    public UserServiceImpl(CourseClient courseClient, UserRepository userRepository, UserCourseRepository userCourseRepository) {
        this.courseClient = courseClient;
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public UserInfo createUser(UserRequest userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());

        if (null != user) {
            return new UserInfo();
        }

        user = userRepository.save(new User(userRequest.getUsername(), userRequest.getEmail()));

        return user.buildUserInfo();
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return user.buildUserInfo();
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        UserInfo userInfo = this.getUserInfo(id);
        List<CourseInfo> courseInfos = Collections.emptyList();

        List<UserCourse> userCourses = userCourseRepository.findAllByUserId(id);

        if (!CollectionUtils.isEmpty(userCourses)) {
            List<Long> ids = userCourses.stream().map(UserCourse::getCourseId).collect(Collectors.toList());
            courseInfos = courseClient.getCourseInfo(ids);
        }

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
