
package mp.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mp.slave_mod.procedures.NigraniumArmorFireResistanceProcedure;
import mp.slave_mod.itemgroup.SlaveModItemGroup;
import mp.slave_mod.SlaveModModElements;

import java.util.Map;
import java.util.HashMap;

@SlaveModModElements.ModElement.Tag
public class NigraniumArmorItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:nigranium_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("slave_mod:nigranium_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("slave_mod:nigranium_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("slave_mod:nigranium_armor_boots")
	public static final Item boots = null;
	public NigraniumArmorItem(SlaveModModElements instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 30;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 6, 8, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 30;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(NigraniumingotItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "nigranium_armor";
			}

			public float getToughness() {
				return 1f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/nigraniumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("nigranium_armor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/nigraniumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("nigranium_armor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/nigraniumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("nigranium_armor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/nigraniumarmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					NigraniumArmorFireResistanceProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("nigranium_armor_boots"));
	}
}
