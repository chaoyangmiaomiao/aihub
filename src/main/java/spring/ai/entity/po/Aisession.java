package spring.ai.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2025-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("aisession")
@NoArgsConstructor
@AllArgsConstructor
public class Aisession implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("type")
    private String type;

    @TableField("chatid")
    private String chatid;
}
