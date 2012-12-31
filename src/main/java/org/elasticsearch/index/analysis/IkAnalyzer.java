package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.wltea.analyzer.lucene.IKTokenizer;

import java.io.Reader;


public class IkAnalyzer extends Analyzer {
   
    // @Override public TokenStream tokenStream(String fieldName, Reader reader) {            
    //     return new IKTokenizer(reader,true);
    // }
	@Override
	protected TokenStreamComponents createComponents(String fieldName, final Reader in) {
		Tokenizer _IKTokenizer = new IKTokenizer(in , true);
		return new TokenStreamComponents(_IKTokenizer);
	}
  
    public IkAnalyzer() {
        super(); 
    }


}
