package yalong.site.frame.panel.client;

import lombok.extern.slf4j.Slf4j;
import yalong.site.cache.AppCache;
import yalong.site.cache.FrameUserSetting;
import yalong.site.frame.bo.ComponentBO;
import yalong.site.frame.bo.ItemBO;
import yalong.site.frame.panel.base.BaseComboBox;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author yaLong
 */
@Slf4j
public class RankFirstBox extends BaseComboBox<ItemBO> {

	public RankFirstBox() {
		this.setItems();
		this.addItemListener(listener());
	}

	/**
	 * @return 带布局的盒子
	 */
	public static ComponentBO builder() {
		RankFirstBox box = new RankFirstBox();
		GridBagConstraints grid = new GridBagConstraints(
				// 第(0,0)个格子
				0, 0,
				// 占1列,占1行
				1, 1,
				//横向占100%长度,纵向占100%长度
				1, 1,
				//居中,组件小的话就两边铺满窗格
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				// 窗格之间的距离
				new Insets(0, 0, 0, 0),
				// 增加组件的首选宽度和高度
				0, 0
		);
		return new ComponentBO(box, grid);
	}

	public void setItems() {
		this.addItem(new ItemBO("RANKED_SOLO_5x5", "单排/双排"));
		this.addItem(new ItemBO("RANKED_FLEX_SR", "灵活组排 5v5"));
		this.addItem(new ItemBO("RANKED_FLEX_TT", "灵活组排 3v3"));
		this.addItem(new ItemBO("RANKED_TFT", "云顶之弈"));
	}

	private ItemListener listener() {
		return e -> {
			if (e.getStateChange() == ItemEvent.SELECTED && AppCache.api != null) {
				ItemBO item = (ItemBO) e.getItem();
				FrameUserSetting.currentRankBO.setFirstRank(item.getValue());
				if (!FrameUserSetting.currentRankBO.isNull()) {
					try {
						AppCache.api.setRank(FrameUserSetting.currentRankBO);
					} catch (Exception ex) {
						log.error("设置rank错误", ex);
					}
				}
			}
		};
	}

}
