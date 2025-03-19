package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookApp.Book;

public class MapExe {
    public static void main(String[] args) {
        // 1. 기본 Map 사용 예제
        Map<Integer, String> map = new HashMap<Integer, String>();
        
        // 객체 추가 (put)
        map.put(100, "홍길동");
        map.put(101, "김민수");
        map.put(102, "한주연");
        map.put(102, "한주동"); //동일한 키값이 등록되면 기존에 있던 값을 새로운 값으로 대체
        
        // 객체 삭제 (remove)
        map.remove(101);
        
        // 전체 요소 출력
        Set<Entry<Integer, String>> eset = map.entrySet();
        for (Entry<Integer, String> entry : eset) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        
        // 실행 중단 테스트 코드
        boolean run = true;
        if (run) {
            return;
        }
        
        // 2. Book 객체를 활용한 Map 사용 예제
        Map<String, Book> books = new HashMap<String, Book>();
        books.put("B001", new Book("이것이 자바다", "신용권", "한빛출", 20000));
        books.put("B002", new Book("자바스크립트", "김자바", "한빛출", 25000));
        books.put("B003", new Book("HTML,CSS", "한주연", "한빛출", 28000));
        
        // 특정 키 값으로 검색 조회
        Book result = books.get("B001");
        
        // 3. 전체 요소 출력 (keySet 이용)
        Set<String> keyset = books.keySet();
        for (String key : keyset) {
            System.out.println("key: " + key + ", val: " + books.get(key).showList());
        }
        
        // 4. 전체 요소 출력 (entrySet 이용)
        Set<Entry<String, Book>> entryset = books.entrySet();
        for (Entry<String, Book> entry : entryset) {
            System.out.println("key: " + entry.getKey() + ", val: " + entry.getValue().showList());
        }
        
        // 5. Gson을 활용한 객체 JSON 변환
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(result);
        System.out.println(json); // 객체 출력
    }
}