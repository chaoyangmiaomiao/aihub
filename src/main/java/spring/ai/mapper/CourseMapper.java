package spring.ai.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.ai.entity.po.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 学科表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
