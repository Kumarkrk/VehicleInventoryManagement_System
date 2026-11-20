package com.te.daoimpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.te.dao.ReserveDao;
import com.te.model.Reservation;
import com.te.model.ReservationStatus;
@Repository
public class ReserveDaoImpl implements ReserveDao{
    @Autowired
    HibernateTemplate hibernateTemplate;
	@Override
	public void createReservation(Reservation reservation) {
		hibernateTemplate.save(reservation);
		
		
		
	}
	@Override
	public List<Reservation> getAllReservations() {

	    return hibernateTemplate.loadAll(Reservation.class);
	}
	@Override
	public List<Reservation> searchReservations(Integer customerId, Integer vehicleId) {

	    String hql = "FROM Reservation r WHERE "
	            + "(:customerId IS NULL OR r.customerId.id = :customerId) AND "
	            + "(:vehicleId IS NULL OR r.vehicleId.id = :vehicleId)";

	    return hibernateTemplate.execute(session ->
	            session.createQuery(hql, Reservation.class)
	                   .setParameter("customerId", customerId)
	                   .setParameter("vehicleId", vehicleId)
	                   .list()
	    );
	}

	@Override
	public void cancelReservation(int id) {
		try {
			Reservation reserve=hibernateTemplate.get(Reservation.class, id);
			hibernateTemplate.delete(reserve);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	@Override
	public Reservation getReservationById(int id)
	{
		Reservation reserve=hibernateTemplate.get(Reservation.class, id);
		return reserve;
	}
    @Override
	public void updateReservation(Reservation reservation) {
		  hibernateTemplate.update(reservation);
		
	}
    @Override
    public Map<String, Long> getReservationReport() {

        Map<String, Long> report = new LinkedHashMap<>();

        String hql = "SELECT COUNT(r) FROM Reservation r";

        Long total =(Long) hibernateTemplate.execute(
            (HibernateCallback<Long>) session ->
                session.createQuery(hql, Long.class).uniqueResult()
        );

        String statusHql =
            "SELECT COUNT(r) FROM Reservation r WHERE r.reserveStatus = :status";

        Long confirmed = hibernateTemplate.execute(
            (HibernateCallback<Long>) session ->
                session.createQuery(statusHql, Long.class)
                    .setParameter("status", ReservationStatus.CONFIRMED)
                    .uniqueResult()
        );

        Long cancelled = hibernateTemplate.execute(
            (HibernateCallback<Long>) session ->
                session.createQuery(statusHql, Long.class)
                    .setParameter("status", ReservationStatus.CANCELLED)
                    .uniqueResult()
        );

        Long completed = hibernateTemplate.execute(
            (HibernateCallback<Long>) session ->
                session.createQuery(statusHql, Long.class)
                    .setParameter("status", ReservationStatus.COMPLETED)
                    .uniqueResult()
        );

        report.put("Total Reservations", total);
        report.put("Confirmed Reservations", confirmed);
        report.put("Cancelled Reservations", cancelled);
        report.put("Completed Reservations", completed);

        return report;
    }

}
