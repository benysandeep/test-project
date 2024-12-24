package com.example.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalJavaExampleThree {

	public static void main(String[] args) {
		findDuplicateInArray();

	}
	
	public static void findDuplicateInArray() {
		int[] arr = {1,2,2,1};
		Set<Integer> set = new HashSet<Integer>();
		int n =4;
		Arrays.stream(arr).filter(x->!set.add(x)).forEach(System.out::println);
	}
	
	public static void FindSmallestMissinginArray() {
		Integer[] arr = {4,6,9,1,2,3};
		IntStream.range(1, arr.length+1).filter(i->Arrays.stream(arr)
				.noneMatch(n->n==i)).findFirst().ifPresent(System.out::println);
		
	}
	
	
	public static void FindHighestRepeatedNumberInArray() {
		Integer[] arr = {1,2,3,3,2,3,4,6,7,2,3,8,9};
		Arrays.stream(arr).collect(Collectors.
				groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(x->System.out.println(x.getKey()));
	}
	
	public static void SortListUsingStream() {
		List<String> list = Arrays.asList("H", "A", "Z", "L",
                "B", "Y", "M", "a", "c");
		list.stream().sorted().forEach(System.out::print);
	}
	
	private static void findFirstNonRepeativeCharInString() {
		String input = "Java Hungry Blog Alive is Awesome";
		input.chars().forEach(System.out::print);
		input.chars().mapToObj(s->Character.toLowerCase
				(Character.valueOf((char)s))).collect(Collectors.
						groupingBy(Function.identity(),LinkedHashMap::new,
						Collectors.counting())).entrySet().stream().
		                filter(x->x.getValue()>1L).findFirst().ifPresent(x->System.out.println(x.getKey()));
	}
	
	private static void convertToUpperCase() {
		List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
		names.stream().map(a->a.toUpperCase()).forEach(System.out::print);
	}
	
	private static void convertListToMapHandlingDuplicate() {
		List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 55));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));
        noteLst.stream().collect(Collectors.toMap(Notes::getTagId, Notes::getTagName,(a,b)->b))
                .entrySet().forEach(System.out::println);
	}
	
	private static void arrayToList() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
	}
	
	private static void sortPremetiveArrayinDesceningOrder() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int[] numss = Arrays.stream(nums).boxed().
				         sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		
		Arrays.stream(numss).forEach(System.out::println);
	}
	
	private static void optionalIfElse() {
		// If you have a non-null type variable (say var1) and it returns 3 when var1 variable is 5 otherwise it returns 2.  Please write this using Optional.
        int i =4;
        Optional.ofNullable(i).filter(x->x==5).map(x->3).orElse(2);
	}
	
	private static void collectRequestParamInMap() {
		String s = "http://mydomain.com/mycontext/mypath?x=123&y=345&a=happy&b=coding&c=engineer";
		Arrays.stream(s.split("\\?")[1].split("\\&")).map(x->x.split("\\=")).collect(Collectors.toMap(p->p[0], p->p[1]))
		            .entrySet().forEach(System.out::println);
	}
	
	public static void sumOfAllDigitOfNumber() {
		int number = 124589;
		Arrays.stream(String.valueOf(number).split(""))
		        .collect(Collectors.summingInt(Integer::parseInt));
	}
	
	public static void findCharAtPositionTwoInAllStrings() {
		List<String> list = Arrays.asList("MYC","All","GGB");
		list.stream().flatMap(s->Stream.of(s.charAt(1))).forEach(System.out::println);
	}

}
