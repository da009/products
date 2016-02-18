import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if (findProduct(id) != null)
        {
            findProduct(id).increaseQuantity(amount);
        }
        else
        {
            System.out.println("No hay producto para esa ID de producto.");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     * with a matching ID.
     */
    public Product findProduct(int id)
    {
        int cont = 0;
        boolean hay = false;
        Product producto = null;
        while (cont < stock.size() && !hay)
        {
            if (stock.get(cont).getID() == id)
            {
                producto = stock.get(cont);
                hay = true;
            }
            cont++;
        }
        return producto;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int amount = 0;
        if (findProduct(id) != null)
        {
            amount = findProduct(id).getQuantity();
        }
        return amount;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product producto: stock)
        {
            System.out.println(producto.toString());
        }
    }
}
