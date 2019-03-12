package nitrite;

import java.util.List;
import org.dizitart.no2.*;
import org.dizitart.no2.objects.ObjectRepository;

import static org.dizitart.no2.objects.filters.ObjectFilters.*;

public class NitriteManager {
    private static NitriteManager nitriteManager = new NitriteManager();

    private NitriteManager() {

    }

    public static NitriteManager getInstance() {
        return nitriteManager;
    }

    //java initialization
    Nitrite db = Nitrite.builder()
            .compressed()
            .filePath("test.db")
            .openOrCreate("user", "password");

    ObjectRepository<Customer> customerDB = db.getRepository(Customer.class);
    ObjectRepository<Order> orderDB = db.getRepository(Order.class);

    public void loadData(){

        Customer customer = new Customer();
        customer.setCustomerID(1);
        customer.setCompanyName("Juarez Store");
        customer.setContactName("João Correia");
        customer.setContactTitle("Marketing Manager");
        customer.setPhone("(82) 999999999");
        customerDB.insert(customer);

        customer = new Customer();
        customer.setCustomerID(2);
        customer.setCompanyName("Juarez Store");
        customer.setContactName("José Silva ");
        customer.setContactTitle("Marketing Manager");
        customer.setPhone("(82) 999999888");
        customerDB.insert(customer);

        customer = new Customer();
        customer.setCustomerID(3);
        customer.setCompanyName("Great Fast Food");
        customer.setContactName("Mario Andrade");
        customer.setContactTitle("Sale Representative");
        customer.setPhone("(82) 999779888");
        customerDB.insert(customer);

        customer = new Customer();
        customer.setCustomerID(4);
        customer.setCompanyName("Great Fast Food");
        customer.setContactName("Biu Moraes");
        customer.setContactTitle("Marketing Manager");
        customer.setPhone("(82) 999929888");
        customerDB.insert(customer);

        customer = new Customer();
        customer.setCustomerID(5);
        customer.setCompanyName("Juarez Store");
        customer.setContactName("Carlos Oliveira");
        customer.setContactTitle("Sale Representative");
        customer.setPhone("(82) 999119888");
        customerDB.insert(customer);


        Order order = new Order();
        order.setCustomerID(1);
        order.setEmployeeID("6");
        order.setOrderDate("11-12-1983");
        order.setShipAddress("Rua do centro");
        order.setShipCity("Maceio");
        order.setShipPostalCode("57401-060");
        order.setShipCountry("FL");
        orderDB.insert(order);

        order = new Order();
        order.setCustomerID(2);
        order.setEmployeeID("5");
        order.setOrderDate("11-12-1982");
        order.setShipAddress("Rua do lado");
        order.setShipCity("Rio Largo");
        order.setShipPostalCode("57701-060");
        order.setShipCountry("UK");
        orderDB.insert(order);

        order = new Order();
        order.setCustomerID(3);
        order.setEmployeeID("22");
        order.setOrderDate("11-03-1987");
        order.setShipAddress("Rua sem nome");
        order.setShipCity("União dos Palmares");
        order.setShipPostalCode("57701-090");
        order.setShipCountry("GR");
        orderDB.insert(order);

        order = new Order();
        order.setCustomerID(4);
        order.setEmployeeID("21");
        order.setOrderDate("01-07-1977");
        order.setShipAddress("Rua sem nome");
        order.setShipCity("União dos Palmares");
        order.setShipPostalCode("57701-090");
        order.setShipCountry("USA");
        orderDB.insert(order);

        order = new Order();
        order.setCustomerID(5);
        order.setEmployeeID("20");
        order.setOrderDate("03-05-1917");
        order.setShipAddress("Rua com nome");
        order.setShipCity("Palmeira dos Índios");
        order.setShipPostalCode("57001-090");
        order.setShipCountry("BR");
        orderDB.insert(order);
    }

    public String executeQueryOrder(String tag, String value, String function) {
        try {
            String query = null;
            List<Order> orders = null;

            if(tag.contains("/")){
                tag = tag.split("/")[1];
            }

            if(function.equals("contains")){
                orders = orderDB.find(regex(tag, value)).toList();
            }else if(function.equals("equals")){
                orders = orderDB.find(eq(tag, value)).toList();
            }
            String output = "";
            for (Order ord: orders) {
                output += ord.toString();
            }

            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String executeQueryCustomer(String tag, String value, String function) {
        try {
            String query = null;
            List<Customer> customers = null;

            if(tag.contains("/")){
                tag = tag.split("/")[1];
            }

            if(function.equals("contains")){
                System.out.println("contains: " + tag + " " + value);
                customers = customerDB.find(regex(tag, value)).toList();
            }else if(function.equals("equals")){
                System.out.println("equals: "+ tag + " " + value);
                customers = customerDB.find(eq(tag, value)).toList();
            }

            String output = "";
            for (Customer cus: customers) {
                output += cus.toString();
            }
            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
