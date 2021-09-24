package elfamoso.naturally.block;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class StumpBlock extends BaseHorizontalBlock {
	
	protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction, VoxelShape>();
	
	private static final VoxelShape SHAPE = Stream.of(
			Block.box(0, 0, 0, 16, 12, 16),
			Block.box(0, 12, 0, 1, 14, 5),
			Block.box(1, 12, 0, 3, 14, 1),
			Block.box(0, 14, 0, 1, 15, 3),
			Block.box(0, 12, 5, 1, 13, 8),
			Block.box(15, 12, 9, 16, 13, 16),
			Block.box(13, 12, 0, 16, 13, 1),
			Block.box(15, 12, 1, 16, 13, 2),
			Block.box(15, 13, 0, 16, 14, 1),
			Block.box(1, 12, 15, 4, 13, 16),
			Block.box(0, 12, 12, 1, 13, 16),
			Block.box(0, 13, 14, 1, 14, 16),
			Block.box(1, 13, 15, 2, 15, 16),
			Block.box(15, 13, 12, 16, 14, 15),
			Block.box(15, 14, 14, 16, 15, 15)
			).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
	
	public StumpBlock(Properties properties) {
		
		super(properties);
		runCalculation(SHAPE);
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		
		return SHAPES.get(state.getValue(FACING));
		
	}
	
	protected static void calculateShapes(Direction to, VoxelShape shape) {
	    VoxelShape[] buffer = new VoxelShape[] { shape, VoxelShapes.empty() };
	 
	    int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
	    
	    for (int i = 0; i < times; i++) {
	        buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
	                VoxelShapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
	        buffer[0] = buffer[1];
	        buffer[1] = VoxelShapes.empty();
	    }
	 
	    SHAPES.put(to, buffer[0]);
	}
	 
	protected void runCalculation(VoxelShape shape) {
	    for (Direction direction : Direction.values()) {
	        calculateShapes(direction, shape);
	    }
	}
	
}
