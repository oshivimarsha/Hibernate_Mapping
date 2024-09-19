package lk.ise;

import lk.ise.config.FactoryConfiguration;
import lk.ise.entity.Address;
import lk.ise.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //make customer object
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Sherul");
        //customer.setAddress(address);


        //make address object
        Address address = new Address();
        address.setAid(1);
        address.setNo("123/1");
        address.setRoad("Peter's road");
        address.setCity("Maggona");
        address.setCustomer(customer);




        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);
        session.save(address);
        transaction.commit();
        session.close();

        }
    }
