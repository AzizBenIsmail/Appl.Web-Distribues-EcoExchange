package com.trade.microservicetrade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Trade implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Temporal(TemporalType.DATE)
    private Date proposalDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Trade() {
    }
    public Trade( Date proposalDate, Status status) {
        this.proposalDate = proposalDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Date getProposalDate() {
        return proposalDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setProposalDate(Date proposalDate) {
        this.proposalDate = proposalDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
