package Domain;

public class MenuDomain {
    private int food_img;
    private String food_name;
    private String food_price;

    public MenuDomain(int food_img, String food_name, String food_price) {
        this.food_img = food_img;
        this.food_name = food_name;
        this.food_price = food_price;
    }

    public int getFood_img() {
        return food_img;
    }

    public void setFood_img(int food_img) {
        this.food_img = food_img;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

}
