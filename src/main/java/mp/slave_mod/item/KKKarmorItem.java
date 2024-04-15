package mp.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import mp.slave_mod.procedures.StrachProcedure;
import mp.slave_mod.itemgroup.SlaveModItemGroup;
import mp.slave_mod.SlaveModModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@SlaveModModElements.ModElement.Tag
public class KKKarmorItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:kk_karmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("slave_mod:kk_karmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("slave_mod:kk_karmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("slave_mod:kk_karmor_boots")
	public static final Item boots = null;
	public KKKarmorItem(SlaveModModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "kk_karmor";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelarmor_main2().Hood;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/armorpokus2layer_1_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					StrachProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("kk_karmor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new Modelarmor_main2().Robe;
				armorModel.bipedLeftArm = new Modelarmor_main2().LeftSleeve;
				armorModel.bipedRightArm = new Modelarmor_main2().RightSleeve;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/armorpokus2layer_1_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					StrachProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("kk_karmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelarmor_leggings().LeftLeg;
				armorModel.bipedRightLeg = new Modelarmor_leggings().RightLeg;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/armorpokus2layer_1_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					StrachProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("kk_karmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SlaveModItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new Modelarmor_main2().LeftShoe;
				armorModel.bipedRightLeg = new Modelarmor_main2().RightShoe;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "slave_mod:textures/models/armor/armorpokus2layer_1_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					StrachProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("kk_karmor_boots"));
	}
	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelarmor_main2 extends EntityModel<Entity> {
		private final ModelRenderer Hood;
		private final ModelRenderer Robe;
		private final ModelRenderer RightSleeve;
		private final ModelRenderer LeftSleeve;
		private final ModelRenderer RightShoe;
		private final ModelRenderer LeftShoe;
		public Modelarmor_main2() {
			textureWidth = 128;
			textureHeight = 64;
			
			Hood = new ModelRenderer(this);
			Hood.setRotationPoint(0.0F, 0.0F, 0.0F);
			Hood.setTextureOffset(19, 6).addBox(4.0F, -9.0F, -5.0F, 1.0F, 10.0F, 10.0F, 0.0F, false);
			Hood.setTextureOffset(20, 4).addBox(-5.0F, -9.0F, -5.0F, 1.0F, 10.0F, 10.0F, 0.0F, false);
			Hood.setTextureOffset(19, 6).addBox(-5.0F, -9.0F, 4.0F, 10.0F, 10.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(30, 23).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 4.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(30, 23).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 4.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(30, 23).addBox(3.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(31, 24).addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(16, 18).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			Hood.setTextureOffset(16, 18).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			Hood.setTextureOffset(31, 24).addBox(-5.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			Hood.setTextureOffset(22, 1).addBox(-3.0F, -16.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
			Hood.setTextureOffset(22, 1).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
			Hood.setTextureOffset(22, 4).addBox(-1.0F, -22.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
			Hood.setTextureOffset(22, 1).addBox(0.0F, -23.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			
			Robe = new ModelRenderer(this);
			Robe.setRotationPoint(0.0F, 0.0F, 0.0F);
			Robe.setTextureOffset(65, 43).addBox(3.5F, 1.0F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
			Robe.setTextureOffset(65, 43).addBox(-4.5F, 1.0F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
			Robe.setTextureOffset(39, 47).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 13.0F, 1.0F, 0.0F, false);
			Robe.setTextureOffset(51, 49).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 13.0F, 1.0F, 0.0F, false);
			Robe.setTextureOffset(45, 35).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			
			RightSleeve = new ModelRenderer(this);
			RightSleeve.setRotationPoint(-6.0F, 8.0F, 0.0F);
			setRotationAngle(RightSleeve, 0.0F, 0.0F, 0.0F);
			RightSleeve.setTextureOffset(81, 43).addBox(-4.0F, -4.0F, -3.0F, 6.0F, 17.0F, 1.0F, 0.0F, false);
			RightSleeve.setTextureOffset(82, 42).addBox(-4.0F, -4.0F, 2.0F, 6.0F, 17.0F, 1.0F, 0.0F, false);
			RightSleeve.setTextureOffset(80, 41).addBox(-4.0F, -4.0F, -2.0F, 1.0F, 17.0F, 4.0F, 0.0F, false);
			RightSleeve.setTextureOffset(80, 41).addBox(1.0F, -4.0F, -2.0F, 1.0F, 17.0F, 4.0F, 0.0F, false);
			RightSleeve.setTextureOffset(88, 32).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			RightSleeve.setTextureOffset(88, 32).addBox(-3.0F, 10.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			
			LeftSleeve = new ModelRenderer(this);
			LeftSleeve.setRotationPoint(6.0F, 8.0F, 0.0F);
			setRotationAngle(LeftSleeve, 0.0F, 0.0F, 0.0F);
			LeftSleeve.setTextureOffset(96, 43).addBox(-2.0F, -4.0F, -3.0F, 6.0F, 17.0F, 1.0F, 0.0F, false);
			LeftSleeve.setTextureOffset(96, 43).addBox(-2.0F, -4.0F, 2.0F, 6.0F, 17.0F, 1.0F, 0.0F, false);
			LeftSleeve.setTextureOffset(101, 41).addBox(3.0F, -4.0F, -2.0F, 1.0F, 17.0F, 4.0F, 0.0F, false);
			LeftSleeve.setTextureOffset(101, 41).addBox(-2.0F, -4.0F, -2.0F, 1.0F, 17.0F, 4.0F, 0.0F, false);
			LeftSleeve.setTextureOffset(88, 33).addBox(-1.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			LeftSleeve.setTextureOffset(88, 33).addBox(-1.0F, 9.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			
			RightShoe = new ModelRenderer(this);
			RightShoe.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightShoe.setTextureOffset(4, 48).addBox(-3.0F, 9.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			RightShoe.setTextureOffset(4, 48).addBox(2.0F, 9.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			RightShoe.setTextureOffset(4, 53).addBox(-3.0F, 9.0F, 3.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			RightShoe.setTextureOffset(4, 53).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			RightShoe.setTextureOffset(2, 43).addBox(-2.0F, 9.0F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
			
			LeftShoe = new ModelRenderer(this);
			LeftShoe.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftShoe.setTextureOffset(4, 53).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			LeftShoe.setTextureOffset(4, 53).addBox(-3.0F, 9.0F, 3.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
			LeftShoe.setTextureOffset(4, 48).addBox(-3.0F, 9.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			LeftShoe.setTextureOffset(4, 48).addBox(2.0F, 9.0F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			LeftShoe.setTextureOffset(2, 43).addBox(-2.0F, 9.0F, -4.0F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Hood.render(matrixStack, buffer, packedLight, packedOverlay);
			Robe.render(matrixStack, buffer, packedLight, packedOverlay);
			RightSleeve.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftSleeve.render(matrixStack, buffer, packedLight, packedOverlay);
			RightShoe.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftShoe.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.LeftSleeve.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.LeftShoe.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightSleeve.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.RightShoe.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Hood.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Hood.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelarmor_leggings extends EntityModel<Entity> {
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		public Modelarmor_leggings() {
			textureWidth = 128;
			textureHeight = 64;
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			RightLeg.setTextureOffset(8, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.5F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			LeftLeg.setTextureOffset(8, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.5F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
