package spring.ai.service.impl;

import spring.ai.entity.po.School;
import spring.ai.mapper.SchoolMapper;
import spring.ai.service.ISchoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 校区表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {

}
