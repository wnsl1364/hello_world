package com.yedam;

class Person{
	private String name;
	private String tel;
	private int age;
	
	Person(){
		
	};
	Person(String name, String tel, int age){
		this.name = name;
		this.tel = tel;
		this.age = age;		
	};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
public class HelloExe {
	// 기능(함수) => main 메소드.
	public static void main(String[] args) { //main 이라는 메소드가 무조건 있어야함
//		System.out.println("Hello, World");
		
//		//문자열
//		String name;
//		name = "한주연";
//		
//		System.out.println("이름은 " + name);
//		
//		//정수
//		int score = 100;
//		
//		System.out.println("점수는 " + score + "점 입니다.");
//		System.out.println("수정된 부분");
		
		//1.32000 변수선언과 할당
		int num;
		num = 32000;
		System.out.println(num);
		
		//2. 34, 32, 88, 23
		int[] be = {34, 32, 88, 23};
		
		//3. 문자 : 32
		String str = "32";
		System.out.println(str);
		
		//4.정수변수에 저장
		int str2 = Integer.parseInt(str);
		System.out.println("정수를 변수에 " + str2);		
		
		//5.Hello, Nice, Good
		String[] text = {"Hello", "Nice", "Good"};
		
		//6.정수 5개 저장
		//Math.random() -> 60~100
		int[] scores = new int[5];
		for(int i=0; i<scores.length; i++) {
			scores[i] = (int) ((Math.random() * 41) + 60);
			System.out.println(scores[i]);
		}		
		
		//7.이름, 연락처, 나이 선언
		//홍길동, 010-1234-1234, 20		
		Person s1 = new Person();
		s1.setName("홍길동");
		s1.setTel("010-1234-1234");
		s1.setAge(20);		
		
		//8. [3]공간 선언
		//홍길동, 010-1234-1234, 20
		//한주연, 010-2222-2222, 22
		//주만성, 010-3333-3333, 23
		Person[] storage = new Person[3];
		storage[0] = new Person("홍길동", "010-1234-1234", 20);
		storage[1] = new Person("한주연", "010-2222-2222", 22);
		storage[2] = new Person("주만성", "010-3333-3333", 23);
		
		//9.나이가 제일 많은 사람의 이름을 출력
		int max = storage[0].getAge();
		String name = storage[0].getName();
		for(int i=0; i<storage.length; i++) {
			if(max < storage[i].getAge()) {
				max = storage[i].getAge();
				name = storage[i].getName();
			}
		}
		System.out.println(max + name);
	}
}