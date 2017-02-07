package chatochatbackend.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import chatochatbackend.model.Register;

@Repository
public class RegisterDAOImple implements RegisterDAOInter

{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void adduser(Register r)
	{
	System.out.println("dao");
			Session s=this.sessionFactory.getCurrentSession();
			s.save(r);
			s.flush();
		
	}
	

}
