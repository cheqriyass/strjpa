package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double total;
    private List<Product> productList = new ArrayList<>();
    public Command() {
    }

    public Command(long id, double total) {
        this.id = id;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Product_Customer",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void calcTotal(){
        total=0;
        for(Product prd : productList){
            total+=prd.getPrice();
        }
    }
}
