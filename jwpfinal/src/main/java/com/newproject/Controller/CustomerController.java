package com.newproject.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.Entity.GetConnection;

@RestController
@CrossOrigin("http://localhost:4200")
public class CustomerController {

	@Autowired
	SessionFactory sf;

	@GetMapping("login/{fullname}/{password}")
	public ResponseEntity<Boolean> loginCustomer(@PathVariable String fullname, @PathVariable String password) {
		try {
			
		
		Session s = sf.openSession();
		GetConnection conn = s.get(GetConnection.class, fullname);
		if (conn != null && conn.getPassword().equals(password)) {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.OK);
			return response;
		} else {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.OK);
			return response;

		}
		} catch (Exception e) {
			ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.OK);
			return response;
		}
	}
	@GetMapping("updatepassword/{fullname}/{password}")
	public ResponseEntity<Boolean> updatepassword(@PathVariable String password,@PathVariable String fullname) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		if(fullname!=null&&password!=null) {
			GetConnection get=s.get(GetConnection.class, fullname);
			if(get!=null) {
		Query query=s.createQuery("update GetConnection set password =:password where fullname=:fullname");
		query.setParameter("password", password);
		query.setParameter("fullname", fullname);
		int updatedRows = query.executeUpdate();
		if(updatedRows>0) {
			t.commit();
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(true,HttpStatus.OK);
			return response;}else {
				t.commit();
				ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
				return response;
			}
			
		}else {
			t.commit();
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return response;
		}
		}
		else{
			ResponseEntity<Boolean> response=new ResponseEntity<Boolean>(false,HttpStatus.OK);
			return response;
		}
		
	}
	

}
