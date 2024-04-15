
package mp.slave_mod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.network.IPacket;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import mp.slave_mod.procedures.SpearRangedItemUsedProcedure;
import mp.slave_mod.procedures.SpearBulletHitsAnythingProcedure;
import mp.slave_mod.itemgroup.SlaveModItemGroup;
import mp.slave_mod.SlaveModModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.Multimap;

@SlaveModModElements.ModElement.Tag
public class SpearItem extends SlaveModModElements.ModElement {
	@ObjectHolder("slave_mod:spear")
	public static final Item block = null;
	public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
			.size(0.5f, 0.5f)).build("entitybulletspear").setRegistryName("entitybulletspear");
	public SpearItem(SlaveModModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> arrow);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void init(FMLCommonSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(arrow, renderManager -> new CustomRender(renderManager));
	}
	public static class ItemRanged extends Item {
		public ItemRanged() {
			super(new Item.Properties().group(SlaveModItemGroup.tab).maxDamage(2));
			setRegistryName("spear");
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.SPEAR;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot);
			if (slot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "ranged_item_damage", (double) 4, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "ranged_item_attack_speed", -2.4, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
			if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
				ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (true) {
					ArrowCustomEntity entityarrow = shoot(world, entity, random, 1.2f, 2.5, 3);
					itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
					entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("entity", entity);
						SpearRangedItemUsedProcedure.executeProcedure($_dependencies);
					}
				}
			}
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return null;
		}

		@Override
		protected ItemStack getArrowStack() {
			return null;
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity entity) {
			super.onCollideWithPlayer(entity);
			Entity sourceentity = this.getShooter();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity imediatesourceentity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SpearBulletHitsAnythingProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			Entity sourceentity = this.getShooter();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity imediatesourceentity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SpearBulletHitsAnythingProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void tick() {
			super.tick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity entity = this.getShooter();
			Entity imediatesourceentity = this;
			if (this.inGround) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					SpearBulletHitsAnythingProcedure.executeProcedure($_dependencies);
				}
				this.remove();
			}
		}
	}

	public static class CustomRender extends EntityRenderer<ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("slave_mod:textures/spear.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
				int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelspear2();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelspear2 extends EntityModel<Entity> {
		private final ModelRenderer tyc;
		private final ModelRenderer nahore_r1;
		private final ModelRenderer mezi;
		private final ModelRenderer cube_r1;
		private final ModelRenderer ostri;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		public Modelspear2() {
			textureWidth = 32;
			textureHeight = 32;
			tyc = new ModelRenderer(this);
			tyc.setRotationPoint(-8.0F, 16.0F, 8.0F);
			nahore_r1 = new ModelRenderer(this);
			nahore_r1.setRotationPoint(0.0147F, -2.9489F, 0.4804F);
			tyc.addChild(nahore_r1);
			setRotationAngle(nahore_r1, 0.7854F, 0.0F, 0.0F);
			nahore_r1.setTextureOffset(4, 3).addBox(-0.5F, -4.3194F, 2.3472F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 2.6806F, -4.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, -3.3194F, 1.3472F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 1.6806F, -3.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, -2.3194F, 0.3472F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 0.6806F, -2.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, -1.3194F, -0.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, -0.3194F, -1.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 8.6806F, -10.6528F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 7.6806F, -9.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 6.6806F, -8.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 3.6806F, -5.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 4.6806F, -6.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 5.6806F, -7.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 11.6806F, -13.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 10.6806F, -12.6528F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 9.6806F, -11.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 12.6806F, -14.6528F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 13.6806F, -15.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(9, 2).addBox(-0.5F, 14.6806F, -16.6528F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			nahore_r1.setTextureOffset(0, 2).addBox(-0.5F, 15.6806F, -16.6528F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			mezi = new ModelRenderer(this);
			mezi.setRotationPoint(-8.0F, 16.0F, 8.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0147F, -2.9489F, 0.4804F);
			mezi.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.7854F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -5.3194F, 3.3472F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 2).addBox(-0.5F, -6.3194F, 4.3472F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -4.3194F, 4.3472F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(8, 2).addBox(-0.5F, -7.3194F, 5.3472F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			ostri = new ModelRenderer(this);
			ostri.setRotationPoint(-8.0F, 16.0F, 8.0F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0147F, 2.7386F, 0.4804F);
			ostri.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.7854F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(2, 4).addBox(-0.5F, -14.3194F, 14.3472F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(4, 4).addBox(-0.5F, -15.3194F, 11.3472F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0147F, -2.9489F, 0.4804F);
			ostri.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.7854F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 1).addBox(-0.5F, -8.3194F, 5.3472F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 1).addBox(-0.5F, -6.3194F, 9.3472F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 1).addBox(-0.5F, -6.3194F, 7.3472F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 0).addBox(-0.5F, -10.3194F, 5.8472F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 0).addBox(-0.5F, -10.3194F, 6.3472F, 1.0F, 4.0F, 4.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0147F, 1.3636F, 0.4804F);
			ostri.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.7854F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(2, 4).addBox(-0.5F, -14.3194F, 14.3472F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 7).addBox(-0.5F, -15.3194F, 11.5972F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			tyc.render(matrixStack, buffer, packedLight, packedOverlay);
			mezi.render(matrixStack, buffer, packedLight, packedOverlay);
			ostri.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(true);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
				SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setDamage(2.5);
		entityarrow.setKnockbackStrength(3);
		entityarrow.setIsCritical(true);
		entity.world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
				SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
