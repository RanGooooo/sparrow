package com.xin.sparrow.common.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalThreadLocalUtil {

	public final static String JING_DIAN_JING_JING = "0.000000";

	public final static String PATTERN_00000000 = "0.000000";

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
		throw new Exception("Can't find Time Format");
	}

	public static String replaceTailZero(BigDecimal str) {
		if (str == null) {
			return null;
		}
		return replaceTailZero(str.toString());
	}

	public static void main(String[] args) {
		System.out.println(replaceTailZero("2.0123130000"));
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
