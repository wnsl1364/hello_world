package com.yedam.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.variable.Member;

public class SetExe {
	public static void main(String[] args) {
		// Set 인터페이스를 구현한 HashSet 컬렉션을 생성
		// Set은 중복을 허용하지 않는 컬렉션 타입
		Set<String> set = new HashSet<String>();

		set.add("Hello");
		set.add("World");
		// set.add(100); // 오류 발생: Set<String>은 문자열(String)만 저장할 수 있음
		set.add("Hello"); // 중복된 "Hello"는 추가되지 않음 (Set의 특징)

		// Set 컬렉션은 순서가 없고, 중복을 허용하지 않음
		// 저장된 데이터를 하나씩 가져오기 위해 Iterator(반복자) 사용

		// Set 컬렉션 내부의 데이터를 순차적으로 접근할 수 있는 Iterator 생성
		Iterator<String> iter = set.iterator();

		// hasNext() 메서드는 Iterator 내부에 다음 요소가 존재하는지 확인
		while (iter.hasNext()) {
			// next() 메서드는 다음 요소를 가져오는 역할
			String result = iter.next();
			System.out.println(result); // 요소 출력
		}

		// Set<Member>
		Set<Member> members = new HashSet<>();
		// 객체가 다 다른 주소값을 지니고 있기때문에 같은 객체라고 인식하지 않음
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 85));
		members.add(new Member("홍길동", 80));

		Iterator<Member> miter = members.iterator();
		while (miter.hasNext()) {
			Member result = miter.next();
			System.out.println(result.toString());
		}

		
		// int => Integer
		int[] intAry = { 10, 20, 30, 40, 20, 10 };
		// int 배열에서 중복된 값을 제거한 후 결과를 List에 추가
		// List 반복문을 활용해서 출력
		
		Set<Integer> intA = new HashSet<Integer>();
		for(int i=0; i<intAry.length; i++) {
			intA.add(intAry[i]);
		}
		
		
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> intRemove = intA.iterator();
		while(intRemove.hasNext()) {
			Integer result = intRemove.next();
			list.add(result);
		}
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		};
		
//		list.forEach(num -> System.out.println(num)); //forEach문 사용으로 간결하게 작성가능
		
		
	}
}