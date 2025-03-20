package com.yedam.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MethodExe2 {
	// 필드
	private List<Product> store;

	// 생성자 : 필드의 값을 초기화
	MethodExe2() {
		init();
	}

	void init() {
		store = new ArrayList<Product>(); // new Product[10];
//		try {
//			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
//			while (true) {
//				String msg = scn.nextLine();
//				String[] msgAry = msg.split(" ");
//				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//
//		} // 초기화 끝
		
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			store = (List<Product>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 종료시점에 store 정보를 message.txt에 저장.
	void save() {
		// 입력값을 파일출력
//		try {
//			Writer writer = new FileWriter("c:/temp/message.txt");
//			for (Product prd : store) {
//				String msg = prd.getProductCode() + " " + prd.getProductName() + " " + prd.getPrice();
//				writer.write(msg + "\n");
//				writer.flush();
//			}
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		

		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(store);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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