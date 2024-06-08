package com.newproject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.event.spi.DeleteEventListener;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.Entity.DailyTransaction;
import com.newproject.Entity.GetConnection;

@RestController
@CrossOrigin("http://localhost:4200")
public class TransactionController {

	String fullname;

	@Autowired
	SessionFactory sf;

	@PostMapping("addtransaction")
	public boolean addtransaction(@RequestBody DailyTransaction transaction) {
		try {

			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.persist(transaction);
			t.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("allname")
	public List allname() {
		Session s = sf.openSession();
		return s.createQuery("select fullname from GetConnection").list();

	}

	@GetMapping("gettransactions/{fullname}")
	public List gettransaction(@PathVariable String fullname) {
		this.fullname = fullname;
		Session s = sf.openSession();
		Query<DailyTransaction> query = s.createQuery("from DailyTransaction where fullname = :fullname",
				DailyTransaction.class);
		query.setParameter("fullname", fullname);

		return query.list();

	}

	@DeleteMapping("deletedcusdata")
	public Boolean deletemany() {
		if (fullname != null) {
			try {
				List<DailyTransaction> deletelist = gettransaction(fullname);
				Session s = sf.openSession();
				Transaction t = s.beginTransaction();

				for (DailyTransaction dailyTransaction : deletelist) {
					DailyTransaction loadedEntity = s.load(DailyTransaction.class, dailyTransaction.getTransactionId());

					s.delete(loadedEntity);

				}
				t.commit();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}
}
