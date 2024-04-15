
package mp.slave_mod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import mp.slave_mod.entity.NegroMinionEntity;
import mp.slave_mod.SlaveModModElements;
import mp.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class SpawnNegroMinionProcedure extends SlaveModModElements.ModElement {
	public SpawnNegroMinionProcedure(SlaveModModElements instance) {
		super(instance, 147);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure SpawnNegroMinion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure SpawnNegroMinion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure SpawnNegroMinion!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure SpawnNegroMinion!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double count = 0;
		double new_x = 0;
		double new_y = 0;
		double new_z = 0;
		double sance = 0;
		count = (double) Math.floor(((Math.random() * 5) + 1));
		for (int index0 = 0; index0 < (int) (count); index0++) {
			new_x = (double) (x + (Math.floor(((Math.random() * 5) + 1)) * Math.pow((-1), Math.floor(((Math.random() * 2) + 1)))));
			new_y = (double) (y + 1);
			new_z = (double) (z + (Math.floor(((Math.random() * 5) + 1)) * Math.pow((-1), Math.floor(((Math.random() * 2) + 1)))));
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new NegroMinionEntity.CustomEntity(NegroMinionEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(new_x, new_y, new_z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				entityToSpawn.setMotion(0, 0, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (!world.getWorld().isRemote) {
				world.playSound(null, new BlockPos((int) new_x, (int) new_y, (int) new_z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("slave_mod:whip")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				world.getWorld().playSound(new_x, new_y, new_z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("slave_mod:whip")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ENCHANTED_HIT, new_x, new_y, new_z, (int) 5, 3, 3, 3, 1);
			}
		}
	}
}
