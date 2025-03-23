package com.yedam.inheritance;

// Friend 클래스를 부모로 하는 자식 클래스들이 이름, 연락처를 공통으로 가질 수 있도록 기본 정보를 정의합니다.
public class Friend extends Object {
    // 필드 선언: 친구의 이름과 연락처
    private String name;
    private String tel;
    
    // 기본 생성자
    public Friend() {}
    public Friend(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    // toString() 메서드: 친구의 이름과 연락처를 출력하는 메서드
    //tos 치고 ctrl + space눌러보셈
    @Override
    public String toString() {
        return "이름은 " + getName() + ", 연락처는 " + getTel();
    }

    // getter, setter: 이름과 연락처를 가져오고 설정하는 메서드
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
}
