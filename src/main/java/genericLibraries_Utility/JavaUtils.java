package genericLibraries_Utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to get random int value
	 * 
	 * @author Srinivas V
	 * @return
	 */
	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	/**
	 * @author Srinivas V
	 * This method is used to customize the date
	 * @return
	 */
	public String systemDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}

	/**
	 * @author Srinivas V
	 * this method is used to customize the date and time/ we called it has local date 
	 * @return
	 */
	public String sysDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String systemdateInformat = sim.format(date);
		return systemdateInformat;

	}
	
//	public String sysDoubleDate(Date startDate, Date endDate) {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		String Start = sdf.format(startDate);
//		String End = sdf.format(endDate);
//		return End;
	// }

	/**
	 * @author Srinivas V
	 * this method is used to add the future month
	 * @param futureMon
	 * @return
	 */
	public String futureDateIntermsOfMonths(long futureMon) {
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(futureMon);

		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String futureMonth = d.format(future);
		return futureMonth;
	}
	
//	public void simpleDateFormat(String StartDate, String EndDate) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String Start = sdf.format(StartDate);
//		String End = sdf.format(EndDate);
	public String date(Date dateInput) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFormat = sdf.format(dateInput);
		return dateFormat;
	}
	
}
