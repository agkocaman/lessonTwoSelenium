package lessonTwoSelenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	// @Test
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
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("M")) {
				count++;
			}
		}
		System.out.println("M harfi ile başlayan isimlerin toplamı...: " + count);
	}

	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Zeynep");
		names.add("Sena");
		names.add("Kocaman");
		names.add("Ahmet");
		names.add("Gökhan");
		names.add("Serkan");
		names.add("Kağan");
		Long c = names.stream().filter(s -> s.startsWith("M")).count();
		System.out.println("M harfi ile başlayan isimlerin toplamık...: " + c);

		long d = Stream.of("Ahmet", "Mehmet", "Murat", "Mustafa", "Mahmut", "Osman", "Ömer").filter(s -> {
			s.startsWith("M");
			return true;
		}).count();
		System.out.println("M harfi ile başlayan isimlerin toplamı stream...: " + d);

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println("son" + s));

	}

	//@Test
	public void streamMap() {
		List<String> names1 = Arrays.asList("Ahmet", "Mehmet", "Murat", "Mustafa", "Mahmut", "Osman", "Ömer");
		ArrayList<String> names = new ArrayList<String>();
		names.add("Zeynep");
		names.add("Sena");
		names.add("Kocaman");
		names.add("Ahmet");
		names.add("Gökhan");
		names.add("Serkan");
		names.add("Kağan");

		names1.stream().filter(s -> s.endsWith("t")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		names1.stream().filter(s -> s.startsWith("M")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println("Sort..: " + s));
		names1.stream().filter(s -> s.contains("at")).sorted().map(s -> s.toLowerCase())
				.forEach(s -> System.out.println("at..: " + s));

		Stream<String> newStream = Stream.concat(names1.stream(), names.stream());
		// newStream.sorted().forEach(s->System.out.println("Full...: "+s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Osman"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}
	@Test
	public void streamCollect() {
		
	}
}
