package com.example.dev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

public class FunctionalJavaExampleTwo {
	
	@Autowired
	ClassC c;
    static int i =0;
	public static void main(String[] args) {

		}
	
	public static void StringAssignment() {
		String s1 = "hello";
		s1.concat("Check");
		String s2 = "world";
		String s5 = s1;
		String s3 = s1.concat(s2);
		String s4 = "hello world";
		System.out.println(s1);
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		System.out.println(s1==s5);
	}
	
	public static void FindSmallestMissinginArray() {
		Integer[] arr = {1,2,3,4,6,9};
		IntStream.rangeClosed(1, arr.length+1).filter(i->Arrays.stream(arr).noneMatch(n->n==i))
		.findFirst().ifPresent(System.out::println);
	}
	
	public static void FindHighestRepeatedNumberInArray() {
		Integer[] arr = {1,2,3,3,2,3,4,6,7,2,3,8,9};
		Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().min(Map.Entry.comparingByValue()).ifPresent(System.out::println);
	}
	
	public static void SortListUsingStream() {
		List<String> list = Arrays.asList("H", "A", "Z", "L",
                "B", "Y", "M", "a", "c");
		list.stream().sorted().forEach(System.out::println);
	}
	
	public static void SortListUsingStreamInReverseOrder() {
		List<String> list = Arrays.asList("H", "A", "Z", "L",
                "B", "Y", "M", "a", "c");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	public static void countEmptyStringinList() {
		List<String> list = Arrays.asList("ss", "", "ss", "", "","");
		Long count = list.stream().filter(a->a.isEmpty()).count();
		System.out.println(count);
	}
	
	public static void countNumberOfStringEndWithD() {
		List<String> list = Arrays.asList("method", "static",
                "void", "abstract", "ping");
		list.stream().filter(s->s.endsWith("d")).forEach(System.out::println);
	}
	
	public static void reverseString() {
		String first = "RangRover";
		System.out.println(new StringBuilder(first).reverse().toString());
	}

}
