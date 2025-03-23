package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, Double> map = new HashMap<Member, Double>(); //HashMap은 키의 중복 여부를 hashCode()와 equals()로 판단
		map.put(new Member("홍길동", 80), 174.8);
		map.put(new Member("한주연", 100), 168.8);
		map.put(new Member("주만성", 30), 178.8);
		
		map.remove(new Member("주만성", 30));		
		
		Set<Entry<Member, Double>> entryset = map.entrySet();
		for(Entry<Member, Double> entry : entryset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
}