package lk.ise;

import lk.ise.config.FactoryConfiguration;
import lk.ise.entity.Address;
import lk.ise.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Customer customer1 = new Customer();
       customer1.setCid(1);
       customer1.setName("sherul");

        Customer customer2 = new Customer();
        customer2.setCid(2);
        customer2.setName("shenal");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);


        Address address1 = new Address();
        address1.setAid(1);
        address1.setNo("100");
        address1.setRoad("peters");
        address1.setCity("Maggona");

        Address address2 = new Address();
        address2.setAid(2);
        address2.setNo("101");
        address2.setRoad("pieris");
        address2.setCity("Panadura");

        List<Address> addresses = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);

        customer1.setAddresses(addresses);
        customer2.setAddresses(addresses);

        address1.setCustomer(customers);
        address2.setCustomer(customers);






        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(address1);
        session.save(address2);
        session.save(customer1);
        session.save(customer2);

        transaction.commit();
        session.close();
        }
    }
