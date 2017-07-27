package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public static String getToday(){
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        
        return today;
	}
}
