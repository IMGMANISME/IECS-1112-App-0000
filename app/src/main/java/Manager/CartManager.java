package Manager;

import java.util.ArrayList;
import java.util.List;

import Item.CartItem;

public class CartManager {
    private static CartManager instance;
    private List<CartItem> cartItemList;

    private CartManager() {
        cartItemList = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addToCart(CartItem item) {
        cartItemList.add(item);
    }

    public void removeFromCart(CartItem item) {
        cartItemList.remove(item);
    }

    public void clearCart() {
        cartItemList.clear();
    }
}

