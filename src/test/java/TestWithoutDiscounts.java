import org.junit.Before;
import org.junit.Test;
import com.shop.RetailStore.core.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test Cases for no discount policy for any type and just to see if cart is working
 */
public class TestWithoutDiscounts {

    private ShoppingCart cart;
    private Item item;

    @Before
    public void setUp() {
    	User user = new User(UserType.SIMPLE, "Ravi");
        cart = new ShoppingCart(user);
        item = new Product("something", 10, ItemType.OTHER);
    }

    @Test
    public void test_emptyCartCostsZero() {
        assertEquals(0, cart.total(), 0.01);
    }

    @Test
    public void test_singleBasicItemCostsItsUnitPrice() {
        cart.add(item);
        assertEquals(item.getUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_multipleBasicItemsCostProportionally() {
        int howMany = 3;
        cart.add(item, howMany);
        assertEquals(howMany * item.getUnitPrice(), cart.total(), 0.01);
    }

    @Test
    public void test_separatelyAdding() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            cart.add(item);
        }
        assertEquals(howMany * item.getUnitPrice(), cart.total(), 0.01);
    }
}
