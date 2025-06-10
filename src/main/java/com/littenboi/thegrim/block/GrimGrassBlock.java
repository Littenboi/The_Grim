package com.littenboi.thegrim.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import com.littenboi.thegrim.block.ModBlocks;

public class GrimGrassBlock extends GrassBlock implements Fertilizable {
    public GrimGrassBlock(Settings settings) {
        super(settings);
    }

    public boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public boolean isFertilizable(World world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos up = pos.up();
        if (world.getBlockState(up).isAir()) {
            world.setBlockState(up, ModBlocks.GRIM_SHORT_GRASS.getDefaultState());
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // If not enough light, turn into grim dirt
        if (world.getLightLevel(pos.up()) < 4 && world.getBlockState(pos.up()).getOpacity(world, pos.up()) > 2) {
            world.setBlockState(pos, ModBlocks.GRIM_DIRT_BLOCK.getDefaultState());
            return;
        }

        // Try to spread to nearby grim dirt blocks
        if (world.getLightLevel(pos.up()) >= 9) {
            for (int i = 0; i < 4; ++i) {
                BlockPos targetPos = pos.add(
                        random.nextBetween(-1, 1),
                        random.nextBetween(-3, 1),
                        random.nextBetween(-1, 1)
                );
                BlockState targetState = world.getBlockState(targetPos);
                BlockState aboveState = world.getBlockState(targetPos.up());

                if (targetState.isOf(ModBlocks.GRIM_DIRT_BLOCK)
                        && world.getLightLevel(targetPos.up()) >= 4
                        && aboveState.getOpacity(world, targetPos.up()) <= 2) {
                    world.setBlockState(targetPos, ModBlocks.GRIM_GRASS_BLOCK.getDefaultState());
                }
            }
        }
    }
}