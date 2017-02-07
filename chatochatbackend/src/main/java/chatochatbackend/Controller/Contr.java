package chatochatbackend.Controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import chatochatbackend.dao.RegisterDAOInter;
import chatochatbackend.model.Register;

@RestController
public class Contr {
	
	
	RegisterDAOInter ob;
	
	public Contr()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	
	       context.scan("chatochatbackend.config");
	       context.refresh();
		
		
	}
	
	@RequestMapping(value="/index/{name}/{email}/{password}/{mobilenumber}", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Register> add(@PathVariable String name, @PathVariable String email, @PathVariable String password, @PathVariable String mobilenumber)
	{
	
		Register r=new Register();
		r.setEmail(email);
		r.setMobilenumber(mobilenumber);
		r.setName(name);
		r.setPassword(password);
		ob.adduser(r);
		return new ResponseEntity<Register>(HttpStatus.OK);
	}

}
