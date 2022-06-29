package Account;
import java.util.*;

public class Vendor extends Account{
    private String brandName;
    private Map<Product, Integer> inventory;
    private Product[] showCase;
    private List<Order> orders;



    public Vendor(String firstName, String lastName, String email, String password, String brandName) {
        super(firstName, lastName, email, password);
        this.brandName = brandName;
        this.inventory = new HashMap<>();
        this.showCase = new Product[5];
        this.orders = new ArrayList<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    public Product[] getShowCase() {
        if(showCase == null){
            this.addProductToShowcase();
        }

            return showCase;

    }

    public  void setShowCaseLessThanFive(){

           showCase = (Product[])inventory.values().toArray();

    }

    public void setShowCaseMoreThanFire() {
        Set<Product> temp = inventory.keySet();

        for(int i = 0; i < temp.size(); i++) {
            Object object = temp.toArray()[i];
            if(object instanceof Product) {
                showCase[i] = (Product) object;
            }
        }

    }

    public void addProductToShowcase() {
        Set<Product> temp = inventory.keySet();
        if(inventory.size() >= 5){
            this.setShowCaseMoreThanFire();
        }
        else{
            this.setShowCaseLessThanFive();
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public void addProduct(Product product) {
        Product key = product;
        if (inventory.containsKey(key)) {
            inventory.put(key, inventory.get(key) + 1);
        } else {
            inventory.put(product, 1);
        }
    }
//need clarity
    public boolean modifyProduct(Product product) {
        if(this.getInventory().containsKey(product)){
            return false;
        }
        else {
            inventory.put(product, inventory.get(product) - 1) ;
        }
        return true;
    }


    public  boolean removeProduct(String productName) {
        inventory.remove(productName);
        return inventory.containsKey(productName) ;

    }



    public List<Product> searchByCategory(ProductCategory productCategory) {
        List<Product> categoryList = new ArrayList<>();
        for(Product product: getInventory().keySet()){
          if (product.getCategory() == productCategory) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }


    public List<Product> searchByName(String productName) {
        List<Product> categoryList = new ArrayList<>();
        for(Product product:getInventory().keySet()){
           if (product.getName() == productName) {
                categoryList.add(product);
            }
        }
        return categoryList;
    }

    public Product purchase(Order order) {
        //decreases inventory by one;
        this.modifyProduct(order.getProduct());
        order.setStatus(OrderStatus.PENDING);
        orders.add(order);
        return order.getProduct() ;
    }

    public String displayAllOrders() {
        String allOrders = "";
        for (Order order: getOrders()) {
            allOrders += order.toString() + "\n";
        }
        return allOrders;
    }




    @Override
    public String toString() {
        return  brandName  + " " + inventory + " " + Arrays.toString(showCase) + " " + orders;
    }
}