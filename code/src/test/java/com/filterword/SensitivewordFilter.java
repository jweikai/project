package com.filterword;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 敏感词过滤
 * @Project：test
 * @Author : chenming
 * @Date ： 2014年4月20日 下午4:17:15
 * @version 1.0
 */
public class SensitivewordFilter {
	@SuppressWarnings("rawtypes")
	private static Map sensitiveWordMap = null;
	public static int minMatchTYpe = 1;      //最小匹配规则
	public static int maxMatchType = 2;      //最大匹配规则
	
	/**
	 * 构造函数，初始化敏感词库
	 */
	static {
		sensitiveWordMap = new SensitiveWordInit().initKeyWord();
	}
	private static String dealString(String txt) {
		return txt.replaceAll("\\s", "");
	}
	/**
	 * 判断文字是否包含敏感字符
	 * @author chenming 
	 * @date 2014年4月20日 下午4:28:30
	 * @param txt  文字
	 * @param matchType  匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
	 * @return 若包含返回true，否则返回false
	 * @version 1.0
	 */
	public static boolean isContaintSensitiveWord(String txt,int matchType){
		txt = dealString(txt);
		for(int i = 0 ; i < txt.length() ; i++){
			int matchFlag = CheckSensitiveWord(txt, i, matchType, false); //判断是否包含敏感字符
			if(matchFlag > 0){    //大于0存在，返回true
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取文字中的敏感词
	 * @author chenming 
	 * @date 2014年4月20日 下午5:10:52
	 * @param txt 文字
	 * @param matchType 匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
	 * @return
	 * @version 1.0
	 */
	public static Set<String> getSensitiveWord(String txt , int matchType, boolean f){
		txt = dealString(txt);
		Set<String> sensitiveWordList = new HashSet<String>();
		
		for(int i = 0 ; i < txt.length() ; i++){
			int length = CheckSensitiveWord(txt, i, matchType, f);    //判断是否包含敏感字符
			if(length > 0){    //存在,加入list中
				sensitiveWordList.add(txt.substring(i, i+length));
				i = i + length - 1;    //减1的原因，是因为for会自增
			}
		}
		
		return sensitiveWordList;
	}
	
	/**
	 * 替换敏感字字符
	 * @author chenming 
	 * @date 2014年4月20日 下午5:12:07
	 * @param txt
	 * @param matchType
	 * @param replaceChar 替换字符，默认*
	 * @version 1.0
	 */
	public static String replaceSensitiveWord(String txt,int matchType,String replaceChar){
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType, false);     //获取所有的敏感词
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}
		
		return resultTxt;
	}
	
	/**
	 * 获取替换字符串
	 * @author chenming 
	 * @date 2014年4月20日 下午5:21:19
	 * @param replaceChar
	 * @param length
	 * @return
	 * @version 1.0
	 */
	private static String getReplaceChars(String replaceChar,int length){
		String resultReplace = replaceChar;
		for(int i = 1 ; i < length ; i++){
			resultReplace += replaceChar;
		}
		
		return resultReplace;
	}
	
	/**
	 * 检查文字中是否包含敏感字符，检查规则如下：<br>
	 * @author chenming 
	 * @date 2014年4月20日 下午4:31:03
	 * @param txt
	 * @param beginIndex
	 * @param matchType
	 * @return，如果存在，则返回敏感词字符的长度，不存在返回0
	 * @version 1.0
	 */
	@SuppressWarnings({ "rawtypes"})
	private static int CheckSensitiveWord(String txt,int beginIndex,int matchType, boolean f){
		boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
		int matchFlag = 0;     //匹配标识数默认为0
		char word = 0;
		Map nowMap = sensitiveWordMap;		
		for(int i = beginIndex; i < txt.length() ; i++){
			word = txt.charAt(i);
			if ( f && (matchFlag > 0 && (""+word).matches("[^\u4e00-\u9fa5]")) ) {
				matchFlag ++ ;
				continue;
			}
			nowMap = (Map) nowMap.get(word);     //获取指定key
			if(nowMap != null){     //存在，则判断是否为最后一个				
				matchFlag++;     //找到相应key，匹配标识+1 
				if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
					flag = true;       //结束标志位为true   
					if(SensitivewordFilter.minMatchTYpe == matchType){    //最小规则，直接返回,最大规则还需继续查找
						break;
					}
				}
			}
			else{     //不存在，直接返回
				break;
			}
		}
		if(matchFlag < 2 || !flag){        //长度必须大于等于1，为词 
			matchFlag = 0;
		}
		return matchFlag;
	}
	
}
