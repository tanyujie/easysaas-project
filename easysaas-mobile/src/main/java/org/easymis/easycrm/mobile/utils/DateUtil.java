package org.easymis.easycrm.mobile.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期的实用方法类.
 * 
 * @author Deament
 */
public class DateUtil {
    
    /**
     * 取得格式化效果的系统日期！ 格式如：yyyy-MM-dd kk:mm:ss
     * 
     * @param formate
     * @return
     */
    public final static String getFormateDate(String formate){
        SimpleDateFormat f = new SimpleDateFormat(formate, Locale.CHINA);
        return f.format(new Date());
    }
    
    /**
     * 获取默认格式的日期和时间.形如：2007-7-8- 12:23:54
     * 
     * @return
     */
    public final static String getDateTime(){
        return getFormateDate("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取默认格式的日期.形如：2007-7-8
     * 
     * @return
     */
    public final static String getDate(){
        return getFormateDate("yyyy-MM-dd");
    }
    
    /**
     * 获取当前的年份
     * 
     * @return
     */
    public final static String getYear(){
        return getFormateDate("yyyy");
    }
    
    /**
     * 获取当前的短年份
     * 
     * @return
     */
    public final static String getShortYear(){
        return getFormateDate("yy");
    }
    
    /**
     * 获取当前的月份
     * 
     * @return
     */
    public final static String getMonth(){
        return getFormateDate("MM");
    }
    
    /**
     * 获取当前的短月份
     * 
     * @return
     */
    public final static String getShortMonth(){
        return getFormateDate("M");
    }
    
    /**
     * 获取当前的日期
     * 
     * @return
     */
    public final static String getDay(){
        return getFormateDate("dd");
    }
    
    /**
     * 获取当前的短日期
     * 
     * @return
     */
    public final static String getShortDay(){
        return getFormateDate("d");
    }
    
    /**
     * 获取默认格式的时间(24小时制).形如：16:23:54
     * 
     * @return
     */
    public final static String getTime(){
        return getFormateDate("HH:mm:ss");
    }
    
    /**
     * 判断指定的字符串是否是正确的日期时间字符串.<br>
     * 该方法支持日期或日期时间的判断.
     * 
     * @param dateStr
     * @return
     */
    public final static boolean isDate(String dateStr){
        Date dt = parseSimpleDate(dateStr);
        if (dt != null) {
            return true;
        }
        return parseSimpleDateTime(dateStr) != null;
    }
    
    /**
     * 使用指定的模式来判断字符串是否是日期时间字符串.
     * 
     * @param pattern
     * @param dateStr
     * @return
     */
    public final static boolean isDate(String pattern,String dateStr){
        return parseSimpleDT(pattern, dateStr) != null;
    }
    
    /**
     * 将指定的日期时间格式的字符串转换成日期对象.
     * 
     * @param dateStr
     * @return
     */
    public final static Date parseDateTime(String dateStr){
        try {
            return DateFormat.getDateTimeInstance().parse(dateStr);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    /**
     * 将指定日期格式的字符串转换成日期对象.
     * 
     * @param dateStr
     * @return
     */
    public final static Date parseDate(String dateStr){
        try {
            return DateFormat.getDateInstance().parse(dateStr);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    /**
     * 使用简单化的方式来解析日期时间格式.
     * 
     * @param dateStr
     * @return
     */
    public final static Date parseSimpleDateTime(String dateStr){
        return parseSimpleDT("yyyy-MM-dd HH:mm:ss", dateStr);
    }
    
    public final static Date parseSimpleDate(String dateStr){
        return parseSimpleDT("yyyy-MM-dd", dateStr);
    }
    
    public final static Date parseSimpleTime(String timeStr){
        return parseSimpleDT("HH:mm:ss", timeStr);
    }
    
    /**
     * 使用指定的模式来解析字符串日期时间.
     * 
     * @param pattern
     * @param dateStr
     * @return
     */
    public final static Date parseSimpleDT(String pattern,String dateStr){
        try {
            return new SimpleDateFormat(pattern, Locale.US).parse(dateStr);
        } catch (ParseException ex) {
            return null;
        }
    }
    
    /**
     * 比较两个日期的大小.返回-1表示date1在date2之前，返回0表示两者相等，返回1 则表示date1在date2之后.
     * 
     * @param date1
     * @param date2
     * @return
     */
    public final static int compareDate(Date date1,Date date2){
        if (date1.before(date2)) {
            return -1;
        }
        if (date1.after(date2)) {
            return 1;
        }
        return 0;
    }
    
    /**
     * 测试日期date1是否在date2之前.
     * 
     * @param date1
     * @param date2
     * @return
     */
    public final static boolean isBefore(Date date1,Date date2){
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.before(date2);
    }
    
    public final static boolean isBeforeNow(Date date1){
        return isBefore(date1, Calendar.getInstance().getTime());
    }
    
    /**
     * 测试日期date1是否在date2之后.
     * 
     * @param date1
     * @param date2
     * @return
     */
    public final static boolean isAfter(Date date1,Date date2){
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.after(date2);
    }
    
    public final static boolean isAfterNow(Date date1){
        return isAfter(date1, Calendar.getInstance().getTime());
    }
    
    /**
     * 测试日期date1和date2是否相等.
     * 
     * @param date1
     * @param date2
     * @return
     */
    public final static boolean isEquals(Date date1,Date date2){
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.equals(date2);
    }
    
    public final static boolean isEqualsNow(Date date1){
        return isEquals(date1, Calendar.getInstance().getTime());
    }
    
    /**
     * 获取当前日期时间，参数表示在此基础上的偏差，参数依次表示年、月、日、时、分、秒。 为正则表示在此日期上加、为负则表示在此日期上减。
     * 
     * @param deviation
     * @return
     */
    public final static Date getNowDate(int... deviation){
        return setDate(new Date(), deviation);
    }
    
    /**
     * 在某一指定的日期基础上进行日期的偏差设置，参数意义同getNowDate
     * 
     * @param date
     * @param deviation
     * @return
     */
    public final static Date setDate(Date date,int... deviation){
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        if (deviation.length < 1) {
            return cal.getTime();
        }
        final int[] filed = { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND };
        for (int i = 0; i < deviation.length; i++) {
            cal.add(filed[i], deviation[i]);
        }
        return cal.getTime();
    }
    
    /**
     * 获得字符串类型的当前系统时间
     * 
     * @return 当前时间 String
     */
    public static String getNow(){
        Date nowDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(nowDate);
    }
    
    public static String formatDate(Date date,String fmt){
        SimpleDateFormat format = new SimpleDateFormat(fmt);
        return format.format(date);
    }
    
    /**
     * 当月第一天
     * 
     * @return
     */
    public static String getFirstDay(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String dayFirst = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(dayFirst).append(" 00:00:00");
        return str.toString();
    }
    
    /**
     * 获取某月的第一天
     * 
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getFirstDay(String date) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date theDate = df.parse(date);
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String dayFirst = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(dayFirst).append(" 00:00:00");
        return str.toString();
    }
    
    /**
     * 当月最后一天
     * 
     * @return
     */
    public static String getLastDay(){
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        // 打印
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }
    
    /**
     * 某月的最后一天 首先要获取月份
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getLastDay(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(sdf.parse(date));
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }
    
    /**
     * 得到某个日期的前几月或者后几月
     * 
     * @param dateStr
     *            格式如 2013-10-17
     * @param pos
     *            位移几月
     */
    public static String getMoveMonth(String dateStr,int pos){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(dateStr, new ParsePosition(0));
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, pos);
        Date dt1 = rightNow.getTime();
        return sdf.format(dt1);
    }
    
    /**
     * 返回到两个时间段所有月份列表
     * 
     * @param da1
     * @param da2
     * @return
     * @throws ParseException
     */
    public static String[] getMothList(String da1,String da2) throws ParseException{
        StringBuffer sb = new StringBuffer();
        // 定义起始日期
        Date d1 = new SimpleDateFormat("yyyy-MM").parse(da1);
        // 定义结束日期
        Date d2 = new SimpleDateFormat("yyyy-MM").parse(da2);
        // 定义日期实例
        Calendar dd = Calendar.getInstance();
        // 设置日期起始时间
        dd.setTime(d1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        // 判断是否到结束日期
        while (dd.getTime().before(d2)) {
            String str = sdf.format(dd.getTime());
            sb.append(str + ",");
            // 进行当前日期月份加1
            dd.add(Calendar.MONTH, 1);
        }
        // 补全最后一个月
        sb.append(sdf.format(dd.getTime()));
        return sb.toString().split(",");
    }
    
    /**
     * 获取到两个时间之间的所有周
     * 
     * @param da1
     * @param da2
     * @return
     * @throws ParseException
     */
    public static String[] getWeeks(String da1,String da2) throws ParseException{
        Calendar cBegin = new GregorianCalendar();
        Calendar cEnd = new GregorianCalendar();
        StringBuffer sb = new StringBuffer();
        cBegin.setTime(convertToDate(da1));
        cEnd.setTime(convertToDate(da2));
        int count = 1;
        // 结束日期下滚一天是为了包含最后一天
        cEnd.add(Calendar.DAY_OF_YEAR, 1);
        while (cBegin.before(cEnd)) {
            if (cBegin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                sb.append("第" + count + "周,");
                count++;
            }
            cBegin.add(Calendar.DAY_OF_YEAR, 1);
        }
        return sb.toString().split(",");
    }
    
    /**
     * 获取一个日期的月份
     * 
     * @param time
     * @return
     */
    public static int getMonth(Date time){
        SimpleDateFormat st = new SimpleDateFormat("MM");
        return Integer.parseInt(st.format(time));
    }
    
    /***
     * 把日期转换成字符串
     * 
     * @param time
     * @return
     */
    public static String convertToStr(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(time);
    }
    
    /***
     * 把日期转换成字符串 指定格式
     * 
     * @param time
     * @param format
     * @return
     */
    public static String convertToStrwithformat(Date time,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(time);
    }
    
    /***
     * 把字符串转换成 日期
     * 
     * 
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date convertToDate(String time) throws ParseException{
        // 小写的mm表示的是分钟
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(time);
    }
    
    /***
     * 把字符串转换成 日期 指定格式
     * 
     * 
     * @param time
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date convertToDate(String time,String format) throws ParseException{
        // 小写的mm表示的是分钟
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(time);
    }
    
    private DateUtil(){
        // 禁止实例化
    }
}
