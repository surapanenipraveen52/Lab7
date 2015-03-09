package org.mn;

import java.util.ArrayList;
import java.util.List;

import rita.wordnet.RiWordnet;

public class RelatedWords {

	public List<String> getRealtedWords(String word){
		List<String> synonms=new ArrayList<String>();
		RiWordnet wordnet = new RiWordnet(null);
		String[] poss = wordnet.getPos(word);
		for (int j = 0; j < poss.length; j++) {
			synonms.add("\n\nSynonyms for " + word + " (pos: " + poss[j] + ")");
			String[] synonyms = wordnet.getAllSynonyms(word,poss[j],10);
			for (int i = 0; i < synonyms.length; i++) {
				synonms.add(synonyms[i]);
			}   
		}
		return synonms;
	}
}
