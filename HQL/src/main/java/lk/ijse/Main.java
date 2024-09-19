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

        Query query = session.createQuery("from Customer");

        List<Customer> customerList = query.list();
        for (Customer customer : customerList) {
            System.out.println(customer.getCid());
        }

        // unique one data from customer
        Query query1 = session.createQuery("from Customer where cid = ?1");
        query1.setParameter(1, 1);
        Customer customer = (Customer) query1.uniqueResult();

        System.out.println(customer.getCid());

        // load only on column
    /*  Query query2 = session.createQuery("select cid from Customer where cid = ?1");
        query1.setParameter(1, 1);
        Customer customer1 = (Customer) query2.uniqueResult();

        System.out.println(customer1.getName());  */

        //Insert
        Query query2 = session.createQuery("insert into Customer(cid,name) values(?1,?2)");
        query1.setParameter(1,6);
        query1.setParameter(2,"Piyal");
        query1.executeUpdate();

        //Update
        /*  Query query3 = session.createQuery("update Customer set name=?1 where cid=?2");
        query2.setParameter(1,"Chethika");
        query2.setParameter(2,4);
        query2.executeUpdate(); */

        //delete
        /*  Query query4 = session.createQuery("delete from Customer where cid=?1");
        query.setParameter(1,5);
        query.executeUpdate();  */

        //
        /*  Query query5 = session.createQuery("select cid, name from Customer where cid = ?1");
        query5.setParameter(1, 1);
        Object[] customers = (Object[]) query5.uniqueResult();
        for(Object o : customers){
            System.out.println(o);
        }   */

        //
        /*  Query query6 = session.createQuery("select cid, name from Customer");
        List<Object[]>customer1 = query6.list();
        for (Object[] objects : customer1) {
            System.out.println(Arrays.toString(objects));
        }   */

        //
        /*  Query query7 = session.createQuery("select cid, name from Customer where cid = ?1");
        List<Object[]>customer2 = query7.list();
        for (Object[] objects : customer2) {
            System.out.println(Arrays.toString(objects));
        }   */

        transaction.commit();
        session.close();
    }
}
