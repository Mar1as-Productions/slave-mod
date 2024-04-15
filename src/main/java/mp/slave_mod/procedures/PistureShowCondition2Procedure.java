package mp.slave_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;

import mp.slave_mod.entity.EncagedOtrokEntity;
import mp.slave_mod.entity.EncagedOtrok2Entity;
import mp.slave_mod.SlaveModModElements;
import mp.slave_mod.SlaveModMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@SlaveModModElements.ModElement.Tag
public class PistureShowCondition2Procedure extends SlaveModModElements.ModElement {
	public PistureShowCondition2Procedure(SlaveModModElements instance) {
		super(instance, 138);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure PistureShowCondition2!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure PistureShowCondition2!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure PistureShowCondition2!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure PistureShowCondition2!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return ((((Entity) world
				.getEntitiesWithinAABB(EncagedOtrokEntity.CustomEntity.class,
						new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) && ((((Entity) world
						.getEntitiesWithinAABB(EncagedOtrok2Entity.CustomEntity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) == (false)));
	}
}
