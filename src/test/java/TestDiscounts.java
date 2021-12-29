import org.junit.Before;
import org.junit.Test;
import com.shop.RetailStore.core.*;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test Cases for no discount policy
 */
public class TestDiscounts {

    private Item groceryItem;
    private Item otherItem;
    private User employee;
    private User affiliate;
    private User simpleUser;
    private User simpleUserWith2Years;

    @Before
    public void setUp() {
    	employee = new User(UserType.EMPLOYEE, "Ravi");
    	affiliate = new User(UserType.AFFILIATE, "Raj");
    	simpleUser = new User(UserType.SIMPLE, "Sunny");
    	simpleUserWith2Years = new User(UserType.SIMPLE, "Sandeep", LocalDateTime.of(2014, 7, 19, 6, 40, 45));
        groceryItem = new Product("Rice", 20, ItemType.GROCERY);
        otherItem = new Product("TV", 222, ItemType.OTHER);
     }

    @Test
    public void test_employeeWithGrocery() {
        ShoppingCart cart = new ShoppingCart(employee);
        cart.add(groceryItem, 4);
        // No discount because of grocery item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_employeeWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(employee);
        cart.add(otherItem, 4);
        /*
         *  30% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 30% discount = 621.6
         *  After 30 dollars off due to price over $600 = 591.6 
         */
        assertEquals(591.6, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithGrocery() {
        ShoppingCart cart = new ShoppingCart(affiliate);
        cart.add(groceryItem, 4);
        // No discount because of grocery item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(affiliate);
        cart.add(otherItem, 4);
        /*
         *  10% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 10% discount = 799.2
         *  After 35 dollars off due to price over $700 = 591.6 
         */
        assertEquals(764.2, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWithGrocery() {
        ShoppingCart cart = new ShoppingCart(simpleUser);
        cart.add(groceryItem, 4);
        // No discount because of grocery item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(simpleUser);
        cart.add(otherItem, 4);
        /*
         *  Total 222 * 4 = 888
         *  No percentage discount because user is a customer for less than 2 years
         *  After 40 dollars off due to price over $800 = 848 
         */
        assertEquals(848, cart.total(), 0.01);        
    }
    
    @Test
    public void test_simpleUserWith2YearsWithGrocery() {
        ShoppingCart cart = new ShoppingCart(simpleUserWith2Years);
        cart.add(groceryItem, 4);
        // No discount because of grocery item
        assertEquals(80, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWith2YearsWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(simpleUserWith2Years);
        cart.add(otherItem, 4);
        /*
         *  5% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 5% discount = 843.6
         *  After 40 dollars off due to price over $800 =803.6 
         */
        assertEquals(803.6, cart.total(), 0.01);
        
    }
    
    @Test
    public void test_employeeWithGroceryAndOtherItem() {
        ShoppingCart cart = new ShoppingCart(employee);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        /*
         *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on grocery items = 968 still
         *  After 30% discount on 4 other items totalling 888 = 701.6
         *  After 35 dollars off due to price over $700 =666.6 
         */
        assertEquals(666.6, cart.total(), 0.01);
        
    }
}
