package jp.co.internous.action;

public class Test {
	public static void main(String[] args){
		Person taro = new Person();
		taro.name="山田太郎";
		taro.age=20;
		taro.phoneNumber="090-1111-2222";
		taro.address="東京";
		System.out.print(taro.name);
		System.out.println(taro.age);
		System.out.print(taro.phoneNumber);
		System.out.println(taro.address);
		taro.talk();
		taro.walk();
		taro.run();
		System.out.println();


		Person jiro = new Person();
		jiro.name="木村次郎";
		jiro.age=18;
		jiro.phoneNumber="090-9974-2222";
		jiro.address="千葉";
		System.out.print(jiro.name);
		System.out.println(jiro.age);
		System.out.print(jiro.phoneNumber);
		System.out.println(jiro.address);
		jiro.talk();
		jiro.walk();
		jiro.run();
		System.out.println();

		Person hana = new Person();
		hana.name="鈴木花子";
		hana.age=16;
		hana.phoneNumber="090-5555-2222";
		hana.address="神奈川";
		System.out.print(hana.name);
		System.out.println(hana.age);
		System.out.print(hana.phoneNumber);
		System.out.println(hana.address);
		hana.talk();
		hana.walk();
		hana.run();
		System.out.println();

		Person yuki = new Person();
		yuki.name="千代田結希";
		yuki.age=18;
		yuki.phoneNumber="090-24239-2222";
		yuki.address="埼玉";
		System.out.print(yuki.name);
		System.out.println(yuki.age);
		System.out.print(yuki.phoneNumber);
		System.out.println(yuki.address);
		yuki.talk();
		yuki.walk();
		yuki.run();
		System.out.println();
		
		Robot aibo = new Robot();
		aibo.name="アイボ";
		aibo.talk();
		aibo.walk();
		aibo.run();
		System.out.println();
		
		Robot asimo = new Robot();
		asimo.name="アシモ";
		asimo.talk();
		asimo.walk();
		asimo.run();
		System.out.println();
		
		Robot pepper = new Robot();
		pepper.name="ペッパー";
		pepper.talk();
		pepper.walk();
		pepper.run();
		System.out.println();
		
		Robot doraemon = new Robot();
		doraemon.name="ドラえもん";
		doraemon.talk();
		doraemon.walk();
		doraemon.run();
		System.out.println();

	}

}
