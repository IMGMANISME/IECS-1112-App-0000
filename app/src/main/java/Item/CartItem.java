package Item;

public class CartItem {
    private int itemImg;
    private String itemName;
    private int itemPrice;

    public CartItem(int itemImg,String itemName, int itemPrice) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemImg() {
        return itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }
}


