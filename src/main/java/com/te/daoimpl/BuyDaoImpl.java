package com.te.daoimpl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.te.dao.BuyDao;
import com.te.model.Sale;
import com.te.model.SaleStatus;
@Repository
public class BuyDaoImpl implements BuyDao{
	 @Autowired
	    private HibernateTemplate hibernateTemplate;
	@Override
	public void createSaleTransaction(Sale sale) {
		hibernateTemplate.save(sale);
		
	}
	@Override
	public List<Sale> getAllSales() {

	    return hibernateTemplate.loadAll(Sale.class);
	}
	@Override
	public List<Sale> searchSales(Integer saleId, Integer customerId, Integer vehicleId) {

	    String hql = "FROM Sale s WHERE "
	            + "(:saleId IS NULL OR s.id = :saleId) AND "
	            + "(:customerId IS NULL OR s.customerId.id = :customerId) AND "
	            + "(:vehicleId IS NULL OR s.vehicleId.id = :vehicleId)";

	    return hibernateTemplate.execute(session ->
	            session.createQuery(hql, Sale.class)
	                   .setParameter("saleId", saleId)
	                   .setParameter("customerId", customerId)
	                   .setParameter("vehicleId", vehicleId)
	                   .list()
	    );
	}
	@Override
	public Map<String, Object> getSalesReport() {

	    Map<String, Object> report = new LinkedHashMap<>();

	    String totalHql = "SELECT COUNT(s) FROM Sale s";

	    Long total = hibernateTemplate.execute(
	        (HibernateCallback<Long>) session ->
	            session.createQuery(totalHql, Long.class).uniqueResult()
	    );

	    String completedHql =
	        "SELECT COUNT(s) FROM Sale s WHERE s.saleStatus = :status";

	    Long completed = hibernateTemplate.execute(
	        (HibernateCallback<Long>) session ->
	            session.createQuery(completedHql, Long.class)
	                .setParameter("status", SaleStatus.COMPLETED)
	                .uniqueResult()
	    );

	    String valueHql =
	        "SELECT SUM(s.vehicleId.price) FROM Sale s WHERE s.saleStatus = :status";

	    BigDecimal salesValue = hibernateTemplate.execute(
	        (HibernateCallback<BigDecimal>) session ->
	            session.createQuery(valueHql, BigDecimal.class)
	                .setParameter("status", SaleStatus.COMPLETED)
	                .uniqueResult()
	    );

	    if (salesValue == null) {
	        salesValue = BigDecimal.ZERO;
	    }

	    report.put("Total Sales", total);
	    report.put("Completed Sales", completed);
	    report.put("Total Sales Value", salesValue);

	    return report;
	}

}
