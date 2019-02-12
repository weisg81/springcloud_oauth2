package pers.weisg.cloud.api.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author weisg
 * @since 2019-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class User  {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    private String name;

    private BigDecimal money;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer isDeleted;

    private Integer age;


}
