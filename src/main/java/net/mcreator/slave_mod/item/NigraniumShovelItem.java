
package net.mcreator.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.slave_mod.itemgroup.SlaveModItemGroup;
import net.mcreator.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class NigraniumShovelItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:nigranium_shovel")
	public static final Item block = null;
	public NigraniumShovelItem(SlaveModModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 6.5f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NigraniumingotItem.block), new ItemStack(NigraniumShovelItem.block));
			}
		}, 1, -2f, new Item.Properties().group(SlaveModItemGroup.tab)) {
		}.setRegistryName("nigranium_shovel"));
	}
}
