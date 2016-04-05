package org.hn.stage;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.hn.stage.Mitier.InterfaceMetier;
import org.hn.stage.entities.Client;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testJpa {
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}
	@Test
	public void test1() {
	 try{
			
		 InterfaceMetier metier = (InterfaceMetier) context.getBean("metier");
		 int tailleList = metier.listClient().size() ;
		 metier.ajouterClient(new Client("nazih","hamila",null,"hamila@gmail.com","hamila","hamila"));
		
		 assertTrue(metier.listClient().size() == tailleList + 1 );
		 		
	 }catch(Exception e)
	 {
		 assertTrue(e.getMessage(),false);
	 }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
	 try{
			
		 InterfaceMetier metier = (InterfaceMetier) context.getBean("metier");
         Client client = metier.getClient((long) 1);
         client.setDateNaissance(new SimpleDateFormat("yyyy/MM/dd").parse("1990/04/20"));
         metier.modifierClient(client);
         
		 assertTrue(true);
		 		
	 }catch(Exception e)
	 {
		 assertTrue(e.getMessage(),false);
	 }
	}

}
