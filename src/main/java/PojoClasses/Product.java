package PojoClasses;

public class Product {
	protected int id;
	protected String category;
	protected String name;
	protected boolean inStock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
	  if (obj == this) {
            return true;
        }
 
       if (!(obj instanceof Product)) {
            return false;
        }
         
       Product product = (Product) obj;
         
       return this.category.equals(product.category) && this.name.equals(product.name) && this.id == product.id && this.inStock == product.inStock;
	}
}
