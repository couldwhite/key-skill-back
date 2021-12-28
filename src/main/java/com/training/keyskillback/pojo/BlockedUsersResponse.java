package com.training.keyskillback.pojo;

public class BlockedUsersResponse {
    private boolean checkBlock;
    private String blockDate;

    public BlockedUsersResponse(boolean checkBlock, String blockDate) {
        this.checkBlock = checkBlock;
        this.blockDate = blockDate;
    }

    public boolean isCheckBlock() {
        return checkBlock;
    }

    public void setCheckBlock(boolean checkBlock) {
        this.checkBlock = checkBlock;
    }

    public String getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(String blockDate) {
        this.blockDate = blockDate;
    }
}
