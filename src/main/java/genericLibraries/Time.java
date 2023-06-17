package genericLibraries;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Time {
	public static void main(String[] args) {
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		
		String changeFormat = time1.toString().replace(":", "-");
		System.out.println("after change : into - "+changeFormat);
		System.out.println();
		


	}	

}
