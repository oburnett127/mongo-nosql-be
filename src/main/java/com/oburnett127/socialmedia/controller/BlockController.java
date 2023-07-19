package com.oburnett127.socialmedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.model.request.BlockCreateRequest;
import com.oburnett127.socialmedia.service.BlockService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    private final BlockService service;

    public BlockController(BlockService service) {
        this.service = service;
    }

    @GetMapping("/getblocks/{blockerId}")
    public ResponseEntity<List<Block>> getBlocksByBlockerId(@Validated @PathVariable String blockerId) {
        System.out.println("inside BlockController.getBlockById() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final List<Block> blocks = service.getBlocksByBlockerId(Integer.parseInt(blockerId));
        return ResponseEntity.ok().body(blocks);
    }

    @PostMapping("/create")
    public ResponseEntity<Block> createBlock(@Validated @RequestBody BlockCreateRequest blockCreateRequest) throws IOException {
        System.out.println("inside BlockController.createBlock() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final Block block = Block.builder()
                .blockerUserId(blockCreateRequest.getBlockerUserId())
                .blockedUserId(blockCreateRequest.getBlockedUserId())
                .build();
        service.createBlock(block);
        return ResponseEntity.ok(block);
    }

    @PostMapping("/delete/{blockId}")
    public ResponseEntity<Block> deleteBlock(@Validated @PathVariable int blockId) throws IOException {
        System.out.println("inside BlockController.deleteBlock() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.deleteBlock(blockId);
        return ResponseEntity.ok().body(null);
    }
}