import java.util.Set;

public class Product 
{
	private Long id;
	private String name;
	private String category;
	private Double price;
	private Set<Order> orders;
	
	Product(Long id, String name, String category, Double price)
	{
		this.category = category;
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
// add getters to be able to read variables from external object	
	public String getName()
	{
		return this.name;	
	}
	
	public String getCategory()
	{
		return this.category;	
	}
	
	public Long getId()
	{
		return this.id;	
	}
	
	public Double getPrice()
	{
		return this.price;	
	}
	
	public Set<Order> getOrders()
	{
		return this.orders;
	}
}
