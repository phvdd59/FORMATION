package vdd.spring.beans.main;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vdd.spring.beans.musiciens.Joueur;

public class MainSpring {

	private static final Logger logger = Logger.getLogger(MainSpring.class);

	public static void main(String[] args) {

		// 1. Chargement du conteneur
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "orchestre.xml" });

		// 2. Recupération d'un bean
		Joueur musicien = (Joueur) appContext.getBean("Olivier");

		// 3. Manipulation du bean
		musicien.jouer();

		appContext.close();
	}
}
