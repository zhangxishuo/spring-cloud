package club.yunzhi.cloud.controller;

import club.yunzhi.cloud.UserInfo;
import club.yunzhi.cloud.request.UserRequest;
import club.yunzhi.cloud.response.UserCourseInfo;
import club.yunzhi.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserInfo createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("{id}")
    public UserInfo getUserInfo(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

    @GetMapping("with-course/{id}")
    public UserCourseInfo getUserCourseInfo(@PathVariable Long id) {
        return userService.getUserCourseInfo(id);
    }
}
