package org.hn.stage;


import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.metier.responsable.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetier {
	
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}	
	@Test
	public void testImpMetierClient(){
		InterfaceMetierResponsable metierResponsable = (InterfaceMetierResponsable) context.getBean("metierClientllll");
         metierResponsable.createResponsable(new Responsable("responsable general", "Bahloul", "Mourad"));
		
		
	}

}
