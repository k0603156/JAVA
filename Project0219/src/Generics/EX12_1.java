package Generics;

import java.util.*;

class Product{}
class Tv extends Product{}
class Audio extends Product{}

public class EX12_1 {

	public static void main(String[] args) {
		ArrayList<Product>	productList = new ArrayList<Product>();
		ArrayList<Tv>		tvList		= new ArrayList<Tv>();
		ArrayList<Audio>	audioList	= new ArrayList<Audio>();
		
		productList.add(new Tv());
		productList.add(new Audio());
		
		tvList.add(new Tv());
		tvList.add(new Tv());
		
		printAll(productList);
//		printAll(tvList);
		
		
	}

	private static void printAll(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		for (Product p : productList) {
			System.out.println(p);
		}
	}

}
