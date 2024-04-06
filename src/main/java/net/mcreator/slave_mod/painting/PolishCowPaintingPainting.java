
package net.mcreator.slave_mod.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.slave_mod.SlaveModModElements;

@SlaveModModElements.ModElement.Tag
public class PolishCowPaintingPainting extends SlaveModModElements.ModElement {
	public PolishCowPaintingPainting(SlaveModModElements instance) {
		super(instance, 13);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 32).setRegistryName("polish_cow_painting"));
	}
}
