package com.littenboi.thegrim.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class GrimGrassBlock extends GrassBlock {
    public GrimGrassBlock(Settings settings) {
        super(settings);
    }

    // Remove @Override if you get the error
    public boolean canPlantOnTop(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }
}