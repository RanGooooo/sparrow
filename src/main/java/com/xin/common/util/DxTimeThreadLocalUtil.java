package com.xin.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ---------------------------
 * 通过奇安信代码扫描 
 * ---------------------------
 * 开发人员: zhaohongyu
 * 时间: 2020年6月20日 下午9:24:30
 * 版本: v1.0
 * ---------------------------
 */
public class DxTimeThreadLocalUtil {

	public final static String PATTERN_DATE = "yyyy-MM-dd";
    
    public final static String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";
    
    public final static String PATTERN_TIME_NO_SECOND = "yyyy-MM-dd HH:mm";
    
    public final static String yyyyMMdd = "yyyyMMdd";
    
    public final static String yyyyMM = "yyyyMM";
    
    public final static String HHmmss = "HHmmss";
    
    public final static String yyMMdd = "yyMMdd";
    
    public final static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    
    public final static String yyyyDianMMDiandd = "yyyy.MM.dd";
    
    public final static String yyyyGangMM = "yyyy-MM";
    
    public final static String yyGangMMGangdd = "yy-MM-dd";
    
    public final static String yyMM = "yyMM";
    
    public final static String yyyyMMddHHmmssGang = "yyyyMMddHHmmss-";
    
    public final static String yyyyXieGangMMXieGangdd = "yyyy/MM/dd";
    
    public final static String yyyy="yyyy";
    
    public final static String yy= "yy";
    
    public final static String yyyy_N_MM_Y_dd_R= "yyyy年MM月dd日";
    
    public final static String yyyy_N_MM_Y= "yyyy年MM月";
    
    public final static String yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M= "yyyy年MM月dd日  HH时mm分ss秒";
    
    private static ThreadLocal<DateFormat> THREADLOCAL_yyyy_N_MM_Y= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyy_N_MM_Y);
	    }
	};
    
    private static ThreadLocal<DateFormat> THREADLOCAL_yyyy_N_MM_Y_dd_R= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyy_N_MM_Y_dd_R);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yy= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yy);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyy= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyy);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyXieGangMMXieGangdd= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyXieGangMMXieGangdd);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyMMddHHmmssGang= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyMMddHHmmssGang);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyMM= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyMM);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyGangMMGangdd= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyGangMMGangdd);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyGangMM= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyGangMM);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyDianMMDiandd= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyDianMMDiandd);
	    }
	};
    
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyMMddHHmmss= new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyMMddHHmmss);
	    }
	};
	    
	private static ThreadLocal<DateFormat> THREADLOCAL_PATTERN_DATE = new ThreadLocal<DateFormat>() {
		    @Override
		    protected DateFormat initialValue() {
		        return new SimpleDateFormat(PATTERN_DATE);
		    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_PATTERN_TIME = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(PATTERN_TIME);
	    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_PATTERN_TIME_NO_SECOND = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(PATTERN_TIME_NO_SECOND);
	    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyMMdd = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyMMdd);
	    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyyMM = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyyMM);
	    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_HHmmss = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(HHmmss);
	    }
	};
	private static ThreadLocal<DateFormat> THREADLOCAL_yyMMdd = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyMMdd);
	    }
	};
	
	private static ThreadLocal<DateFormat> THREADLOCAL_yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M = new ThreadLocal<DateFormat>() {
	    @Override
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat(yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M);
	    }
	};
	
	
	public static void main(String[] args) throws Exception {
		System.out.println(format(new Date(), yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M));
	}
	
	
	

	public static String formatDate(Date date)  throws Exception{
		if(date==null) {
			return null;
		}
		return format(date, PATTERN_DATE);
	}
	
	public static String formatTime(Date date)  throws Exception{
		if(date==null) {
			return null;
		}
		return format(date,PATTERN_TIME);
	}
	
	public static String formatTime(String source) throws Exception{
		if(source==null||"".equals(source)) {
			return source;
		}
		Date date = parse(source, PATTERN_TIME);
	  	return formatTime(date);
	 }
	
	public static String format(String date,String pattern) throws Exception{
		Date parse = parse(date, pattern);
		return format(parse, pattern);
	}
	
	public static String formatEmpty(Date date,String pattern) throws Exception{
		if(date==null) {
			return "";
		}
		return format(date, pattern);
	}
	
	public static String format(Date date,String pattern) throws Exception{
		if(date==null) {
			return null;
		}
		DateFormat dateFormat = getFormat(pattern);
		return dateFormat.format(date);
	}
	//==============================================================
	public static Date parseDate(String source) throws Exception {
		if(source==null||"".equals(source)) {
			return null;
		}
		return parse(source, PATTERN_DATE);
	}
	public static Date parseTime(String source) throws Exception {
		if(source==null||"".equals(source)) {
			return null;
		}
		return parse(source, PATTERN_TIME);
	}
	public static Date parse(String source,String pattern) throws Exception {
		if(source==null||"".equals(source)) {
			return null;
		}
		DateFormat dateFormat = getFormat(pattern);
		return dateFormat.parse(source);
	}
	
	private static DateFormat getFormat(String pattern) throws Exception {
		if(PATTERN_DATE.equals(pattern)) {
			return THREADLOCAL_PATTERN_DATE.get();
		}

		if(PATTERN_TIME.equals(pattern)) {
			return THREADLOCAL_PATTERN_TIME.get();
		}

		if(PATTERN_TIME_NO_SECOND.equals(pattern)) {
			return THREADLOCAL_PATTERN_TIME_NO_SECOND.get();
		}

		if(yyyyMMdd.equals(pattern)) {
			return THREADLOCAL_yyyyMMdd.get();
		}
		
		if(yyyyMM.equals(pattern)) {
			return THREADLOCAL_yyyyMM.get();
		}

		if(HHmmss.equals(pattern)) {
			return THREADLOCAL_HHmmss.get();
		}
		
		if(yyMMdd.equals(pattern)) {
			return THREADLOCAL_yyMMdd.get();
		}
		
		if(yyyyMMddHHmmss.equals(pattern)) {
			return THREADLOCAL_yyyyMMddHHmmss.get();
		}
		
		if(yyyyDianMMDiandd.equals(pattern)) {
			return THREADLOCAL_yyyyDianMMDiandd.get();
		}
		
		if(yyyyGangMM.equals(pattern)) {
			return THREADLOCAL_yyyyGangMM.get();
		}
		
		if(yyGangMMGangdd.equals(pattern)) {
			return THREADLOCAL_yyGangMMGangdd.get();
		}
		
		if(yyMM.equals(pattern)) {
			return THREADLOCAL_yyMM.get();
		}
		
		if(yyyyMMddHHmmssGang.equals(pattern)) {
			return THREADLOCAL_yyyyMMddHHmmssGang.get();
		}
		
		if(yyyyXieGangMMXieGangdd.equals(pattern)) {
			return THREADLOCAL_yyyyXieGangMMXieGangdd.get();
		}
		
		if(yyyy.equals(pattern)) {
			return THREADLOCAL_yyyy.get();
		}
		
		if(yy.equals(pattern)) {
			return THREADLOCAL_yy.get();
		}
		
		if(yyyy_N_MM_Y_dd_R.equals(pattern)) {
			return THREADLOCAL_yyyy_N_MM_Y_dd_R.get();
		}
		
		if(yyyy_N_MM_Y.equals(pattern)) {
			return THREADLOCAL_yyyy_N_MM_Y.get();
		}
		
		if(yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M.equals(pattern)) {
			return THREADLOCAL_yyyy_N_MM_Y_dd_R_HH_S_mm_F_ss_M.get();
		}
		
		throw new Exception("Can't find Time Format");
	}
	
}
