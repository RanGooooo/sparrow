package com.xin.common.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DxDecimalThreadLocalUtil {

	public final static String JING_DIAN_JING_JING = "#.##";

	public final static String PATTERN_00000000 = "00000000";
	
	public final static String PATTERN_00 = "00";

	private static ThreadLocal<DecimalFormat> THREADLOCAL_JING_DIAN_JING_JING = new ThreadLocal<DecimalFormat>() {
		@Override
		protected DecimalFormat initialValue() {
			return new DecimalFormat(JING_DIAN_JING_JING);
		}
	};

	private static ThreadLocal<DecimalFormat> THREADLOCAL_PATTERN_00000000 = new ThreadLocal<DecimalFormat>() {
		@Override
		protected DecimalFormat initialValue() {
			return new DecimalFormat(PATTERN_00000000);
		}
	};
	
	private static ThreadLocal<DecimalFormat> THREADLOCAL_PATTERN_00 = new ThreadLocal<DecimalFormat>() {
		@Override
		protected DecimalFormat initialValue() {
			return new DecimalFormat(PATTERN_00);
		}
	};

	/*
	 * ---------------------
		0.055=0.06
		0.065=0.06
		0.075=0.08
		0.085=0.08
	 * ---------------------
	 * @param obj
	 * @return
	 * @throws Exception String
	 * ---------------------------
	 * 开发人员: zhaohongyu
	 * 时间: 2021年10月14日 下午2:16:16
	 * 版本: v1.0
	 * ---------------------------
	 */
	public static String format_JING(Object obj) throws Exception {
		return format(obj, JING_DIAN_JING_JING);
	}

	public static String format(Object obj, String pattern) throws Exception {
		if (obj == null) {
			return null;
		}
		DecimalFormat decimalFormat = getFormat(pattern);
		return decimalFormat.format(obj);
	}

	private static DecimalFormat getFormat(String pattern) throws Exception {
		if (JING_DIAN_JING_JING.equals(pattern)) {
			return THREADLOCAL_JING_DIAN_JING_JING.get();
		}
		if (PATTERN_00000000.equals(pattern)) {
			return THREADLOCAL_PATTERN_00000000.get();
		}
		if (PATTERN_00.equals(pattern)) {
			return THREADLOCAL_PATTERN_00.get();
		}
		throw new Exception("Can't find Time Format");
	}

	public static String replaceTailZero(BigDecimal str) {
		if (str == null) {
			return null;
		}
		return replaceTailZero(str.toString());
	}

	public static void main(String[] args) throws Exception {
		System.out.println(DxDecimalThreadLocalUtil.format(100, DxDecimalThreadLocalUtil.PATTERN_00));
	}

	public static String replaceTailZero(String str) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		str = str.replaceAll("0+$", "");
		int length = str.length();
		int lastIndexOf = str.lastIndexOf(".");
		if (lastIndexOf == (length - 1)) {
			return str.substring(0, lastIndexOf);
		}
		return str;
	}

	public static BigDecimal siSheWuRu6(String str) {
		return siSheWuRu6(new BigDecimal(str));
	}
	
	public static BigDecimal siSheWuRu6(BigDecimal str) {
		return str.setScale(6, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal siSheWuRu(int decimalPlaces, BigDecimal str) {
		return str.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
	}

}
