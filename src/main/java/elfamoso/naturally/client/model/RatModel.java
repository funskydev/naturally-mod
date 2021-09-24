package elfamoso.naturally.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class RatModel<T extends Entity> extends AgeableModel<T> {

	private final ModelRenderer body;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r1;
	
	public RatModel() {
			
			super(true, 13.0F, -2.0F);
			
			texWidth = 32;
			texHeight = 32;
			
			body = new ModelRenderer(this);
			body.setPos(0.0F, 21.0F, 0.0F);
			setRotationAngle(body, -0.1309F, 0.0F, 0.0F);
			body.texOffs(0, 0).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 4.0F, 8.0F, 0.0F, false);

			leftLeg = new ModelRenderer(this);
			leftLeg.setPos(-3.5F, 22.75F, 2.75F);
			leftLeg.texOffs(0, 12).addBox(-1.5F, 0.25F, -1.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			leftLeg.texOffs(14, 12).addBox(-0.5F, -1.75F, -0.75F, 1.0F, 2.0F, 2.0F, 0.0F, false);

			rightLeg = new ModelRenderer(this);
			rightLeg.setPos(3.5F, 22.75F, 2.75F);
			rightLeg.texOffs(0, 17).addBox(-1.5F, 0.25F, -1.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			rightLeg.texOffs(0, 0).addBox(-0.5F, -1.75F, -0.75F, 1.0F, 2.0F, 2.0F, 0.0F, false);

			leftArm = new ModelRenderer(this);
			leftArm.setPos(-3.5F, 22.5F, -2.0F);
			leftArm.texOffs(0, 0).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

			rightArm = new ModelRenderer(this);
			rightArm.setPos(3.5F, 22.5F, -2.0F);
			rightArm.texOffs(0, 27).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setPos(0.0F, 24.0F, 0.0F);
			setRotationAngle(head, -0.1309F, 0.0F, 0.0F);
			head.texOffs(18, 26).addBox(-2.0F, -6.0F, -7.4F, 4.0F, 3.0F, 3.0F, 0.0F, false);
			head.texOffs(9, 26).addBox(-1.0F, -5.0F, -9.4F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			head.texOffs(15, 19).addBox(-3.0F, -7.0F, -6.4F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.texOffs(26, 15).addBox(1.0F, -7.0F, -6.4F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			head.texOffs(0, 0).addBox(-2.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.texOffs(0, 0).addBox(1.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			head.texOffs(8, 21).addBox(-1.0F, -3.0F, -8.4F, 2.0F, 1.0F, 0.0F, 0.0F, false);

			tail = new ModelRenderer(this);
			tail.setPos(0.0F, 19.5F, 5.0F);
			

			cube_r1 = new ModelRenderer(this);
			cube_r1.setPos(0.0F, 0.0F, 0.0F);
			tail.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.2182F, 0.0F, 0.0F);
			cube_r1.texOffs(20, 21).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			
		}
	
		@Override
		public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
			
			head.xRot = headPitch * ((float)Math.PI / 180F);
	        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
	        
	        leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	        rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	        leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	        rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	        
	        //leftArm.zRot = Math.abs(MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
	        //rightArm.zRot = -Math.abs(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F);
	        
		}
	
		/*public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
		}*/

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.xRot = x;
			modelRenderer.yRot = y;
			modelRenderer.zRot = z;
		}
		
		@Override
		protected Iterable<ModelRenderer> headParts() {
			return ImmutableList.of(head);
		}
	
		@Override
		protected Iterable<ModelRenderer> bodyParts() {
			return ImmutableList.of(body, leftArm, rightArm, leftLeg, rightLeg, tail);
		}

}
