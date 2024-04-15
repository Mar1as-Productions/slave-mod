package mp.slave_mod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import mp.slave_mod.item.NigraniumSwordItem;
import mp.slave_mod.item.NigraniumShovelItem;
import mp.slave_mod.item.NigraniumPickaxeItem;
import mp.slave_mod.item.NigraniumHoeItem;
import mp.slave_mod.item.NigraniumAxeItem;
import mp.slave_mod.SlaveModModElements;
import mp.slave_mod.SlaveModMod;

import java.util.Map;
import java.util.HashMap;

@SlaveModModElements.ModElement.Tag
public class NegromancerEntityIsHurtProcedure extends SlaveModModElements.ModElement {
	public NegromancerEntityIsHurtProcedure(SlaveModModElements instance) {
		super(instance, 148);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency entity for procedure NegromancerEntityIsHurt!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure NegromancerEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure NegromancerEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure NegromancerEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure NegromancerEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure NegromancerEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double potionTicks = 0;
		potionTicks = (double) 5;
		if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == NigraniumSwordItem.block)
				|| ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == NigraniumPickaxeItem.block)
						|| ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == NigraniumAxeItem.block)
								|| ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getItem() == NigraniumHoeItem.block)
										|| (((sourceentity instanceof LivingEntity)
												? ((LivingEntity) sourceentity).getHeldItemMainhand()
												: ItemStack.EMPTY).getItem() == NigraniumShovelItem.block)))))) {
			if ((Math.random() <= 0.05)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					SpawnNegroMinionProcedure.executeProcedure($_dependencies);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potionTicks, (int) 1, (false), (true)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) potionTicks, (int) 1, (false), (true)));
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")),
							SoundCategory.HOSTILE, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")),
							SoundCategory.HOSTILE, (float) 1, (float) 1, false);
				}
			}
		} else {
			if ((Math.random() <= 0.25)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					SpawnNegroMinionProcedure.executeProcedure($_dependencies);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potionTicks, (int) 1, (false), (true)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, (int) potionTicks, (int) 1, (false), (true)));
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")),
							SoundCategory.HOSTILE, (float) 1, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")),
							SoundCategory.HOSTILE, (float) 1, (float) 1, false);
				}
			}
		}
	}
}