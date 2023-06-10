package com.practice;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;


public class StringOperation {

	@Test
	public void str() {
		
		String st="manjunath";
		st=st.toLowerCase();
		LinkedHashMap<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < st.length(); i++) {
			if (map.containsKey(st.charAt(i))==false) {
				map.put(st.charAt(i), 1);
			}
			else
			{
				Integer ch=map.get(st.charAt(i));
				ch=ch+1;
				map.put(st.charAt(i), ch);
			}
		}
		System.out.println(map);
	}
}
