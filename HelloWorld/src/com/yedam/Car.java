package com.yedam;

public class Car {
	private String brand;
	private int speed;
	
	public Car(String brand) {
		this.brand = brand;
		this.speed = 0;
	}
	
	public void accelerate() {
		speed += 10;
		System.out.println(brand + "가속! 현재속도: " + speed + " km/h");
	}
	
	public void brake() {
		if(speed >= 10) {
			speed -= 10;
		} else {
			speed = 0;
		}
		System.out.println(brand + "감속! 현재속도: " + speed + " km/h");
	}
	
	public void showInfo() {
		System.out.println(brand  + "자동차의 현재속도: " + speed + "km/h");
	}
}
