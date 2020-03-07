
public class Run {

	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		Audio audio = new Audio();
		Computer computer =new Computer();
		TV tv =new TV();
		
		buyer.cart.addProduct(audio);
		buyer.cart.addProduct(computer);
		buyer.cart.addProduct(computer);
		buyer.cart.addProduct(computer);
		buyer.cart.addProduct(computer);
		buyer.cart.addProduct(tv);

		buyer.cart.removeProduct(computer);

		
		buyer.cart.showCart();
	}	

}
