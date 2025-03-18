package com.yedam.api;

public class StringUtil {
	// 1.성별
	static String getGender(String ssn) {
		int pos = -1;
		if (ssn.length() == 13) {
			pos = 6;
		} else if (ssn.length() == 14) {
			pos = 7;
		}

		char gender = ssn.charAt(pos);
		switch (gender) {
		case '1':
		case '3':
			return "남자입니다.";
		case '2':
		case '4':
			return "여자입니다.";
		default:
			return "알수없음";
		}
	}

	// 2.파일명
	static String getFileName(String file) {
		return getFileName2(file);
	}

	// 2-1.파일명가져오기 방법1
	static String getFileName1(String file) {
		int pos = 0;
		String fileName = "";
		while (true) {
			int idx = file.indexOf("/", pos);
			if (idx == -1) {
				fileName = file.substring(pos, file.indexOf("."));
				break;
			}
			pos = idx + 1;
		}
		return fileName;
	}

	// 2-2.파일명가져오기 방법2
	static String getFileName2(String file) {
		String fileName = "";
		fileName = file.substring(file.lastIndexOf("/") + 1, file.indexOf("."));
		return fileName;
	}

	// 3.파일확장자
	static String getExtName(String file) {
		String ext = file.substring(file.indexOf(".") + 1);
		return ext;
	}
}
