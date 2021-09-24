package elfamoso.naturally.entity.ai;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MoveOnIceGoal extends MoveToBlockGoal {

	public MoveOnIceGoal(CreatureEntity entity, double speed, int range, int vertRange) {
       super(entity, speed, range, vertRange);
    }
	
    @Override
    protected boolean isValidTarget(IWorldReader worldReader, BlockPos pos) {
       
    	if (!worldReader.isEmptyBlock(pos.above())) {
    		
            return false;
            
    	} else {
    		BlockState center = worldReader.getBlockState(pos);
    		BlockState north = worldReader.getBlockState(pos.north());
    		BlockState east = worldReader.getBlockState(pos.east());
    		BlockState south = worldReader.getBlockState(pos.south());
    		BlockState west = worldReader.getBlockState(pos.east());
            if (isIce(center) && isIce(north) && isIce(east) && isIce(south) && isIce(west)) return true;
            else return false;
    	}
		
    	
    }
    
    private boolean isIce(BlockState block) {
    	if (block.is(Blocks.ICE) || block.is(Blocks.PACKED_ICE) || block.is(Blocks.BLUE_ICE)) return true;
        else return false;
    }

}
