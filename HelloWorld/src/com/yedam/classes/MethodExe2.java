package com.yedam.classes;

import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	// 필드
	private List<Product> store;

	// 생성자 : 필드의 값을 초기화
	MethodExe2() {
		store = new ArrayList<Product>(); // new Product[10];
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프", 1000));
		store.add(new Product("C001", "연필", 800));
		store.add(new Product("D001", "지우개", 1000));
		store.add(new Product("E001", "지우개", 2000));
	}

	// 메소드
	boolean add(Product prd) { // void add(Product prd) void를 boolean으로 바꾼 이유 찾아보기
		boolean result = store.add(prd);
		return result;
	}// End of add(Product prd)

	// 목록 상품이름, ALL
	List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<Product>(); // new Product[10];
		for (int i = 0; i < store.size(); i++) {
			if (prd.getProductName().equals("ALL") || store.get(i).getProductName().equals(prd.getProductName())) {
				// 상품의 가격이 조건으로 추가됨
				if (store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));
				}
			}
		}
		return list;
	}// End of productList

	// 삭제(상품코드) => boolean remove(String code)
	boolean remove(String code) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false;
	}// End of remove

	// 수정 => boolean modify(Product prod)
	boolean modify(Product prod) {
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getProductCode().equals(prod.getProductCode())) {
				// 상품명 수정
				if (prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				// 상품가격 수정
				if (prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}// End of modify
}