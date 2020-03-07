package Generics;
import java.util.*;

class Fruit2				{public String toString() {	return "Fruit";}}
class Apple2 extends Fruit2	{public String toString() {	return "Apple";}}
class Grape2 extends Fruit2 {public String toString() {	return "Grape";}}

class Juice {
	String name;
	Juice(String name){
		this.name= name+"Juice";
	}
	public String toString() {
		return this.name;
	}
}

class Box2<T>{
	ArrayList<T> list	= new ArrayList<T>()	;
	void addItem(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	ArrayList<T> getList(){
		return list;
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}

class FruitBox2<T extends Fruit2> extends Box2<T>{}

class Juicer {
	static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
		String tmp = "";
		
		for (Fruit2 f : box.getList())
			tmp += f+"";
		return new Juice(tmp);
		
	}
}

public class Ex12_4 {

	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
		
		fruitBox.addItem(new Apple2());
		fruitBox.addItem(new Grape2());
		appleBox.addItem(new Apple2());
		
		System.out.println(Juicer.makeJuice(fruitBox));
	}

}
