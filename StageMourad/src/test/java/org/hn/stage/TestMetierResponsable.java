package org.hn.stage;

import static org.junit.Assert.assertTrue;

import org.hc.stage.entities.acteurs.Utilisateur;
import org.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import org.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import org.hc.stage.metier.responsable.InterfaceMetierUtilisateur;
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
			InterfaceMetierUtilisateur metierResponsable = (InterfaceMetierUtilisateur) context.getBean("metierResponsable");
			
			/************ ajouter responsable ***********/
			
			Utilisateur utilisateur = new Utilisateur("responsable","BAHLOUL","Mourad");
			Long idRes = metierResponsable.ajouterNouveauResponsable(utilisateur);	
			utilisateur.setId(idRes);
			
			
           /************ test ajouter type demande avec l'historique ***********/
			
		    TypeDemande typeDemande = new TypeDemande("passeport");			
			metierResponsable.ajouterNouveauTypeDemande(typeDemande, utilisateur);	
			utilisateur.setId(idRes);
			
			/************ test ajouter type document avec l'historique***********/
			
			DocumentTypeDemande documentTypeDemande = new DocumentTypeDemande("photocopie de carte d'identitier",true,typeDemande);
			metierResponsable.AjouterNouveauTypeDocumentDemande(documentTypeDemande, utilisateur);	
			
			/************ test ajout type prerequis avec l'historique ***********/
			
			PrerequisTypeDemande prerequisTypeDemande = new PrerequisTypeDemande("nom",true,typeDemande);
			metierResponsable.AjouterNouveauTypePrerequis(prerequisTypeDemande, utilisateur);
			
		     assertTrue(true);
			 		
		 }catch(Exception e)
		 {
			 assertTrue(e.getMessage(),false);
		 }
	}

}
