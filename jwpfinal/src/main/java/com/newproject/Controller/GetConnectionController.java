package com.newproject.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
import com.newproject.Entity.GetConnection;


@RestController
@CrossOrigin("http://localhost:4200")
public class GetConnectionController {

	@Autowired
	SessionFactory sf;
	
	@PostMapping("storeConnection")
	public ResponseEntity<Boolean> GetConnectiondata(@RequestBody GetConnection getconnection) {
		try {
		Session ss=sf.openSession();
		Transaction t=ss.beginTransaction();
		ss.save(getconnection);
		t.commit();
		ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return response;
		} catch (Exception e) {
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return response;
		}
	} 
	
	@GetMapping("getconnection/{fullname}")
	public GetConnection getconnection(@PathVariable String fullname) {
		Session ss=sf.openSession();
		Transaction t=ss.beginTransaction();
		GetConnection connection=ss.get(GetConnection.class, fullname);
		t.commit();
		
		return connection;
	}
	
	
	@DeleteMapping("deleteconnection/{fullname}")
	public ResponseEntity<Boolean> deleteconn(@PathVariable String fullname) {
		try {

		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		GetConnection connn=s.get(GetConnection.class, fullname);
		if (connn!=null) {
		s.delete(connn);
		t.commit();
		ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return response;
		}else {
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			return response;
		}
		} catch (Exception e) {
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			return response;
		}
	}
	@PutMapping("updateconnection")
	public ResponseEntity<Boolean> updateconnection(@RequestBody GetConnection connection) {
		try {
			
		
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(connection);
		t.commit();
		ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return response;
		} catch (Exception e) {
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return response;
		}
	}
	
	@GetMapping("getallconnection")
	public List<GetConnection> getallconnection() {
		Session s=sf.openSession();
		return s.createQuery("from GetConnection").list();
	}
	
}
