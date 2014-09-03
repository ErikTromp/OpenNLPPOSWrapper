package com.et4it;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class POSWrapper {
	POSTaggerME tagger;

	public POSWrapper(String language) throws IOException {
		// Load the model
		InputStream modelIn = this.getClass().getResourceAsStream(
				"/" + language + "-pos-perceptron.bin");
		POSModel model = new POSModel(modelIn);
		tagger = new POSTaggerME(model);
		modelIn.close();
	}

	/**
	 * Tags an array of tokens
	 * 
	 * @param tokens
	 *            The tokens
	 * @return The POS tags
	 */
	public String[] tag(String[] tokens) {
		return tagger.tag(tokens);
	}

	/**
	 * Tags a sentence by splitting on space
	 * 
	 * @param sentence
	 *            The sentence
	 * @return The POS tags
	 */
	public String[] tag(String sentence) {
		return tag(sentence.split(" "));
	}
}
