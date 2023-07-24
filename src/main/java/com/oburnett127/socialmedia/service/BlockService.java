package com.oburnett127.socialmedia.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.model.request.BlockedStatusRequest;
import com.oburnett127.socialmedia.repository.BlockRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BlockService {
    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @SneakyThrows
    public boolean getBlockedStatus(BlockedStatusRequest blockedStatusRequest) {
        Optional<Block> block = blockRepository.findByBlockerUserIdAndBlockedUserId(blockedStatusRequest.getBlockerUserId(), 
                                                                                    blockedStatusRequest.getBlockedUserId());
        if(block.isPresent()) return true;
        else return false;                                                           
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
    public void deleteBlock(BlockedStatusRequest blockedStatusRequest) {
        Optional<Block> block = blockRepository.findByBlockerUserIdAndBlockedUserId(blockedStatusRequest.getBlockerUserId(),
                                                                         blockedStatusRequest.getBlockedUserId());
        if (block.isPresent()) blockRepository.delete(block.get());
    }
}