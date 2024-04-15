package mp.slave_mod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import mp.slave_mod.SlaveModModElements;
import mp.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class EbolaActiveTickConditionProcedure extends SlaveModModElements.ModElement {
	public EbolaActiveTickConditionProcedure(SlaveModModElements instance) {
		super(instance, 145);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency entity for procedure EbolaActiveTickCondition!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.STARVE, (float) 2);
	}
}
