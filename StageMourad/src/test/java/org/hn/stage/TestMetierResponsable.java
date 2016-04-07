package org.hn.stage;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hn.stage.entities.acteurs.Responsable;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDemande;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypeDocument;
import org.hn.stage.entities.historisationsDesTypes.HistoriqueTypePrerequis;
import org.hn.stage.entities.typeDemandes.DocumentTypeDemande;
import org.hn.stage.entities.typeDemandes.PrerequisTypeDemande;
import org.hn.stage.entities.typeDemandes.TypeDemande;
import org.hn.stage.metier.InterfaceMetierResponsable;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMetierResponsable {
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}	
	@Test
	public void testImpMetierResponsable() {
		try{
			boolean testRecu = false ;
			InterfaceMetierResponsable metierResponsable = (InterfaceMetierResponsable) context.getBean("metierResponsable");
			int tailleListAvantInsertion = metierResponsable.listHTD().size() ;
			Long idRes =  metierResponsable.ajouterResponsable(new Responsable("Responsable general","Bahloul","Mourad"));
			
			/************ test ajout type demande avec ajout historique type demande ***********/
			
			Long id = metierResponsable.ajouterTyD(new TypeDemande("test ajouter une nouvelle demande"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = dateFormat.parse("2016-04-07");
			HistoriqueTypeDemande hTD = new HistoriqueTypeDemande("ajouter",date,"premier type de demande");
			metierResponsable.ajouterHTD(hTD, idRes, id);
			int tailleListApresinsertion = metierResponsable.listHTD().size() ;
			testRecu = tailleListApresinsertion == tailleListAvantInsertion+ 1 ;
			
			/************ test ajout type document avec ajout historique type demande ***********/
			
			id = metierResponsable.ajouterDTD(new DocumentTypeDemande("photocopie piece identite",true));
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        date = dateFormat.parse("2016-04-07");
			HistoriqueTypeDocument htD = new HistoriqueTypeDocument("ajouter",date,"premier type de document");
			metierResponsable.ajouterHTDoc(htD, idRes, id);
			tailleListApresinsertion = metierResponsable.listHTD().size() ;
			testRecu = tailleListApresinsertion == tailleListAvantInsertion+ 1 ;
			
			/************ test ajout type document avec ajout historique type demande ***********/
			
			id = metierResponsable.ajouterPTD(new PrerequisTypeDemande("nom",true));
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        date = dateFormat.parse("2016-04-07");
			HistoriqueTypePrerequis hTP = new HistoriqueTypePrerequis("ajouter",date,"premier type de prerequis");
			metierResponsable.ajouterHTP(hTP, idRes, id);
			tailleListApresinsertion = metierResponsable.listHTD().size() ;
			testRecu = tailleListApresinsertion == tailleListAvantInsertion+ 1 ;
			 
			assertTrue(testRecu);
			 		
		 }catch(Exception e)
		 {
			 assertTrue(e.getMessage(),false);
		 }
		}

}
