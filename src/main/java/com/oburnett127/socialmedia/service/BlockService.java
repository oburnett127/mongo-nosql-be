package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.repository.BlockRepository;
import java.util.List;

@Service
public class BlockService {
    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @SneakyThrows
    public List<Block> getBlocksByBlockerId(int userId) {
        return blockRepository.findByBlockerId(userId);
    }

    @SneakyThrows
    public void createBlock(Block block) {
        blockRepository.save(block);   
    }

    @SneakyThrows
    public void deleteBlock(int blockId) {
        blockRepository.deleteById(blockId);
    }
}