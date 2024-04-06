
package net.mcreator.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.slave_mod.itemgroup.SlaveModItemGroup;
import net.mcreator.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class NigraniumSwordItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:nigranium_sword")
	public static final Item block = null;
	public NigraniumSwordItem(SlaveModModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 6.5f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NigraniumingotItem.block), new ItemStack(NigraniumSwordItem.block));
			}
		}, 3, -2f, new Item.Properties().group(SlaveModItemGroup.tab)) {
		}.setRegistryName("nigranium_sword"));
	}
}
