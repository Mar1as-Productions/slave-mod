
package mp.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import mp.slave_mod.itemgroup.SlaveModItemGroup;
import mp.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class NigraniumAxeItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:nigranium_axe")
	public static final Item block = null;
	public NigraniumAxeItem(SlaveModModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 6.5f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NigraniumingotItem.block), new ItemStack(NigraniumAxeItem.block));
			}
		}, 1, -2.15f, new Item.Properties().group(SlaveModItemGroup.tab)) {
		}.setRegistryName("nigranium_axe"));
	}
}
