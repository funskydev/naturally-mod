package elfamoso.naturally.client.render;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.client.model.RatModel;
import elfamoso.naturally.entity.RatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RatRender extends MobRenderer<RatEntity, RatModel<RatEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Naturally.MOD_ID, "textures/entity/rat.png");

    public RatRender(EntityRendererManager renderManager) {
    	super(renderManager, new RatModel<>(), 0.3f);
    }

    @Override
	public ResourceLocation getTextureLocation(RatEntity entity) {
		return TEXTURE;
	}
	
}