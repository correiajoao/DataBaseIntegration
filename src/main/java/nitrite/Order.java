package nitrite;


import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

/**
 * A test Pojo representing a imaginary class Instance.
 * @version 1.0 28-Sep-2016
 */
@Indices({
        @Index(value = "CustomerID", type = IndexType.Unique)
})
public class Order {
    @Id
    private long CustomerID;
    private String EmployeeID;
    private String OrderDate;
    private String RequiredDate;
    private String ShipVia;
    private String Freight;
    private String ShipName;
    private String ShipAddress;
    private String ShipCity;
    private String ShipRegion;
    private String ShipPostalCode;
    private String ShipCountry;

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        RequiredDate = requiredDate;
    }

    public String getShipVia() {
        return ShipVia;
    }

    public void setShipVia(String shipVia) {
        ShipVia = shipVia;
    }

    public String getFreight() {
        return Freight;
    }

    public void setFreight(String freight) {
        Freight = freight;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String shipAddress) {
        ShipAddress = shipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String shipCity) {
        ShipCity = shipCity;
    }

    public String getShipRegion() {
        return ShipRegion;
    }

    public void setShipRegion(String shipRegion) {
        ShipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return ShipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        ShipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return ShipCountry;
    }

    public void setShipCountry(String shipCountry) {
        ShipCountry = shipCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (CustomerID != order.CustomerID) return false;
        if (EmployeeID != null ? !EmployeeID.equals(order.EmployeeID) : order.EmployeeID != null) return false;
        if (OrderDate != null ? !OrderDate.equals(order.OrderDate) : order.OrderDate != null) return false;
        if (RequiredDate != null ? !RequiredDate.equals(order.RequiredDate) : order.RequiredDate != null) return false;
        if (ShipVia != null ? !ShipVia.equals(order.ShipVia) : order.ShipVia != null) return false;
        if (Freight != null ? !Freight.equals(order.Freight) : order.Freight != null) return false;
        if (ShipName != null ? !ShipName.equals(order.ShipName) : order.ShipName != null) return false;
        if (ShipAddress != null ? !ShipAddress.equals(order.ShipAddress) : order.ShipAddress != null) return false;
        if (ShipCity != null ? !ShipCity.equals(order.ShipCity) : order.ShipCity != null) return false;
        if (ShipRegion != null ? !ShipRegion.equals(order.ShipRegion) : order.ShipRegion != null) return false;
        if (ShipPostalCode != null ? !ShipPostalCode.equals(order.ShipPostalCode) : order.ShipPostalCode != null)
            return false;
        return ShipCountry != null ? ShipCountry.equals(order.ShipCountry) : order.ShipCountry == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (CustomerID ^ (CustomerID >>> 32));
        result = 31 * result + (EmployeeID != null ? EmployeeID.hashCode() : 0);
        result = 31 * result + (OrderDate != null ? OrderDate.hashCode() : 0);
        result = 31 * result + (RequiredDate != null ? RequiredDate.hashCode() : 0);
        result = 31 * result + (ShipVia != null ? ShipVia.hashCode() : 0);
        result = 31 * result + (Freight != null ? Freight.hashCode() : 0);
        result = 31 * result + (ShipName != null ? ShipName.hashCode() : 0);
        result = 31 * result + (ShipAddress != null ? ShipAddress.hashCode() : 0);
        result = 31 * result + (ShipCity != null ? ShipCity.hashCode() : 0);
        result = 31 * result + (ShipRegion != null ? ShipRegion.hashCode() : 0);
        result = 31 * result + (ShipPostalCode != null ? ShipPostalCode.hashCode() : 0);
        result = 31 * result + (ShipCountry != null ? ShipCountry.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return " \nCustomerID=" + CustomerID +
                "\nEmployeeID='" + EmployeeID + '\'' +
                "\nOrderDate='" + OrderDate + '\'' +
                "\nRequiredDate='" + RequiredDate + '\'' +
                "\nShipVia='" + ShipVia + '\'' +
                "\nFreight='" + Freight + '\'' +
                "\nShipName='" + ShipName + '\'' +
                "\nShipAddress='" + ShipAddress + '\'' +
                "\nShipCity='" + ShipCity + '\'' +
                "\nShipRegion='" + ShipRegion + '\'' +
                "\nShipPostalCode='" + ShipPostalCode + '\'' +
                "\nShipCountry='" + ShipCountry + "'\n";

    }
}