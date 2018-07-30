package jp.com.internous.action;

public class Capsule {
	public static void main(String[] args){
		Person taro = new Person("山田太郎",20);
		System.out.println(taro.getName());
		taro.setName("鈴木太郎");
		System.out.println(taro.getName());
	}

}
