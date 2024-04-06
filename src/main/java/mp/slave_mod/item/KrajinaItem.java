
package mp.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import mp.slave_mod.itemgroup.SlaveModItemGroup;
import mp.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class KrajinaItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:krajina")
	public static final Item block = null;
	public KrajinaItem(SlaveModModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, SlaveModModElements.sounds.get(new ResourceLocation("slave_mod:krajina")),
					new Item.Properties().group(SlaveModItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("krajina");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
