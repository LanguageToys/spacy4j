package edu.guym.spacyj.api.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import edu.guym.spacyj.api.containers.Doc;

import static com.fasterxml.jackson.annotation.PropertyAccessor.*;

public class SpacyJacksonModule extends SimpleModule {

    public SpacyJacksonModule() {
        ObjectMapper mapper = new ObjectMapper()
                .setVisibility(ALL, JsonAutoDetect.Visibility.NONE)
                .setVisibility(CREATOR, JsonAutoDetect.Visibility.ANY)
                .setVisibility(FIELD, JsonAutoDetect.Visibility.ANY);
        addSerializer(Doc.class, new DocSerializer(mapper));
        addDeserializer(Doc.class, new DocDeserializer(mapper));
    }
}
