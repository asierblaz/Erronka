package eus.uni.dam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.support.QueryHintValue;

import model.postgres.ProductTemplate;
import model.postgres.ResPartner;
import model.postgres.SaleOrderLine;
import model.sqlserver.Bezeroa;
import model.sqlserver.Erosketa;
import model.sqlserver.Produktua;
import repo.sqlserver.SqlServerDao;

public class ControllerSqlServer {

	ApplicationContext sqlContext = new AnnotationConfigApplicationContext(SqlServerDatuBasearenKonfigurazioa.class);
	SqlServerDao sqlServerDao = sqlContext.getBean(SqlServerDao.class);

	public void produktuakToDB(List<ProductTemplate> produktuak) {
		for (ProductTemplate p : produktuak) {
			Produktua p1 = new Produktua(p.getId(), p.getProductCategory().getName(), p.getName(), p.getDefaultCode(),
					Float.parseFloat(p.getListPrice() + ""));

			sqlServerDao.updateProduktua(p1);

		}

	}

	public void bezeroakToDB(List<ResPartner> bezeroak) {

		for (ResPartner b : bezeroak) {
			String herrialdea = "";
			if (b.getResCountry() == null) {
				herrialdea = "Ezezaguna";

			} else {
				herrialdea = b.getResCountry().getName();
			}

			Bezeroa b1 = new Bezeroa(b.getId(), b.getEmailNormalized(), herrialdea, b.getName(), b.getPhoneSanitized());
			sqlServerDao.updateBezeroa(b1);
		}
	}

	public void erosketakToDB(List<SaleOrderLine> erosketak) {

		for (SaleOrderLine e : erosketak) {

			boolean fakturatua;
			if (e.getInvoiceStatus().equals("invoiced")) {
				fakturatua = true;
			} else {
				fakturatua = false;
			}

			Erosketa e1 = new Erosketa(e.getId(), e.getCreateDate(), fakturatua, e.getProductUomQty().intValue(),
					e.getOrderId(), e.getPriceTotal().floatValue());

			
			e1.setProduktua(sqlServerDao.getProduktuaById(e.getProductId()));
			e1.setBezeroa(sqlServerDao.getBezeroaById(e.getResPartner().getId()));
			sqlServerDao.updateErosketa(e1);

		}
	}

	public void erosketakXBainoGutxiago(List<SaleOrderLine> erosketak, int kantitatea) {

		for (SaleOrderLine e : erosketak) {

			boolean fakturatua;
			if (e.getInvoiceStatus().equals("invoiced")) {
				fakturatua = true;
			} else {
				fakturatua = false;
			}

			if (e.getProductUomQty().intValue() < kantitatea) {

				Erosketa e1 = new Erosketa(e.getId(), e.getCreateDate(), fakturatua, e.getProductUomQty().intValue(),
						e.getOrderId(), e.getPriceTotal().floatValue());

				e1.setProduktua(sqlServerDao.getProduktuaById(e.getProductId()));
				e1.setBezeroa(sqlServerDao.getBezeroaById(e.getResPartner().getId()));
				sqlServerDao.updateErosketa(e1);
			}
		}
	}

	public void deleteErosketaGuztiak() {
		sqlServerDao.deleteAllErosketak();
	}

	public void closeContext() {
		((AnnotationConfigApplicationContext) sqlContext).close();

	}
}
