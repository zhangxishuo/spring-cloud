package club.yunzhi.cloud.repository;

import club.yunzhi.cloud.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    List<UserCourse> findAllByUserId(Long userId);
}
