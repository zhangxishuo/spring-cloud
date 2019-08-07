package club.yunzhi.cloud.repository;

import club.yunzhi.cloud.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
