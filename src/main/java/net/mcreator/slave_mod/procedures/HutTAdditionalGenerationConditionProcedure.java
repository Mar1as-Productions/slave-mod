package net.mcreator.slave_mod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.slave_mod.SlaveModModElements;
import net.mcreator.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class HutTAdditionalGenerationConditionProcedure extends SlaveModModElements.ModElement {
	public HutTAdditionalGenerationConditionProcedure(SlaveModModElements instance) {
		super(instance, 32);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure HutTAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure HutTAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure HutTAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure HutTAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (Double.NaN); index0++) {
			if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) && (((world.getBlockState(
					new BlockPos((int) (x + 5), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK)
					&& (((world.getBlockState(new BlockPos((int) (x + 10), (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) && (((world
							.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 5)))).getBlock() == Blocks.GRASS_BLOCK)
							&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 10)))).getBlock() == Blocks.GRASS_BLOCK) && (((world
									.getBlockState(new BlockPos((int) (x + 5), (int) y, (int) (z + 5)))).getBlock() == Blocks.GRASS_BLOCK)
									&& (((world.getBlockState(new BlockPos((int) (x + 10), (int) y, (int) (z + 5)))).getBlock() == Blocks.GRASS_BLOCK)
											&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) y, (int) (z + 10))))
													.getBlock() == Blocks.GRASS_BLOCK)
													&& (((world.getBlockState(new BlockPos((int) (x + 10), (int) y, (int) (z + 10))))
															.getBlock() == Blocks.GRASS_BLOCK)
															&& (((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 3))))
																	.getBlock() == Blocks.GRASS_BLOCK)
																	&& (((world.getBlockState(new BlockPos((int) (x + 3), (int) y, (int) (z + 8))))
																			.getBlock() == Blocks.GRASS_BLOCK)
																			&& (((world.getBlockState(
																					new BlockPos((int) (x + 8), (int) y, (int) (z + 3))))
																							.getBlock() == Blocks.GRASS_BLOCK)
																					&& ((world.getBlockState(
																							new BlockPos((int) (x + 8), (int) y, (int) (z + 8))))
																									.getBlock() == Blocks.GRASS_BLOCK)))))))))))))
					&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR) && (((world.getBlockState(
							new BlockPos((int) x, (int) (y + 7), (int) z))).getBlock() == Blocks.AIR)
							&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 13), (int) z))).getBlock() == Blocks.AIR) && (((world
									.getBlockState(new BlockPos((int) (x + 5), (int) (y + 1), (int) (z + 5)))).getBlock() == Blocks.AIR)
									&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 7), (int) (z + 5)))).getBlock() == Blocks.AIR)
											&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 13), (int) (z + 5))))
													.getBlock() == Blocks.AIR)
													&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 1), (int) z)))
															.getBlock() == Blocks.AIR)
															&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 7), (int) z)))
																	.getBlock() == Blocks.AIR)
																	&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y + 13), (int) z)))
																			.getBlock() == Blocks.AIR)
																			&& (((world.getBlockState(
																					new BlockPos((int) (x + 10), (int) (y + 1), (int) z)))
																							.getBlock() == Blocks.AIR)
																					&& (((world.getBlockState(
																							new BlockPos((int) (x + 10), (int) (y + 7), (int) z)))
																									.getBlock() == Blocks.AIR)
																							&& (((world.getBlockState(new BlockPos((int) (x + 10),
																									(int) (y + 13), (int) z)))
																											.getBlock() == Blocks.AIR)
																									&& (((world.getBlockState(new BlockPos((int) x,
																											(int) (y + 1), (int) (z + 5))))
																													.getBlock() == Blocks.AIR)
																											&& (((world.getBlockState(new BlockPos(
																													(int) x, (int) (y + 7),
																													(int) (z + 5))))
																															.getBlock() == Blocks.AIR)
																													&& (((world.getBlockState(
																															new BlockPos((int) x,
																																	(int) (y + 13),
																																	(int) (z + 5))))
																																			.getBlock() == Blocks.AIR)
																															&& (((world.getBlockState(
																																	new BlockPos(
																																			(int) x,
																																			(int) (y + 1),
																																			(int) (z + 10))))
																																					.getBlock() == Blocks.AIR)
																																	&& (((world
																																			.getBlockState(
																																					new BlockPos(
																																							(int) x,
																																							(int) (y + 7),
																																							(int) (z + 10))))
																																									.getBlock() == Blocks.AIR)
																																			&& (((world
																																					.getBlockState(
																																							new BlockPos(
																																									(int) x,
																																									(int) (y + 13),
																																									(int) (z + 10))))
																																											.getBlock() == Blocks.AIR)
																																					&& (((world
																																							.getBlockState(
																																									new BlockPos(
																																											(int) (x + 5),
																																											(int) (y + 1),
																																											(int) (z + 10))))
																																													.getBlock() == Blocks.AIR)
																																							&& (((world
																																									.getBlockState(
																																											new BlockPos(
																																													(int) (x + 5),
																																													(int) (y + 7),
																																													(int) (z + 10))))
																																															.getBlock() == Blocks.AIR)
																																									&& (((world
																																											.getBlockState(
																																													new BlockPos(
																																															(int) (x + 5),
																																															(int) (y + 13),
																																															(int) (z + 10))))
																																																	.getBlock() == Blocks.AIR)
																																											&& (((world
																																													.getBlockState(
																																															new BlockPos(
																																																	(int) (x + 10),
																																																	(int) (y + 1),
																																																	(int) (z + 10))))
																																																			.getBlock() == Blocks.AIR)
																																													&& (((world
																																															.getBlockState(
																																																	new BlockPos(
																																																			(int) (x + 10),
																																																			(int) (y + 7),
																																																			(int) (z + 10))))
																																																					.getBlock() == Blocks.AIR)
																																															&& (((world
																																																	.getBlockState(
																																																			new BlockPos(
																																																					(int) (x + 10),
																																																					(int) (y + 13),
																																																					(int) (z + 10))))
																																																							.getBlock() == Blocks.AIR)
																																																	&& (((world
																																																			.getBlockState(
																																																					new BlockPos(
																																																							(int) (x + 10),
																																																							(int) (y + 1),
																																																							(int) (z + 5))))
																																																									.getBlock() == Blocks.AIR)
																																																			&& (((world
																																																					.getBlockState(
																																																							new BlockPos(
																																																									(int) (x + 10),
																																																									(int) (y + 7),
																																																									(int) (z + 5))))
																																																											.getBlock() == Blocks.AIR)
																																																					&& ((world
																																																							.getBlockState(
																																																									new BlockPos(
																																																											(int) (x + 10),
																																																											(int) (y + 13),
																																																											(int) (z + 5))))
																																																													.getBlock() == Blocks.AIR))))))))))))))))))))))))))))) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("slave_mod", "hutloot1"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) x, (int) y, (int) z),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			}
			break;
		}
		return (true);
	}
}
