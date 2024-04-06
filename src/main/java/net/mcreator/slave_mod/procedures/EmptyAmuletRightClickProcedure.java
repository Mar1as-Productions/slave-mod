package net.mcreator.slave_mod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.state.IProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.slave_mod.item.AmuletItem;
import net.mcreator.slave_mod.block.WodencrossbaseblockBlock;
import net.mcreator.slave_mod.block.NehoriciDrevoOakBlock;
import net.mcreator.slave_mod.SlaveModModElements;
import net.mcreator.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class EmptyAmuletRightClickProcedure extends SlaveModModElements.ModElement {
	public EmptyAmuletRightClickProcedure(SlaveModModElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency entity for procedure EmptyAmuletRightClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure EmptyAmuletRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure EmptyAmuletRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure EmptyAmuletRightClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure EmptyAmuletRightClick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 5), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
				.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
						.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
								&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == NehoriciDrevoOakBlock.block)
										&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2))))
												.getBlock() == NehoriciDrevoOakBlock.block)
												&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == NehoriciDrevoOakBlock.block)
														&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2))))
																.getBlock() == NehoriciDrevoOakBlock.block)
																&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																		.getBlock() == NehoriciDrevoOakBlock.block)
																		&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))
																				.getBlock() == NehoriciDrevoOakBlock.block)
																				&& (((world
																						.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z)))
																								.getBlock() == Blocks.FIRE)
																						&& (((world.getBlockState(
																								new BlockPos((int) x, (int) (y + 1), (int) (z + 1))))
																										.getBlock() == Blocks.FIRE)
																								&& (((world.getBlockState(new BlockPos((int) x,
																										(int) (y + 1), (int) (z + 2))))
																												.getBlock() == Blocks.FIRE)
																										&& (((world.getBlockState(new BlockPos(
																												(int) x, (int) (y + 1),
																												(int) (z - 1))))
																														.getBlock() == Blocks.FIRE)
																												&& (((world.getBlockState(
																														new BlockPos((int) x,
																																(int) (y + 1),
																																(int) (z - 2))))
																																		.getBlock() == Blocks.FIRE)
																														&& ((world.getBlockState(
																																new BlockPos((int) x,
																																		(int) (y - 6),
																																		(int) z)))
																																				.getBlock() == WodencrossbaseblockBlock.block)))))))))))))))))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(AmuletItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) (y + 3), (int) z, true));
			world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2)), Blocks.AIR.getDefaultState(), 3);
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 6), (int) z);
				BlockState _bs = Blocks.AIR.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.has(_property))
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 5), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
				.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
						.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
								&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
										&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z)))
												.getBlock() == NehoriciDrevoOakBlock.block)
												&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
														.getBlock() == NehoriciDrevoOakBlock.block)
														&& (((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z)))
																.getBlock() == NehoriciDrevoOakBlock.block)
																&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																		.getBlock() == NehoriciDrevoOakBlock.block)
																		&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))
																				.getBlock() == NehoriciDrevoOakBlock.block)
																				&& (((world
																						.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z)))
																								.getBlock() == Blocks.FIRE)
																						&& (((world.getBlockState(
																								new BlockPos((int) (x + 1), (int) (y + 1), (int) z)))
																										.getBlock() == Blocks.FIRE)
																								&& (((world.getBlockState(new BlockPos((int) (x + 2),
																										(int) (y + 1), (int) z)))
																												.getBlock() == Blocks.FIRE)
																										&& (((world.getBlockState(new BlockPos(
																												(int) (x - 1), (int) (y + 1),
																												(int) z))).getBlock() == Blocks.FIRE)
																												&& (((world.getBlockState(
																														new BlockPos((int) (x - 2),
																																(int) (y + 1),
																																(int) z)))
																																		.getBlock() == Blocks.FIRE)
																														&& ((world.getBlockState(
																																new BlockPos((int) x,
																																		(int) (y - 6),
																																		(int) z)))
																																				.getBlock() == WodencrossbaseblockBlock.block)))))))))))))))))) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(AmuletItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if (world instanceof ServerWorld)
				((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) (y + 3), (int) z, true));
			world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
			{
				BlockPos _bp = new BlockPos((int) x, (int) (y - 6), (int) z);
				BlockState _bs = Blocks.AIR.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.has(_property))
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
