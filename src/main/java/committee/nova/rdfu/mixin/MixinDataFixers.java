package committee.nova.rdfu.mixin;

import com.mojang.datafixers.DataFixer;
import committee.nova.rdfu.FakeDataFixer;
import net.minecraft.util.datafix.DataFixers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DataFixers.class)
public abstract class MixinDataFixers {
    /**
     * @author Tapio borrowed from Vazkii
     * @reason Remove DFU
     */
    @Overwrite
    private static DataFixer createFixerUpper() {
        return new FakeDataFixer();
    }
}
