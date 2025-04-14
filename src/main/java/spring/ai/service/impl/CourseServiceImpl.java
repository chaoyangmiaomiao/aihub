package spring.ai.service.impl;

import spring.ai.entity.po.Course;
import spring.ai.mapper.CourseMapper;
import spring.ai.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学科表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
