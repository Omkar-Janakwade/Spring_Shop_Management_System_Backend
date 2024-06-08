package com.newproject.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.Entity.Admin;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	SessionFactory sf;

	@PostMapping("loginadmin")
	public boolean loginadmin(@RequestBody Admin admin) {
		Session s = sf.openSession();
		Admin admindatabase = s.get(Admin.class, admin.getName());
		if(admindatabase!=null) {
		if (admin != null) {

			if (admindatabase.equals(admin)) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}}else {
			Long adminCount = (Long) s.createQuery("select count(*) from Admin").uniqueResult();
            if (adminCount != null && adminCount == 0) {
                // Insert default admin value since the table is empty
                Admin defaultAdmin = new Admin();
                defaultAdmin.setName("omkar");
                defaultAdmin.setPassword("om@123"); // Set your default password
                s.beginTransaction();
                s.save(defaultAdmin);
                s.getTransaction().commit();
                return false; // Default admin inserted, return false for login attempt
 
		}else{
			return false;
				}
		}
	
	}

	@PostMapping("addadmin")
	public boolean addadmin(@RequestBody Admin admin) {

		if (admin != null) {
			try {
				Session s = sf.openSession();
				Transaction t = s.beginTransaction();
				s.persist(admin);
				t.commit();
				s.close();
				return true;
			} catch (Exception e) {
				return false;
			}

		} else {
			return false;
		}
	}
	
	@GetMapping("getalladmin")
	public List getalladmin() {
		Session s=sf.openSession();
		return s.createQuery("from Admin").list();
	}
}
