package eu.tl1.injection.tp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.injectors.MultiInjection;


public class MainPicoContainer {

	public static void main(String[] args) {
		List<String> text = new ArrayList<String>();
		
		text.add("Ceci est la premier ligne");
		text.add("Ceci est la deuxi�me ligne");
		text.add("Cette ligne termine le texte");
		
		//Injection par constructeur
		DefaultPicoContainer container = new DefaultPicoContainer( new MultiInjection() );
		
		//Ajout de la classe
		container.addComponent(TextReader.class);
		
		//Références Interface -> Implementation à appliquer sur la classe concrète déclarée au dessus
		// "Sur ce container le TextAnalyzer doit etre remplacé par un WordIndexer"
		container.addComponent(TextAnalyzer.class, WordIndexer.class);
		
		//En paramétrant le set dans le WordIndexer on peut y injecter un TreeSet
		//qui triera naturellement les entrées avec el comparateur natif String (ordre alphabétique)
		container.addComponent(Set.class, TreeSet.class);
		
		//Pour une autre implémentation il faut créer un autre conteneur
		
		// Initialiser d'un objet à partir d'un conteneur
		TextReader txtRdr = container.getComponent(TextReader.class);
		
		//Tet de sa méthode
		txtRdr.scan(text);
		
		System.out.println(txtRdr.getResult());
		// [Ceci, Cette, deuxi�me, est, la, le, ligne, premier, termine, texte]


}

}
