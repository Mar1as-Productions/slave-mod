
package net.mcreator.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.slave_mod.procedures.NigraniumShearsBlockDestroyedWithToolProcedure;
import net.mcreator.slave_mod.itemgroup.SlaveModItemGroup;
import net.mcreator.slave_mod.SlaveModModElements;

import java.util.Map;
import java.util.HashMap;

@SlaveModModElements.ModElement.Tag
public class NigraniumShearsItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:nigranium_shears")
	public static final Item block = null;
	public NigraniumShearsItem(SlaveModModElements instance) {
		super(instance, 88);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShearsItem(new Item.Properties().group(SlaveModItemGroup.tab).maxDamage(1000)) {
			@Override
			public int getItemEnchantability() {
				return 2;
			}

			@Override
			public float getDestroySpeed(ItemStack stack, BlockState block) {
				return 1.5f;
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, blockstate, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					NigraniumShearsBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("nigranium_shears"));
	}
}
