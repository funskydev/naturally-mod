package elfamoso.naturally.client.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


public class PenguinModel<T extends Entity> extends AgeableModel<T> {
	
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public PenguinModel() {
		
		super(true, 13.0F, 0.0F);
		
		texWidth = 64;
		texHeight = 64;
		
		body = new ModelRenderer(this);
		body.setPos(0.0F, 15.5F, 0.5F);
		body.texOffs(0, 0).addBox(-4.0F, -6.5F, -2.5F, 8.0F, 13.0F, 5.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 6.0F, 0.5F);
		head.texOffs(0, 18).addBox(-3.0F, -3.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, false);
		head.texOffs(17, 19).addBox(-1.0F, 1.0F, -3.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setPos(-4.5F, 9.5F, 0.5F);
		leftArm.texOffs(26, 0).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setPos(4.5F, 9.5F, 0.5F);
		rightArm.texOffs(22, 25).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setPos(-2.5F, 22.0F, 0.5F);
		leftLeg.texOffs(9, 30).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftLeg.texOffs(22, 19).addBox(-1.5F, 1.0F, -3.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setPos(2.5F, 22.0F, 0.5F);
		rightLeg.texOffs(0, 29).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightLeg.texOffs(21, 13).addBox(-1.5F, 1.0F, -3.5F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		
		head.xRot = headPitch * ((float)Math.PI / 180F);
        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        
        //body.xRot = ((float)Math.PI / 2F);
        
        //leftArm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        //rightArm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        
        leftLeg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        rightLeg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		
        leftArm.zRot = Math.abs(MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F);
        rightArm.zRot = -Math.abs(MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F);
        
        //this.wing0.zRot = p_225597_4_;
        //this.wing1.zRot = -p_225597_4_;
        
	}

	@Override
	protected Iterable<ModelRenderer> headParts() {
		return ImmutableList.of(head);
	}

	@Override
	protected Iterable<ModelRenderer> bodyParts() {
		return ImmutableList.of(body, leftArm, rightArm, leftLeg, rightLeg);
	}
	
}