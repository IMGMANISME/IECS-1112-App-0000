package Domain;

public class CheckDomain {

    private String meal_name;
    private int meal_num;
    private int meal_price;

    public CheckDomain(String meal_name, int meal_num, int meal_price) {
        this.meal_name = meal_name;
        this.meal_num = meal_num;
        this.meal_price = meal_price;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public int getMeal_num() {
        return meal_num;
    }

    public void setMeal_num(int meal_num) {
        this.meal_num = meal_num;
    }

    public int getMeal_prices() {
        return meal_price;
    }

    public void setMeal_prices(int meal_price) {
        this.meal_price = meal_price;
    }
}
