import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {

	public static List<Product> filterList(ArrayList<Product> productsList)
	{
        Predicate<Product> predicate = new Predicate<Product>() 
        {
            @Override
            public boolean test(Product p) 
            {                
                return (p.getCategory().equals("Books")) && (p.getPrice() > 100.0);
            }
        };
		Stream<Product> productsStream = productsList.stream();
		return productsStream.filter(predicate).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		ArrayList<Product> productsArray = new ArrayList<Product>();
		productsArray.add(new Product((long)1, "Name1", "Game", 200.0));
		productsArray.add(new Product((long)2, "Name2", "Books", 101.0));
		productsArray.add(new Product((long)3, "Name3", "Books", 99.0));
		productsArray.add(new Product((long)4, "Name4", "Jewelry", 111.0));
		productsArray.add(new Product((long)5, "Name5", "Books", 500.0));
		
		List<Product> filtered = filterList(productsArray);
		
		for (Product product : filtered) {
			System.out.println(product.getName());
		}
	}

}
