package committee.nova.rdfu;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.TaggedChoice;
import com.mojang.datafixers.types.templates.TypeTemplate;
import com.mojang.serialization.Dynamic;
import net.minecraft.SharedConstants;

import java.util.Map;
import java.util.function.Supplier;

public class FakeDataFixer implements DataFixer {
    private static final FakeSchema SCHEMA = new FakeSchema();

    @Override
    public <T> Dynamic<T> update(DSL.TypeReference type, Dynamic<T> input, int version, int newVersion) {
        return input;
    }

    @Override
    public Schema getSchema(int key) {
        return SCHEMA;
    }

    private static class FakeSchema extends Schema {
        public FakeSchema() {
            super(SharedConstants.getCurrentVersion().getDataVersion().getVersion(), null);
        }

        @Override
        public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
            return Map.of();
        }

        @Override
        public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema schema) {
            return Map.of();
        }

        @Override
        public void registerTypes(Schema schema, Map<String, Supplier<TypeTemplate>> entityTypes, Map<String, Supplier<TypeTemplate>> blockEntityTypes) {

        }

        @Override
        protected Map<String, Type<?>> buildTypes() {
            return Map.of();
        }

        @Override
        public Type<?> getType(DSL.TypeReference type) {
            return null;
        }

        @Override
        public Type<?> getChoiceType(DSL.TypeReference type, String choiceName) {
            return null;
        }

        @Override
        public Type<?> getTypeRaw(DSL.TypeReference type) {
            return null;
        }

        @Override
        public TaggedChoice.TaggedChoiceType<?> findChoiceType(DSL.TypeReference type) {
            return null;
        }
    }
}
