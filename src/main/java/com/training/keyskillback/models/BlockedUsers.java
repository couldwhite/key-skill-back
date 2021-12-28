package com.training.keyskillback.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "blocked_users")
public class BlockedUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begin_block", nullable = false)
    private Date beginOfBlock;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_block", nullable = false)
    private Date dateOfBlock;

    public BlockedUsers() {
    }

    public BlockedUsers(Long user_id, Date beginOfBlock, Date dateOfBlock) {
        this.beginOfBlock = beginOfBlock;
        this.dateOfBlock = dateOfBlock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginOfBlock() {
        return beginOfBlock;
    }

    public void setBeginOfBlock(Date beginOfBlock) {
        this.beginOfBlock = beginOfBlock;
    }

    public Date getDateOfBlock() {
        return dateOfBlock;
    }

    public void setDateOfBlock(Date dateOfBlock) {
        this.dateOfBlock = dateOfBlock;
    }
}
