package spring.ai.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring.ai.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
