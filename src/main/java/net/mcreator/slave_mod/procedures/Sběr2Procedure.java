package net.mcreator.slave_mod.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.slave_mod.item.HarvestedCottonItem;
import net.mcreator.slave_mod.entity.OtrokEntity;
import net.mcreator.slave_mod.block.Cottonstage7Block;
import net.mcreator.slave_mod.block.Cottonstage6Block;
import net.mcreator.slave_mod.SlaveModModElements;
import net.mcreator.slave_mod.SlaveModMod;

import java.util.Map;

@SlaveModModElements.ModElement.Tag
public class Sbìr2Procedure extends SlaveModModElements.ModElement {
	public Sbìr2Procedure(SlaveModModElements instance) {
		super(instance, 65);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SlaveModMod.LOGGER.warn("Failed to load dependency entity for procedure Sbìr2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SlaveModMod.LOGGER.warn("Failed to load dependency x for procedure Sbìr2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SlaveModMod.LOGGER.warn("Failed to load dependency y for procedure Sbìr2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SlaveModMod.LOGGER.warn("Failed to load dependency z for procedure Sbìr2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SlaveModMod.LOGGER.warn("Failed to load dependency world for procedure Sbìr2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof OtrokEntity.CustomEntity)) {
			if (((entity.getPersistentData().getDouble("otroksber")) == 0)) {
				entity.getPersistentData().putString("slavefull/empty", "empty");
			}
			if (((((entity.getPersistentData().getString("slavefull/empty"))).equals("empty"))
					&& ((entity.getPersistentData().getDouble("otroksber")) <= 4))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Cottonstage7Block.block)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Cottonstage6Block.block.getDefaultState();
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
					entity.getPersistentData().putDouble("otroksber", ((entity.getPersistentData().getDouble("otroksber")) + 1));
					{
						final ItemStack _setstack = new ItemStack(HarvestedCottonItem.block);
						final int _sltid = (int) (0);
						_setstack.setCount((int) (entity.getPersistentData().getDouble("otroksber")));
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList()
									.sendMessage(new StringTextComponent((((entity.getPersistentData().getDouble("otroksber"))) + "" + ("."))));
					}
					if (((entity.getPersistentData().getDouble("otroksber")) == 5)) {
						entity.getPersistentData().putString("slavefull/empty", "full");
						{
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().sendMessage(new StringTextComponent("Otrok: Jsem plnej ty zmrde"));
						}
					}
				}
			}
		}
	}
}
