package lk.ijse;

import lk.ise.config.FactoryConfiguration;
import lk.ise.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,1);
        // System.out.println(customer.getCid());
        // System.out.println(customer.getAddresses());

        transaction.commit();
        session.close();
    }
}
