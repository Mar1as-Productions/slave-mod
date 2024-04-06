
package mp.slave_mod.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.EffectInstance;

import mp.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class EbolaPotionItemPotion extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:ebola")
	public static final Potion potionType = null;
	public EbolaPotionItemPotion(SlaveModModElements instance) {
		super(instance, 110);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(EbolaPotionEffect.potion, 3600, 0, false, true));
			setRegistryName("ebola");
		}
	}
}
