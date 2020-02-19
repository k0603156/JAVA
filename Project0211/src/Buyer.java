public class Buyer {
	Cart cart 		=new Cart();
	int money 		=1000;
	int bonusPoint	=0;
	int i 			=0;

	void buy(Product p) {
		System.out.println(	p.getClass().getTypeName());
		if(money<p.price) {
			showMoney();
			return;
		}
		money 		-=p.price;
		bonusPoint 	+=p.bonusPoint;
		showMoney();
		cart.ProductList.add(p);
	}

	void showMoney() {
		System.out.println(money+"/"+bonusPoint);
	}
	
}
