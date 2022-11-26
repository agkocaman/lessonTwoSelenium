package lessonTwoSelenium;

import java.util.ArrayList;
import org.testng.annotations.Test;


public class test1 {
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ahmet");
		names.add("Mehmet");
		names.add("Murat");
		names.add("Mustafa");
		names.add("Mahmut");
		names.add("Osman");
		names.add("Ömer");
		int count = 0;
		for(int i=0; i<names.size(); i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
}
