package pers.weisg.cloud.common.core.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 */
public class Query<T> extends Page<T> {
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";
    private static final String ASC_FIELDS = "ascFileds";
    private static final String DESC_FIELDS = "descFileds";
    private static final String IS_ASC = "isAsc";

    public Query(Map<String, Object> params) {
        super(Integer.parseInt(params.getOrDefault(PAGE, 1).toString())
                , Integer.parseInt(params.getOrDefault(LIMIT, 10).toString()));

        String ascFileds = params.getOrDefault(ASC_FIELDS, "").toString();
        if (StringUtils.isNotEmpty(ascFileds)) {
            this.setAsc(ascFileds.split(","));
        }
        String descFileds = params.getOrDefault(DESC_FIELDS, "").toString();
        if (StringUtils.isNotEmpty(descFileds)) {
            this.setDesc(descFileds.split(","));
        }

//        Boolean isAsc = Boolean.parseBoolean(params.getOrDefault(IS_ASC, Boolean.TRUE).toString());
//        this.setAsc(isAsc);

        params.remove(PAGE);
        params.remove(LIMIT);
        params.remove(ASC_FIELDS);
        params.remove(DESC_FIELDS);
//        this.condition(params);
    }
}
