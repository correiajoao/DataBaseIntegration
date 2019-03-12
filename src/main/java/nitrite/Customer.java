package nitrite;


import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import java.io.Serializable;

/**
 * A test Pojo representing a imaginary class Instance.
 * @version 1.0 28-Sep-2016
 */
@Indices({
        @Index(value = "CustomerID", type = IndexType.Unique)
})
public class Customer implements Serializable {
    @Id
    private long CustomerID;
    private String CompanyName;
    private String ContactName;
    private String ContactTitle;
    private String Phone;

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long customerID) {
        CustomerID = customerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String contactTitle) {
        ContactTitle = contactTitle;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (CustomerID != customer.CustomerID) return false;
        if (CompanyName != null ? !CompanyName.equals(customer.CompanyName) : customer.CompanyName != null)
            return false;
        if (ContactName != null ? !ContactName.equals(customer.ContactName) : customer.ContactName != null)
            return false;
        if (ContactTitle != null ? !ContactTitle.equals(customer.ContactTitle) : customer.ContactTitle != null)
            return false;
        return Phone != null ? Phone.equals(customer.Phone) : customer.Phone == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (CustomerID ^ (CustomerID >>> 32));
        result = 31 * result + (CompanyName != null ? CompanyName.hashCode() : 0);
        result = 31 * result + (ContactName != null ? ContactName.hashCode() : 0);
        result = 31 * result + (ContactTitle != null ? ContactTitle.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nCustomerID=" + CustomerID +
                "\nCompanyName='" + CompanyName + '\'' +
                "\nContactName='" + ContactName + '\'' +
                "\nContactTitle='" + ContactTitle + '\'' +
                "\nPhone='" + Phone + "'\n";
    }
}