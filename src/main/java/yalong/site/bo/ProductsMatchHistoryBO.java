package yalong.site.bo;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import yalong.site.json.Games;

/**
 * 单个玩家的战绩
 *
 * @author WuYi
 */
@Data
public class ProductsMatchHistoryBO {
    private Long accountId;
    private Games games;
}
