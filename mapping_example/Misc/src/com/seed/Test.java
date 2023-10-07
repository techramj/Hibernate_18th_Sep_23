package com.seed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		String str ="The The The Hibernate is the framework written in core java . java is oop language . The the the the the";
		str = "hi hello hi hi";
		String[] words = str.split(" ");
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(words));
		System.out.println("No of distinct word= "+set.size());
		
		Map<String,Integer> map = new HashMap<>();
		for(String word: words) {
			Integer count = map.put(word, 1);
			if(count != null) {
				map.put(word, count+1);
			}
			
		}
		
		System.out.println(map);
		
	}

}
