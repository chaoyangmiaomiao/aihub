package spring.ai.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.ai.entity.po.School;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 校区表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Mapper
public interface SchoolMapper extends BaseMapper<School> {

}
