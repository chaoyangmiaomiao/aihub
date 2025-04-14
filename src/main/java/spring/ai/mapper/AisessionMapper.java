package spring.ai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import spring.ai.entity.po.Aisession;

import java.util.List;

@Mapper
public interface AisessionMapper extends BaseMapper<Aisession> {

    @Select("select chatid from aisession where type = #{type}")
    List<String> selectChatIds(String type);

    @Insert("insert ignore into aisession(type, chatid) values (#{type}, #{chatid})")
    void addChatHistory(Aisession aiSession);
}
