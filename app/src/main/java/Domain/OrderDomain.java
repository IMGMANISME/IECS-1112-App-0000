package Domain;

public class OrderDomain {

    private int order_pic;
    private String order_date;
    private String order_price;
    private String order_status;

    public OrderDomain(int order_pic, String order_date, String order_price, String order_status) {
        this.order_pic = order_pic;
        this.order_date = order_date;
        this.order_price = order_price;
        this.order_status = order_status;
    }

    public int getOrder_pic() {
        return order_pic;
    }

    public void setOrder_pic(int order_pic) {
        this.order_pic = order_pic;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
