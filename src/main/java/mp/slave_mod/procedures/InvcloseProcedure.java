package mp.slave_mod.procedures;

import net.minecraft.entity.Entity;

import mp.slave_mod.SlaveModModElements;
import mp.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class InvcloseProcedure extends SlaveModModElements.ModElement {
	public InvcloseProcedure(SlaveModModElements instance) {
		super(instance, 143);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency entity for procedure Invclose!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("otroksber", 0);
	}
}
