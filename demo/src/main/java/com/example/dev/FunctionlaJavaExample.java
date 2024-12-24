package com.example.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

public class FunctionlaJavaExample {

	public static void main(String[] args) {
		   int[] arr = {1,2,3,4,5,7,9,8};
		   int k=3;
		   int size = arr.length;
		   int[] arrOne = Arrays.copyOfRange(arr, 0, arr.length-k);
		   int[] arrTwo = Arrays.copyOfRange(arr, arr.length-k, arr.length);
		   System.out.println(Arrays.toString(arrOne));
		   System.out.println(Arrays.toString(arrTwo));
		   int[] replacedArray = IntStream.concat(Arrays.stream(arrTwo), 
				   Arrays.stream(arrOne)).toArray();
		    
		   System.out.println(Arrays.toString(replacedArray));

	}

	private static void sortListInReverse() {
		List<String> list = Arrays.asList("G", "D", "B", "A");
	   
		list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
		.forEach(System.out::print)
				;
	}
	
	private static void findEmptyInLsit() {
		List<String> list = Arrays.asList("G", "", "", "D", "B", "","A");
		System.out.println(list.stream().filter(x->x.isEmpty()).count());
		
	}
	
	private static void countwhichEndWithDInLsit() {
		List<String> list = Arrays.asList("phed", "abcd", "efgd", "", "rar", "","GA");
		System.out.println(list.stream().filter(x->x.endsWith("d")).count());
		
	}
	
	private static void evenNumberInLsit() {
		List<Integer> list = Arrays.asList(1,3,2,4,9);
		//System.out.println(list.stream().filter(x->x%2==0).collect(Collectors.toList()));
		list.stream().filter(x->x%2==0).forEach(System.out::println);
	}
	
	private static void NumberStartwithOneInList() {
		List<Integer> list = Arrays.asList(11,31,21,14,19);
		//System.out.println(list.stream().filter(x->x%2==0).collect(Collectors.toList()));
		//list.stream().map(x->x+"").filter(x->x.startsWith("1")).forEach(System.out::println);
		list.stream().map(x->x.toString()).filter(x->x.startsWith("1")).forEach(System.out::println);
	}
	
	private static void numberDuplicateInList() {
		List<Integer> list = Arrays.asList(11,31,21,14,19,11,21);
		Set<Integer> set = new HashSet<>();
		list.stream().filter(a->!set.add(a)).forEach(System.out::println);
	}
	
	private static void findFirstInList() {
		List<Integer> list = Arrays.asList(11,31,21,14,19,1,21);
		//System.out.println(list.stream().findFirst().get());
		list.stream().findFirst().ifPresent(System.out::print);
	}
	
	private static void findTotalCountInList() {
		List<Integer> list = Arrays.asList(11,31,21,14,19,1,21);
		System.out.println(list.stream().count());
		
	}
	
	private static void findMaxInList() {
		List<Integer> list = Arrays.asList(11,31,21,14,19,1,21);
		//System.out.println(list.stream().max(Comparator.naturalOrder()).get());
		//list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
		list.stream().max(Integer::compare).ifPresent(System.out::println);
		
		
	}
	
	//Level2
	private static void findFirstNonRepeativeCharInString() {
		String input = "Java Hungry Blog Alive is Awesome";
		//input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).forEach(System.out::println);
		
//		input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).
//		collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().forEach(System.out::println);
		input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))            //convert to char object and lowercase
		                  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
		                  .entrySet().stream().filter(x->x.getValue()==1L).map(b->b.getKey()).findFirst().ifPresent(System.out::println);
	}
	
	//Level2
		private static void findFirstRepeativeCharInString() {
			String input = "Java Hungry Blog Alive is Awesome";
			//input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).forEach(System.out::println);
			
//			input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).
//			collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().forEach(System.out::println);
			input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))            //convert to char object and lowercase
			                  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
			                  .entrySet().stream().filter(x->x.getValue()>1L).map(b->b.getKey()).findFirst().ifPresent(System.out::println);
		}
		
		private static void findFirstRepeativeCharsInString() {
			String input = "Java Hungry Blog Alive is Awesome";
            input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s)))
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
            .entrySet().stream().filter(x->x.getValue()>1L).map(y->y.getKey()).findFirst().ifPresent(System.out::println);
		}
	
	//use of Optional
		private static void UseOfOptionalNullableInList() {
			List<Integer> list = Arrays.asList(11,31,21,14,19,1,21);
			Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().max(Integer::compare).ifPresent(System.out::println);
			
			
		}
		
		//use of Optional
				private static void UseOfOptionalNullablePracInList() {
					List<Integer> list = Arrays.asList(11,31,21,14,19,1,21);
					Optional.ofNullable(list).orElseGet(Collections::emptyList).stream().max(Integer::compare).ifPresent(System.out::println);
					
					
				}
		
		private static void convertToUpperCase() {
			List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
			Optional.ofNullable(names).orElseGet(Collections::emptyList).stream().map(a->a.toUpperCase())
			.forEach(System.out::println);
			
			
		}
		
		private static void convertListToMapHandlingDuplicate() {
			List<Notes> noteLst = new ArrayList<>();
	        noteLst.add(new Notes(1, "note1", 11));
	        noteLst.add(new Notes(2, "note2", 22));
	        noteLst.add(new Notes(3, "note3", 33));
	        noteLst.add(new Notes(4, "note4", 44));
	        noteLst.add(new Notes(5, "note5", 55));

	        noteLst.add(new Notes(6, "note4", 66));
	        noteLst.stream().map(Notes::getId).forEach(System.out::println);
	        noteLst.stream().forEach(x->System.out.println(x.getId()));
	        noteLst.forEach(x->System.out.println(x.getId()));
			
//	        //List is not sorted based on TagId
//	        Optional.ofNullable(noteLst).orElseThrow().stream().
//	                   collect(Collectors.toMap(Notes::getTagName, Notes::getTagId,(a,b)->b))
//	                   .entrySet().forEach(System.out::println);
//			
	        Optional.ofNullable(noteLst).orElseThrow().stream().
	        sorted(Comparator.comparingLong(Notes::getTagId).reversed()).
            collect(Collectors.toMap(Notes::getTagName, Notes::getTagId,(a,b)->b))
            .entrySet().forEach(System.out::println);
			
		}
		
		private static void arrayToList() {
			int[] nums = {1, 2, 3, 4, 5, 6, 7};
			Arrays.stream(nums).boxed().collect(Collectors.toList());
				
		}
		
		private static void sortPremetiveArrayinDesceningOrder() {
			int[] nums = {1, 2, 3, 4, 5, 6, 7};
			int[] sortedNumArr=Arrays.stream(nums).boxed().sorted(Collections.reverseOrder())
			.mapToInt(Integer::intValue).toArray();
				
		}
		
		//Optional if else condition
		
		private static void optionalIfElse() {
			// If you have a non-null type variable (say var1) and it returns 3 when var1 variable is 5 otherwise it returns 2.  Please write this using Optional.
            int i =4;
			System.out.println(Optional.ofNullable(i).filter(x->x==5).map(x->3).orElse(2));
		}
		
		//You have given with following URL string. You are asked to collect request parameter name & values to a Map.  How will you write it in a single line of code ?
		private static void collectRequestParamInMap() {
			String s = "http://mydomain.com/mycontext/mypath?x=123&y=345&a=happy&b=coding&c=engineer";
			Map<String,String> param = Arrays.stream(s.split("\\?")[1].split("\\&"))
					                                  .map(p->p.split("=")).collect(Collectors.toMap(p->p[0], p->p[1]))
					                                  ;
			System.out.println(param.entrySet());
					
		}
		
		private static void SpecialStringCountinString() {
			String E = "09:42";
			String L = "11:42";
			int hours = Integer.valueOf(L.split("\\:")[0])-Integer.valueOf(E.split("\\:")[0]);
			int min = Integer.valueOf(L.split("\\:")[1])-Integer.valueOf(E.split("\\:")[1]);
			if(min<0) {
				hours=hours-1;
				min=60+min;
			}
			System.out.println(hours+":"+min);
			
			if (hours<1) {
				int cost=2+3;
				System.out.print(cost);
			} else if (hours<=2 && hours>1) {
				int cost =2+3+4;
				System.out.println("Bill:" +cost);
				
			} else if(hours>=3 && min>0) {
				int cost = 2+3+4*(hours);
				System.out.println("Bill:" +cost);
			}
					
		}
		
		public static int solution(int[] A) {
			int sum =0;
			for(int i=0;i<A.length;i++) {
				sum=A[i]+sum;
			}
			int standardSum = (A.length)*(A.length+1)/2;
			return standardSum-sum;
		}
		
		public static int solutionMaxPowerOfTwo(int N) {
			int count=0;
			while(N>2) {
				if(N%2==0 &&N>2) {
					N=N/2;
					count++;
				} else {
					return count;
				}
			}
			return count;
			
		}
		
		public static void arrayToMap() {
			int[] A = {1,2,5,8,3,3};
			Arrays.stream(A).boxed().collect(Collectors.groupingBy(n->n,Collectors.counting()))
					.entrySet().forEach(System.out::println);
					                       
			
		}
		
		public static void stringMove() {
			String A = "><^#";
			Arrays.asList(A).forEach(System.out::print);
					                       
			
		}
		
		public static void sortAndMergeTwoArray() {
			int[] A = {2,4,7,1};
			int[] B = {6,7,9};
			//Arrays.stream(A).forEach(System.out::println);
			Arrays.stream(IntStream.concat(Arrays.stream(A),Arrays.stream(B))
					.sorted().distinct().toArray()).forEach(System.out::println);
		}
		
		public static void sumOfAllDigitOfNumber() {
			int number = 124589;
			System.out.println(Arrays.stream(String.valueOf(number).split("")).
					collect(Collectors.summingInt(Integer::parseInt)));
		}
		
		public static void minThreeNumberFromList() {
			List<Integer> list = Arrays.asList(1,3,15,9,11,76,0);
			list.stream().sorted().limit(3).collect(Collectors.toList())
			                      .forEach(System.out::println);
		}
		
		public static void commonElementBetweenTwoArray() {
			int[] A = {2,4,7,1};
			int[] B = {6,7,9};
			int[] commonElelemnt= IntStream.of(A).filter(x->IntStream.of(B).anyMatch(e->e==x)).toArray();
		    Arrays.stream(commonElelemnt).forEach(System.out::println);
		}
		
		public static void findCharAtPositionTwoInAllStrings() {
			List<String> list = Arrays.asList("MYC","All","GGB");
			list.stream().flatMap(s->Stream.of(s.charAt(2))).forEach(System.out::println);
			
		}
		
		public static void findMaxFrequencyofNumber() {
			Integer[] arr = {1, 4, 5, 6, 1, 9, 2, 4, 8, 2, 4};
			
			Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
			
					
		}
		
		public static void findSmallestMissingNumber() {
			Integer[] array = {1,2,3,6,7};
			
			int smallestMissing = IntStream.rangeClosed(1, array.length + 1)
	                .filter(i -> Arrays.stream(array).noneMatch(n -> n == i))
	                .findFirst()
	                .orElse(array.length + 1);
			System.out.println(smallestMissing);
			
					
		}
		
		public static void findSmallestMissingNumbers() {
			Integer[] array = {1,2,3,6,7};
			int smallMissing = IntStream.rangeClosed(1, array.length+1)
					.filter(x->Arrays.stream(array).noneMatch(i->i==x)).findFirst().orElse(array.length + 1);
		}

}
