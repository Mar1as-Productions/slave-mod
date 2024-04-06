// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelpenek extends EntityModel<Entity> {
	private final ModelRenderer Hood;
	private final ModelRenderer Robe;
	private final ModelRenderer RightSleeve;
	private final ModelRenderer LeftSleeve;
	private final ModelRenderer RightShoe;
	private final ModelRenderer LeftShoe;

	public Modelpenek() {
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
		Hood.setTextureOffset(16, 17).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
		Hood.setTextureOffset(16, 3).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
		Hood.setTextureOffset(31, 24).addBox(-5.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Hood.setTextureOffset(22, 1).addBox(-3.0F, -16.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, false);
		Hood.setTextureOffset(22, 1).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		Hood.setTextureOffset(22, 1).addBox(-1.0F, -22.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
		Hood.setTextureOffset(22, 1).addBox(0.0F, -23.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Robe = new ModelRenderer(this);
		Robe.setRotationPoint(0.0F, 5.5F, 0.0F);
		Robe.setTextureOffset(65, 43).addBox(4.0F, -4.5F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
		Robe.setTextureOffset(65, 43).addBox(-5.0F, -4.5F, -3.0F, 1.0F, 12.0F, 6.0F, 0.0F, false);
		Robe.setTextureOffset(39, 47).addBox(-4.0F, -5.5F, -3.0F, 8.0F, 13.0F, 1.0F, 0.0F, false);
		Robe.setTextureOffset(51, 49).addBox(-4.0F, -5.5F, 2.0F, 8.0F, 13.0F, 1.0F, 0.0F, false);
		Robe.setTextureOffset(45, 35).addBox(-3.0F, -5.5F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		RightSleeve = new ModelRenderer(this);
		RightSleeve.setRotationPoint(-7.0F, 8.0F, 0.0F);
		RightSleeve.setTextureOffset(81, 43).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 18.0F, 1.0F, 0.0F, false);
		RightSleeve.setTextureOffset(82, 42).addBox(-3.0F, -9.0F, 2.0F, 6.0F, 18.0F, 1.0F, 0.0F, false);
		RightSleeve.setTextureOffset(80, 41).addBox(-3.0F, -9.0F, -2.0F, 1.0F, 18.0F, 4.0F, 0.0F, false);
		RightSleeve.setTextureOffset(80, 41).addBox(2.0F, -9.0F, -2.0F, 1.0F, 18.0F, 4.0F, 0.0F, false);
		RightSleeve.setTextureOffset(88, 32).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		RightSleeve.setTextureOffset(88, 32).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		LeftSleeve = new ModelRenderer(this);
		LeftSleeve.setRotationPoint(7.0F, 8.0F, 0.0F);
		LeftSleeve.setTextureOffset(96, 43).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 18.0F, 1.0F, 0.0F, false);
		LeftSleeve.setTextureOffset(96, 43).addBox(-3.0F, -9.0F, 2.0F, 6.0F, 18.0F, 1.0F, 0.0F, false);
		LeftSleeve.setTextureOffset(101, 41).addBox(2.0F, -9.0F, -2.0F, 1.0F, 18.0F, 4.0F, 0.0F, false);
		LeftSleeve.setTextureOffset(101, 41).addBox(-3.0F, -9.0F, -2.0F, 1.0F, 18.0F, 4.0F, 0.0F, false);
		LeftSleeve.setTextureOffset(88, 33).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		LeftSleeve.setTextureOffset(88, 33).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		RightShoe = new ModelRenderer(this);
		RightShoe.setRotationPoint(-1.5F, 0.0F, 0.0F);
		RightShoe.setTextureOffset(4, 48).addBox(2.5F, -1.3F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		RightShoe.setTextureOffset(4, 48).addBox(-3.5F, -1.3F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		RightShoe.setTextureOffset(4, 53).addBox(-3.5F, -1.3F, 3.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		RightShoe.setTextureOffset(4, 53).addBox(-3.5F, -1.3F, -4.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		RightShoe.setTextureOffset(2, 43).addBox(-2.5F, -1.3F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);

		LeftShoe = new ModelRenderer(this);
		LeftShoe.setRotationPoint(1.4F, 0.0F, 0.0F);
		LeftShoe.setTextureOffset(4, 53).addBox(-3.5F, -1.1667F, -4.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		LeftShoe.setTextureOffset(4, 53).addBox(-3.5F, -1.1667F, 3.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		LeftShoe.setTextureOffset(4, 48).addBox(-3.5F, -1.1667F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		LeftShoe.setTextureOffset(4, 48).addBox(2.5F, -1.1667F, -3.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		LeftShoe.setTextureOffset(2, 43).addBox(-2.5F, -1.1667F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		LeftShoe.setTextureOffset(2, 43).addBox(-2.5F, -1.1667F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}