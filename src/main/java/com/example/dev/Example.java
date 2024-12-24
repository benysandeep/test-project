package com.example.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {

	public static void main(String[] args) {
		sumOfAllDigitOfNumber();
		
	}
	
	public static void firstNonRepetingChar() {
		String input = "Java Hungry Blog Alive is Awesome";
		input.chars().mapToObj(x->Character.
				toLowerCase(Character.valueOf((char)x)))
		        .collect(Collectors.groupingBy(Function.identity(),
		        		LinkedHashMap::new,Collectors.counting()))
		               .entrySet().stream().filter(x->x.getValue()<2).findFirst().ifPresent(x->System.out.println(x.getKey()));
	}
	
	public static void reverseString() {
		String abc = "Help";
		System.out.println(new StringBuilder(abc).reverse().toString());
	}
	
	public static void removeDuplicates() {
		int [] arr = {1,2,4,6,7,1,4};
		
	    Arrays.asList(arr).stream().collect(Collectors.toSet()).forEach(System.out::println);
               
	}
	
	public static void sortBasedOnParam() {
		List<Weather> list = new ArrayList<>();
		list.add(new Weather("City",38,"uk","37",false));
		list.add(new Weather("City",30,"uk","37",false));
		list.add(new Weather("City",32,"uk","37",false));
		
		list.stream().map(Weather::getTemp).sorted().forEach(System.out::println);
	    list.stream().iterator().forEachRemaining(System.out::println);
	}
	
	public static void findDuplicatesInList() {
		List<Integer> list = Arrays.asList(1,2,3,3,3,4,4,6,7,7);
		list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(x->x.getValue()>1).forEach(System.out::println);
	}
	
	public static void findDuplicatesInArray() {
		int [] arr = {1,2,4,6,7,1,4};
		Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(x->x.getValue()>1).forEach(System.out::println);
	}
	
	public static void intToIntegerArray() {
		int [] arr = {1,2,4,6,7,1,4};
		Arrays.stream(arr).boxed().collect(Collectors.toList());
	}
	
	
	
	public static void replaceWithCondition() {
		List<String> list = IntStream.rangeClosed(1,16).mapToObj(x->{
			if(x%3==0 && x%5==0) {
				return "Hi Hello";
			} else if (x%5==0) {
				return "Hello";
			} else if (x%3==0) {
				return "Hi";
			} else {
				return String.valueOf(x);
			
			}
			}).collect(Collectors.toList());
			
	       System.out.println(list);
	}
	
	public static void sortPremetiveArrayDesceningOrder() {
		int[] numArr = new int[]{1,2,3,4,5};
		
		Arrays.stream(numArr).boxed().
		sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
	}
	
	public static void OptionalUseOfIf() {
		int i =5;
		Optional.ofNullable(i).filter(x->x==5).map(x->3).orElse(2);
	}
	
	public static void writeParamToMap() {
		String url = "http://mydomain.com/mycontext/mypath?x=123&y=345&a=happy&b=coding&c=engineer";
		//Arrays.asList(url.split("\\?")).get(1).split("\\&")
		Arrays.stream(url.split("\\?")[1].split("\\&"))
		.map(x->x.split("=")).collect(Collectors.toMap(p->p[0], p->p[1]))
		.entrySet().forEach(System.out::println);
	}
	
	public static void firstNonRepetingChars() {
		String input = "Java Hungry Blog Alive is Awesome";
		input.chars().mapToObj(x->Character.toLowerCase(Character
				.valueOf((char)x))).collect(Collectors.
						groupingBy(Function.identity(),Collectors.counting()))
		            .entrySet().stream().filter(x->x.getValue()<2).forEach(System.out::println);
	}
	
	public static void removeDuplicate() {
		int [] arr = {1,2,4,6,7,1,4};
		Set<Integer> set = new HashSet<>();
		Arrays.stream(arr).boxed().filter(x->!set.add(x)).forEach(System.out::println);
	}
	
	public static void writeParamsToMap() {
		String url = "http://mydomain.com/mycontext/mypath?x=123&y=345&a=happy&b=coding&c=engineer";
		Arrays.stream(url.split("\\?")[1].split("\\&")).
		map(x->x.split("\\=")).collect(Collectors.toMap(p->p[0],p->p[1])).
		entrySet().forEach(System.out::println);
	}
	
	public static void OptionalUsesOfIf() {
		int i =5;
		Optional.ofNullable(i).filter(x->x==5).map(x->2).orElse(3);
	}
	
	public static void replaceWithConditions() {
		List<String> list = IntStream.rangeClosed(1, 16).mapToObj(x->{
			if(x%3==0 && x%5==0) {
				return "Hi Hello";
			} else if(x%3==0) {
				return "Hi";
				
			} else if(x%5==0) {
				return "Hello";
			} else {
				return String.valueOf(x);
			}
			
		}).collect(Collectors.toList());
		System.out.println(list);
	}
	
	public static void minThreeNumberFromList() {
		List<Integer> list = Arrays.asList(1,3,15,9,11,76,0);
		list.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
	}
	
	public static void sumOfAllDigitOfNumber() {
		int number = 124589;
		System.out.print(Arrays.stream(String.valueOf(number).split("")).
		collect(Collectors.summingInt(Integer::parseInt)));
	}
		
		

		
}
