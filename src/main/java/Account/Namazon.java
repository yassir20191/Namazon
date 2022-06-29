package Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Namazon {
    private List<Customer> customers;
    private List<Vendor> vendors;


    public Namazon() {
        this.customers = new ArrayList<>();
        this.vendors  = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }


    public Optional <Account> signInTo(String email, String password) {
        for(Vendor vendor: vendors){
            if(vendor.getEmail() == email && vendor.getPassword() == password){
                return Optional.of(vendor);
            }
        }

        for(Customer customer: customers){
            if(customers.getEmail() == email && customers.getPassword() == password){
                return Optional.of(customer);
            }
        }

        return Optional.empty();

    }

    public Vendor signUpAsVendor(String firstName, String lastName, String email, String passWord, String brandName) {
        Vendor vendorAccount = new Vendor(brandName, firstName, lastName, email, passWord);
        vendors.add(vendorAccount);
        return vendorAccount;
        
    }

    public Customer signUpAsCustomer(String firstName, String lastName, String email, String passWord) {
        Customer customerAccount = new Customer(firstName, lastName, email, passWord);
        getCustomers().add(customerAccount);
        getAccounts().add(customerAccount);
        return customerAccount;
    }

    public Vendor selectVendor(String vendorName) {
        Vendor selectedVendor = null;
        for(Vendor vendor: getVendors()) {
            if(vendor.getBrandName().equals(vendorName)) {
                selectedVendor = vendor;
            }
        }
        return selectedVendor;
    }

    @Override
    public String toString() {
        return "customers= " + customers +
                ", vendors= " + vendors +
                ", accounts= " + accounts;
    }
}
