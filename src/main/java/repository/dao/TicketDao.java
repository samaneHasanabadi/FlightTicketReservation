package repository.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import repository.entity.Ticket;

import java.util.Date;
import java.util.List;

public class TicketDao {
    private static TicketDao instance;

    public static TicketDao getInstance() {
        if(instance == null){
            synchronized (TicketDao.class){
                if(instance == null){
                    instance = new TicketDao();
                }
            }
        }
        return instance;
    }
    public void creat(Ticket t){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        session.close();
    }

    public Ticket read(int id){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Ticket t = (Ticket) session.get(Ticket.class, id);
        transaction.commit();
        session.close();
        return t;
    }

    public void update(Ticket t){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    public void delete(Ticket t){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    public List<Ticket> searchTickets(String name, String family, Date from, Date to, int flightNumber, String destination, String origin, int minPrice, int maxPrice, String company){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Ticket.class);
        if(name != null)
            criteria.add(Restrictions.eq("name", name));
        if(family!= null)
            criteria.add(Restrictions.eq("family", name));
        if(from != null)
            criteria.add(Restrictions.ge("date", from));
        if(to != null)
            criteria.add(Restrictions.le("date", to));
        if(flightNumber > 0)
            criteria.add(Restrictions.eq("flightNumber", flightNumber));
        if(destination != null)
            criteria.add(Restrictions.eq("destination", destination));
        if(origin != null)
            criteria.add(Restrictions.eq("origin", origin));
        if(minPrice > 0)
            criteria.add(Restrictions.ge("price", minPrice));
        if(maxPrice > 0)
            criteria.add(Restrictions.eq("price", maxPrice));
        if(company != null)
            criteria.add(Restrictions.eq("company", company));
        List list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    }

    public List<Ticket> showAllTickets() {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<Ticket> query = session.createQuery("from Ticket", Ticket.class);
        List<Ticket> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    public void deleteAllTickets(){
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Ticket");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
