package com.trade.microservicetrade;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trade implements Serializable {
    @Id
    @GeneratedValue
     long id;

    @Temporal(TemporalType.DATE)
     Date tradeStartDate;
    @Temporal(TemporalType.DATE)
     Date tradeEndDate;

    @Enumerated(EnumType.STRING)
    Status status;


    @ManyToOne
     Item offeredItem;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    Item requestedItem;



}
