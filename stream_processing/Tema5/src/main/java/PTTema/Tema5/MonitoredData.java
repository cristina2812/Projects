package PTTema.Tema5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MonitoredData {

	private String startTime;
	private String endTime;
	private String activity;

	public MonitoredData(String startTime, String endTime, String activity) {

		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}

	public MonitoredData() {

	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "MonitoredData [startTime=" + startTime + ", endTime=" + endTime + ", activity=" + activity + "]";
	}

	public Date getDateStart() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		try {
			date = simpleDate.parse(getStartTime());

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}
	
	public Date getTimeSecondStart(){
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = simpleDate.parse(getStartTime());

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
		
	}
	
	public Date getTimeSecondEnd(){
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;

		try {
			date = simpleDate.parse(getEndTime());

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
		
	}

}
