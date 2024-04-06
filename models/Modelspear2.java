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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		tyc.render(matrixStack, buffer, packedLight, packedOverlay);
		mezi.render(matrixStack, buffer, packedLight, packedOverlay);
		ostri.render(matrixStack, buffer, packedLight, packedOverlay);
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