package yalong.site.cache;

import yalong.site.bo.ChampionBO;
import yalong.site.bo.LOLItemBO;
import yalong.site.bo.SummonerSpellsBO;
import yalong.site.services.lcu.LinkLeagueClientApi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yalong
 */
public class AppCache {
	public static LinkLeagueClientApi api;
	public static ArrayList<ChampionBO> allChampion = new ArrayList<>();
	public static ArrayList<String> garbageWordList = new ArrayList<>();
	public static String lastGarbageWord;
	public static ArrayList<String> resultPanelMsgList = new ArrayList<>();
	public static Set<Integer> hotKeyCode = new HashSet<>();
	public static Set<Integer> commonKeyCode = new HashSet<>();

	/**
	 * 召唤师技能信息
	 *
	 * @since 7.3
	 */
	public static ArrayList<SummonerSpellsBO> summonerSpellsList = new ArrayList<>();
	/**
	 * 召唤师技能信息
	 *
	 * @since 7.3
	 */
	public static ArrayList<LOLItemBO> items = new ArrayList<>();
}
