package cwf.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import cwf.date.format.DateFormatType;

@Component
public class CwfClockImpl implements CwfClock {
	private static final String IST_TIMEZONE = "IST";
	synchronized void init() {
		// initTimeZone();
		// TODO : init some time zones here
	}

	@Override
	public long millis() {
		return System.currentTimeMillis();
	}

	@Override
	public TimeZone getTimeZone() {
		return null;
	}

	@Override
	public Calendar cal() {
		TimeZone.setDefault(TimeZone.getTimeZone(IST_TIMEZONE));
		return cal(TimeZone.getDefault(), Locale.getDefault());
	}
	
	@Override
	public Calendar cal(TimeZone timeZone, Locale locale) {
		return Calendar.getInstance(timeZone, locale);
	}
	
	@Override
	public String getCurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatType.ISO_DATE_FORMAT.getByFormat());
		return dateFormat.format(cal().getTime());
	}

	@Override
	public Date getCurrentDate() {
		return cal().getTime();
	}

	@Override
	public String formatDateToDDMMYYYY(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatType.DD_MM_YYYY.getByFormat());
		return dateFormat.format(date);
	}

	@Override
	public String getTimeAsHHMMAMPM(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatType.HH_MM_AM_PM.getByFormat());
		return dateFormat.format(date);
	}
}
