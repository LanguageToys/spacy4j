package io.languagetoys.spacy4j.api;

import io.languagetoys.spacy4j.api.containers.Doc;
import io.languagetoys.spacy4j.api.containers.TokenData;
import io.languagetoys.spacy4j.api.exceptions.SpaCyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

final class SpaCyImpl implements SpaCy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SpaCyAdapter adapter;

    public SpaCyImpl(SpaCyAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public final Doc nlp(String text) throws SpaCyException {
        Objects.requireNonNull(text);
        try {
            List<TokenData> data = adapter.nlp(text);
            return Doc.create(text, data);
        } catch (Throwable e) {
            logger.error("failed to parse text", e);
            throw new SpaCyException(e, text);
        }
    }
}
