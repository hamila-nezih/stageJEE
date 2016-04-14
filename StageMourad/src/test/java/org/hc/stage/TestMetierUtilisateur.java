package org.hc.stage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hc.stage.entities.acteurs.Utilisateur;
import com.hc.stage.entities.types.typesDeDemandes.DocumentTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.PrerequisTypeDemande;
import com.hc.stage.entities.types.typesDeDemandes.TypeDemande;
import com.hc.stage.metier.utilisateur.InterfaceMetierUtilisateur;

public class TestMetierUtilisateur {
	ClassPathXmlApplicationContext context ;
	@org.junit.Before
	public void setUp() throws Exception
	{
		context =
				 new ClassPathXmlApplicationContext(
						 new String[]{"applicationContext.xml"});
	}	
	@Test
	public void testImpMetierUtilisateur() {
		try{
			InterfaceMetierUtilisateur metierUtilisateur = (InterfaceMetierUtilisateur) context.getBean("metierUtilisateur");
			
			/************ ajouter utilisateur ***********/
			
			Utilisateur utilisateur = new Utilisateur("utilisateur","BAHLOUL","Mourad");
			Long idRes = metierUtilisateur.ajouterNouvelUtilisateur(utilisateur);	
			utilisateur.setId(idRes);
			
			
           /************ test ajouter type demande avec l'historique ***********/
			
		    TypeDemande typeDemande = new TypeDemande("passeport",true);	
			metierUtilisateur.ajouterNouveauTypeDemande(typeDemande, utilisateur);	
			utilisateur.setId(idRes);
			
			/************ test ajouter type document ***********/
			
			DocumentTypeDemande documentTypeDemande = new DocumentTypeDemande("photocopie de carte d'identitier",true,typeDemande);
			metierUtilisateur.AjouterNouveauTypeDocumentDemande(documentTypeDemande, utilisateur);	
			
			/************ test ajout type prerequis ***********/
			
			PrerequisTypeDemande prerequisTypeDemande = new PrerequisTypeDemande("nom",true,typeDemande);
			metierUtilisateur.AjouterNouveauTypePrerequis(prerequisTypeDemande, utilisateur);
			
		     assertTrue(true);
			 		
		 }catch(Exception e)
		 {
			 assertTrue(e.getMessage(),false);
		 }
	}

}
