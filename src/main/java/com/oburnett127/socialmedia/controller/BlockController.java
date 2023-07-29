package com.oburnett127.socialmedia.controller;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.oburnett127.socialmedia.model.Block;
import com.oburnett127.socialmedia.model.request.BlockCreateRequest;
import com.oburnett127.socialmedia.service.BlockService;
import java.io.IOException;
import java.util.List;
import com.oburnett127.socialmedia.model.request.BlockedStatusRequest;

@RestController
@RequestMapping("/block")
public class BlockController {
    private final BlockService service;

    public BlockController(BlockService service) {
        this.service = service;
    }

    @PostMapping("/getblockedstatus")
    public ResponseEntity<Boolean> getBlockedStatus(@Validated @RequestBody BlockedStatusRequest blockedStatusRequest) {
        System.out.println("inside BlockController.getBlockedStatus() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final boolean blockedStatus = service.getBlockedStatus(blockedStatusRequest);
        System.out.println("blocked stat is: " + blockedStatus);
        return ResponseEntity.ok().body(blockedStatus);
    }
    
    @GetMapping("/getblocks/{blockerId}")
    public ResponseEntity<List<Block>> getBlocksByBlockerId(@Validated @PathVariable ObjectId blockerId) {
        System.out.println("inside BlockController.getBlockById() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        final List<Block> blocks = service.getBlocksByBlockerId(blockerId);
        return ResponseEntity.ok().body(blocks);
    }

    @PostMapping("/create")
    public ResponseEntity<Block> createBlock(@Validated @RequestBody BlockCreateRequest blockCreateRequest) throws IOException {
        System.out.println("inside BlockController.createBlock() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        System.out.println("blocker: " + blockCreateRequest.getBlockerUserId());
        System.out.println("blocked: " + blockCreateRequest.getBlockedUserId());
        final Block block = Block.builder()
                .blockerUserId(blockCreateRequest.getBlockerUserId())
                .blockedUserId(blockCreateRequest.getBlockedUserId())
                .build();
        service.createBlock(block);
        return ResponseEntity.ok(block);
    }

    @PostMapping("/delete")
    public ResponseEntity<Block> deleteBlock(@Validated @RequestBody BlockedStatusRequest blockedStatusRequest) throws IOException {
        System.out.println("inside BlockController.deleteBlock() $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ --------------------");
        service.deleteBlock(blockedStatusRequest);
        return ResponseEntity.ok().body(null);
    }
}