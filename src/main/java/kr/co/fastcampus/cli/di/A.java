package kr.co.fastcampus.cli.di;

public class A {
	private B b;
	
	public A(B b) { //积己磊 林涝 规过 
		this.b = b;
	
	}
	
	public void print() {
		System.out.println(b.calc());
	}
}
