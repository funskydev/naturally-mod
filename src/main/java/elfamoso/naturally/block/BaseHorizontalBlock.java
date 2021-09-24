package elfamoso.naturally.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class BaseHorizontalBlock extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	
	public BaseHorizontalBlock(Properties properties) {
		
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
		
	}
	
	@Deprecated
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
		
	}
	
	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
		
		return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
		
	}
	
	@Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
        
    }
	
}
