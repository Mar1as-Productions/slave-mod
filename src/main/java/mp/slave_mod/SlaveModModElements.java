/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package mp.slave_mod;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class SlaveModModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public SlaveModModElements() {
		sounds.put(new ResourceLocation("slave_mod", "krajina"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "krajina")));
		sounds.put(new ResourceLocation("slave_mod", "jozefhurt"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "jozefhurt")));
		sounds.put(new ResourceLocation("slave_mod", "jozefdead"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "jozefdead")));
		sounds.put(new ResourceLocation("slave_mod", "jozefh"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "jozefh")));
		sounds.put(new ResourceLocation("slave_mod", "jozefliving"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "jozefliving")));
		sounds.put(new ResourceLocation("slave_mod", "whip"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "whip")));
		sounds.put(new ResourceLocation("slave_mod", "slavehurt"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "slavehurt")));
		sounds.put(new ResourceLocation("slave_mod", "slavezvuk"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "slavezvuk")));
		sounds.put(new ResourceLocation("slave_mod", "slavedead"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "slavedead")));
		sounds.put(new ResourceLocation("slave_mod", "nazdarfrumrde"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "nazdarfrumrde")));
		sounds.put(new ResourceLocation("slave_mod", "retez"), new net.minecraft.util.SoundEvent(new ResourceLocation("slave_mod", "retez")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("slave_mod").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == SlaveModModElements.ModElement.class)
						elements.add((SlaveModModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(SlaveModModElements.ModElement::initElements);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
	private int messageID = 0;
	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		SlaveModMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<Biome>> getBiomes() {
		return biomes;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final SlaveModModElements elements;
		protected final int sortid;
		public ModElement(SlaveModModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
