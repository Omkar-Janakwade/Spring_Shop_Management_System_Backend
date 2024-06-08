package com.newproject.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newproject.Entity.BookOrder;

@RestController
@CrossOrigin("http://localhost:4200")
public class BookOrderController {

	@Autowired
	SessionFactory sf;

	@PostMapping("bookorderdata")
	public ResponseEntity<Boolean> bookorderdata(@RequestBody BookOrder order) {
		try {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
	
		ss.persist(order);
		t.commit();
	
		//ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return ResponseEntity.ok(true);
		} catch (Exception e) {
			e.printStackTrace();
		//	ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}

	@GetMapping("getorder/{fullname}")
	public BookOrder getorder(@PathVariable String fullname) {
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Query query = ss.createQuery("FROM BookOrder WHERE fullname = :fullname");
		query.setParameter("fullname", fullname);
		BookOrder order = (BookOrder) query.uniqueResult();
		t.commit();
		System.out.println(order);
		return order;
	}

	@DeleteMapping("deleteorder/{fullname}")
	public ResponseEntity<Boolean> deleteorder(@PathVariable String fullname) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		try {

			Query query = s.createQuery("from BookOrder where fullname = :fullname");
			query.setParameter("fullname", fullname);
			int order = query.executeUpdate();
			if (order != 0) {
				for (int i = 1; i <= order; i++) {
					s.delete(order);
				}

				t.commit();

				ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.OK);
				return response;
			} else {
				t.rollback(); 
				s.close();
				ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.OK);
				return response;
			}
		} catch (Exception e) {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.OK);
			return response;
		} finally {
			s.close();
		}

	}

	@GetMapping("getAllorder")
	public List<BookOrder> getallorder() {
		Session s = sf.openSession();

		return s.createQuery("from BookOrder").list();
	}

	@PutMapping("updateorder")
	public ResponseEntity<Boolean> updateorder(@RequestBody BookOrder order) {
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.update(order);
			t.commit();
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.OK);
			return response;

		} catch (Exception e) {
			e.printStackTrace();
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.OK);
			return response;
		}
	}
}
