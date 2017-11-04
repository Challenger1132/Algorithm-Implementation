package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintCurrentTime {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:dd-hh:mm:ss");
		String time = sdf.format(new Date());
		System.out.println(time);
	}
}
