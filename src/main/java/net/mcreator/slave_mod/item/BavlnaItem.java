
package net.mcreator.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.slave_mod.itemgroup.SlaveModItemGroup;
import net.mcreator.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class BavlnaItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:bavlna")
	public static final Item block = null;
	public BavlnaItem(SlaveModModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SlaveModItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bavlna");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}