import java.util.Vector;

 class Cart{
		Vector<Product> ProductList = new Vector<Product>();
		int sum=0;
		
		void showCart() {
			System.out.println("==========");
			if(ProductList.isEmpty()) return;
			ProductList.forEach(product->{
				System.out.println(product.getClass().getTypeName());
				sum+=product.price;
			});
			System.out.println("cost:"+sum);
		}
		void addProduct(Product p) {
			ProductList.add(p);
		}
		void removeProduct(Product p) {
			ProductList.remove(p);
		}

}