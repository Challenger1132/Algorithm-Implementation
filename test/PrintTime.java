package test;

import java.util.Scanner;
public class PrintTime {
	public static void printTime(long input){
		long yearOfSecond = 360*24*60*60;
		long monthOfSecond = 30*24*60*60;
		long dayOfSecond = 24*60*60;
		long hourOfSecond = 60*60;
		long minuteOfSecond = 60;
		long year = 1970, months = 1, day = 1, hour = 0, minute = 0, second = 0;
		
		long cyears = input / yearOfSecond;
		long cmonths = input % yearOfSecond / monthOfSecond;
		long cday = input % monthOfSecond / dayOfSecond;
		long chour = input % dayOfSecond / hourOfSecond;
		long cminute = input % hourOfSecond / minuteOfSecond;
		long csecond = input % 60;
		year += cyears;
		months += cmonths;
		day += cday;
		hour += chour;
		minute += cminute;
		second += csecond;
		String smonth = months > 9 ? new String(months+"") : "0" + new String(months+"");
		String sday = day > 9 ? new String(day+"") : "0" + new String(day+"");
		String shour = hour > 9 ? new String(hour+"") : "0" + new String(hour+"");
		String sminute = minute > 9 ? new String(minute+"") : "0" + new String(minute+"");
		String ssecond = second > 9 ? new String(second+"") : "0" + new String(second+"");
		System.out.println(year + "/" + smonth + "/" + sday + " " + shour + 
				":" + sminute + ":" + ssecond);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnt = in.nextInt();
		for(int i = 0;i < cnt; i++) {
			long input = in.nextLong();
			printTime(input);
		}
		in.close();
	}
}
