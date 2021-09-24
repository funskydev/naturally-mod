package elfamoso.naturally.client.render;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.client.model.PenguinModel;
import elfamoso.naturally.entity.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinRender extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Naturally.MOD_ID, "textures/entity/penguin.png");

    public PenguinRender(EntityRendererManager renderManager) {
    	super(renderManager, new PenguinModel<>(), 0.4f);
    }

    @Override
	public ResourceLocation getTextureLocation(PenguinEntity entity) {
		return TEXTURE;
	}
	
}
