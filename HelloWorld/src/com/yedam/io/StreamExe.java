package com.yedam.io;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		// 임력+출력=> 복사
		try {
			InputStream is = new FileInputStream("C:/temp/cat.jpg");
			OutputStream os = new FileOutputStream("C:/temp/cat3.jpg");
			
			byte[] buf = new byte[100];

			while (true) {
				int data = is.read(buf);
				if (data == -1) {
					break;
				}
				os.write(buf);
				os.flush();
			}
			is.close();
			os.close();
			System.out.println("사진이 복사되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("End of program");
	}// End of main

	static void write() {
		// 출력 스트림(바이트) --> OutputStream --> write 사용
		try {
			OutputStream os = new FileOutputStream("C:/temp/data.bin");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End of program");
	}

	static void read() {
		// 입력 스트림(바이트) --> InputStream --> read 사용
		try {
			InputStream is = new FileInputStream("C:/temp/data.bin");
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End of program");
	}
}
