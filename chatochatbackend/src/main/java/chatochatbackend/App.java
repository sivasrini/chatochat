package chatochatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chatochatbackend.dao.RegisterDAOImple;
import chatochatbackend.dao.RegisterDAOInter;
import chatochatbackend.model.Register;

public class App {
	
	@Autowired

	public static void main( String[] args )
    {
		
    	/*AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	
       context.scan("chatochatbackend.config");
       context.refresh();
       RegisterDAOInter obj= (RegisterDAOInter) context.getBean("registerdaoimple");
     
       Register ob=new Register();
       ob.setEmail("siva@123.com");
       ob.setMobilenumber("9444576636");
       ob.setName("siva");
       ob.setPassword("siva123");
       obj.adduser(ob);*/
       
       

}

}