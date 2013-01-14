package org.elasticsearch.index.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKTokenizer;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;

/**
 * Created by IntelliJ IDEA.
 * User: Medcl'
 * Date: 12-6-6
 * Time: 下午3:59
 */
public class IkTokenizerFactory extends AbstractTokenizerFactory {
    // private final IKAnalyzer analyzer;
    // private ESLogger logger=null;
    @Inject
    public IkTokenizerFactory(Index index, @IndexSettings Settings indexSettings,Environment env, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
        IKAnalyzer.getInstance().setEnvironment(env);
        //analyzer=new IKAnalyzer(false);
    }

    @Override
    public Tokenizer create(Reader reader) {
        Tokenizer _IKTokenizer = new IKTokenizer(reader , false);
        return _IKTokenizer;
    }
}
