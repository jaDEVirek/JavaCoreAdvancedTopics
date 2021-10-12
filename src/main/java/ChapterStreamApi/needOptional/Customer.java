package ChapterStreamApi.needOptional;


import java.util.Objects;

public class Customer {
    private String fName;
    private String lName;
    private String customerAddress;
    private int billAmount;

    public Customer(String fName, String lName, String customerAddress, int billAmount) {
        this.fName = fName;
        this.lName = lName;
        this.customerAddress = customerAddress;
        this.billAmount = billAmount;
    }

    public Customer(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getBillAmount() == customer.getBillAmount() && Objects.equals(getfName(),
                customer.getfName()) && Objects.equals(getlName(),
                customer.getlName()) && Objects.equals(getCustomerAddress(), customer.getCustomerAddress());
    }

    @Override public int hashCode() {
        return Objects.hash(getfName(), getlName(), getCustomerAddress(), getBillAmount())*31/7;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("fName='")
                .append(fName)
                .append('\'');
        sb.append(", lName='")
                .append(lName)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
