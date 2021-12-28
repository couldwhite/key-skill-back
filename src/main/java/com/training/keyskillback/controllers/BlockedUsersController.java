package com.training.keyskillback.controllers;

import com.training.keyskillback.models.BlockedUsers;
import com.training.keyskillback.pojo.BlockedUsersRequest;
import com.training.keyskillback.pojo.BlockedUsersResponse;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.BlockedUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/api/block")
public class BlockedUsersController {

    @Autowired
    BlockedUsersRepository blockedUsersRepository;

    @Transactional
    @PostMapping("/blockUser")
    public ResponseEntity<?> blockUser(@RequestBody BlockedUsersRequest blockedUsersRequest) {
        Timestamp beginBlockDate = new Timestamp(new Date().getTime());
        Timestamp endBlockDate = null;
        if (blockedUsersRequest.getBlockTime().equals("Час")) {
            endBlockDate = new Timestamp(beginBlockDate.getTime() + 3600000L);
        } else if (blockedUsersRequest.getBlockTime().equals("День")) {
            endBlockDate = new Timestamp(beginBlockDate.getTime() + 86400000L);
        } else if (blockedUsersRequest.getBlockTime().equals("Неделя")) {
            endBlockDate = new Timestamp(beginBlockDate.getTime() + 604800000L);
        } else if (blockedUsersRequest.getBlockTime().equals("Навсегда")) {
            endBlockDate = new Timestamp(beginBlockDate.getTime() + 1000000000000L);
        }
        blockedUsersRepository.blockUser(beginBlockDate, endBlockDate, blockedUsersRequest.getUser_id());
        return ResponseEntity.ok(new MessageResponse("User blocked"));
    }

    @Transactional
    @PostMapping("/unblockUser")
    public ResponseEntity<?> unblockUser(@RequestParam String id) {
            blockedUsersRepository.deleteBlockOnUser(Long.parseLong(id));
        return ResponseEntity.ok(new MessageResponse("User unblocked"));
    }

    @Transactional
    @ResponseBody
    @GetMapping("/checkUserOnBlock")
    public BlockedUsersResponse checkUserOnBlock(@RequestParam String id) {
        boolean checkBlock = false;
        String blockDate = null;
        String formattedBlockDate = null;
        Date currentDate = new Timestamp(new Date().getTime());
        if (blockedUsersRepository.existsByUser_Id(Long.parseLong(id))) {
            if (currentDate.before(blockedUsersRepository.getByUser_Id(Long.parseLong(id)).getDateOfBlock())) {
                Date date = blockedUsersRepository.getByUser_Id(Long.parseLong(id)).getDateOfBlock();
                checkBlock = true;
                blockDate = blockedUsersRepository.getByUser_Id(Long.parseLong(id)).getDateOfBlock().toString();
                formattedBlockDate = String.format(blockDate, "yyyy-MM-dd HH:mm:ss");
            } else {
                blockedUsersRepository.deleteBlockOnUser(Long.parseLong(id));
            }

        }
        return new BlockedUsersResponse(checkBlock, formattedBlockDate);
    }
}
