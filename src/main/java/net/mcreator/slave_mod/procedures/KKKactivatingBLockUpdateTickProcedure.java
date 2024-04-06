package net.mcreator.slave_mod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.slave_mod.entity.SlaveEntity;
import net.mcreator.slave_mod.entity.SlaveAnimalEntity;
import net.mcreator.slave_mod.entity.RangedSlaveEntity;
import net.mcreator.slave_mod.block.WodencrossbaseblockBlock;
import net.mcreator.slave_mod.block.NehoriciDrevoOakBlock;
import net.mcreator.slave_mod.SlaveModModElements;
import net.mcreator.slave_mod.SlaveModMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

@SlaveModModElements.ModElement.Tag
public class KKKactivatingBLockUpdateTickProcedure extends SlaveModModElements.ModElement {
	public KKKactivatingBLockUpdateTickProcedure(SlaveModModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure KKKactivatingBLockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure KKKactivatingBLockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure KKKactivatingBLockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure KKKactivatingBLockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 5), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
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
																				&& ((world
																						.getBlockState(new BlockPos((int) x, (int) (y - 6), (int) z)))
																								.getBlock() == WodencrossbaseblockBlock.block))))))))))))) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.FIRE)
					&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
							&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
									&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
											&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z)))
													.getBlock() == Blocks.FIRE))))) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.FIRE)
					&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
							&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
									&& (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.FIRE)
											&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z)))
													.getBlock() == Blocks.FIRE))))) == (true))) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (((((Entity) world.getEntitiesWithinAABB(SlaveEntity.CustomEntity.class,
								new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)
								|| ((((Entity) world.getEntitiesWithinAABB(RangedSlaveEntity.CustomEntity.class,
										new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) || (((Entity) world
												.getEntitiesWithinAABB(SlaveAnimalEntity.CustomEntity.class, new AxisAlignedBB(x - (69 / 2d),
														y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)))) {
							if (((entityiterator instanceof SlaveEntity.CustomEntity) || ((entityiterator instanceof RangedSlaveEntity.CustomEntity)
									|| (entityiterator instanceof SlaveAnimalEntity.CustomEntity)))) {
								entityiterator.setFire((int) 60);
								entityiterator.attackEntityFrom(DamageSource.IN_FIRE, (float) 10);
							}
						}
					}
				}
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 5), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
				.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == NehoriciDrevoOakBlock.block) && (((world
						.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == NehoriciDrevoOakBlock.block)
								&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == NehoriciDrevoOakBlock.block)
										&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
												.getBlock() == NehoriciDrevoOakBlock.block)
												&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2))))
														.getBlock() == NehoriciDrevoOakBlock.block)
														&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2))))
																.getBlock() == NehoriciDrevoOakBlock.block)
																&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
																		.getBlock() == NehoriciDrevoOakBlock.block)
																		&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))
																				.getBlock() == NehoriciDrevoOakBlock.block)
																				&& ((world
																						.getBlockState(new BlockPos((int) x, (int) (y - 6), (int) z)))
																								.getBlock() == WodencrossbaseblockBlock.block))))))))))))) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.FIRE)
					&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.FIRE)
							&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)))).getBlock() == Blocks.FIRE)
									&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.FIRE)
											&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2))))
													.getBlock() == Blocks.FIRE))))) == (false))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2)), Blocks.FIRE.getDefaultState(), 3);
			}
			if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.FIRE)
					&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.FIRE)
							&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)))).getBlock() == Blocks.FIRE)
									&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.FIRE)
											&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2))))
													.getBlock() == Blocks.FIRE))))) == (true))) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (((((Entity) world.getEntitiesWithinAABB(SlaveEntity.CustomEntity.class,
								new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)
								|| ((((Entity) world.getEntitiesWithinAABB(RangedSlaveEntity.CustomEntity.class,
										new AxisAlignedBB(x - (69 / 2d), y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null) || (((Entity) world
												.getEntitiesWithinAABB(SlaveAnimalEntity.CustomEntity.class, new AxisAlignedBB(x - (69 / 2d),
														y - (69 / 2d), z - (69 / 2d), x + (69 / 2d), y + (69 / 2d), z + (69 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)))) {
							if (((entityiterator instanceof SlaveEntity.CustomEntity) || ((entityiterator instanceof RangedSlaveEntity.CustomEntity)
									|| (entityiterator instanceof SlaveAnimalEntity.CustomEntity)))) {
								entityiterator.setFire((int) 60);
								entityiterator.attackEntityFrom(DamageSource.IN_FIRE, (float) 10);
							}
						}
					}
				}
			}
		}
	}
}
