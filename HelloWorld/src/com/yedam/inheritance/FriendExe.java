package com.yedam.inheritance;
/*상속
 * 친구1 : 이름, 연락처
 * 친구2 : 이름, 연락처, 학교, 학과
 * 친구3 : 이름, 연락처, 회사, 부서
 */
//이름, 연락처는 공통적으로 가지고 있기때문에 상속을 이용해서 기능을 만들어보자~
//Friend 부모 UnivFriend 자식

//친구
public class FriendExe {
	public static void main(String[] args) {
		// 업캐스팅: 부모 클래스 타입의 배열로 자식 객체를 참조
        Friend[] friends = new Friend[10];

        // Friend 객체 생성
        Friend f1 = new Friend();
        f1.setName("한주연");
        f1.setTel("0101-9209-1235");

        // UnivFriend 객체 생성
        UnivFriend f2 = new UnivFriend();
        f2.setName("주만성");
        f2.setTel("010-6316-2148");
        f2.setUnivName("우리학교");
        f2.setMajor("호텔관광학과");

        // CompanyFriend 객체 생성
        CompanyFriend f3 = new CompanyFriend();
        f3.setName("한찬우");
        f3.setTel("010-6000-0000");
        f3.setCompany("동아일보");
        f3.setDept("경제부");

        // 부모 클래스 배열에 자식 객체들을 추가
        friends[0] = f1;
        friends[1] = f2;
        friends[2] = f3;

        // 배열의 모든 Friend 객체에 대해 toString() 출력
        for (int i = 0; i < friends.length; i++) {
            if (friends[i] != null) {
                System.out.println(friends[i].toString());
            }
        }	
		
		//형변환
		int num = 20;
		double num2 = num; //자동 형변환 promotion
		num = (int) num2; //강제 형변환 casting
		
		//부모와 자식 사이에서도 casting 가능
		Friend f4 = new CompanyFriend("김무열", "010-0000-0000", "자회사", "인사팀");
		CompanyFriend cf = (CompanyFriend)f4; //부모 클래스의 변수를 자식클래스에 대입
		Friend f5 = new Friend("박성길", "010-1234-5678");
		
		if(f5 instanceof CompanyFriend) {			
			cf = (CompanyFriend) f5; //형변환 오류가 발생
			System.out.println(cf.getCompany());
		}else {
			System.out.println("Casting 할 수 없습니다.");
		}
		
	}//end of main().
}
