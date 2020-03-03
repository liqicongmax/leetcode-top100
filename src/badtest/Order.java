package badtest;

public class Order {
    private String id;
    private String company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String conpany) {
        this.company = conpany;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
