package PojoClasses;

import com.fasterxml.jackson.annotation.JsonAlias;

public class DetailedProduct extends Product{
	private Product product;
	@JsonAlias("current-stock")
	private int currentStock;
	private double price;
	private String manufacturer;
	
	public DetailedProduct() {
		
	}
	public DetailedProduct(int id, String category, String name, String manufacturer, double price, int stock, boolean instock) {
		this.id=id;
		this.category=category;
		this.name=name;
		this.manufacturer=manufacturer;
		this.price=price;
		this.currentStock = stock;
		this.inStock=instock;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public boolean equals(Object obj) {
	  if (obj == this) {
            return true;
        }
 
       if (!(obj instanceof DetailedProduct)) {
            return false;
        }
         
       DetailedProduct product = (DetailedProduct) obj;
         
       return this.category.equals(product.category) && this.name.equals(product.name) && this.id == product.id && this.inStock == product.inStock
    		   && this.currentStock == product.currentStock && this.price == product.price && this.manufacturer.equals(product.manufacturer);
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
