package lk.ijse;


import lk.ise.config.FactoryConfiguration;
import lk.ise.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //select
        /*  Query query = session.createQuery("select c from Customer c");
        List<Customer> customers = query.list();
        for (Customer customer : customers) {
            System.out.println(customer);
        }*/



        transaction.commit();
        session.close();
    }
}
