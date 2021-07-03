package ru.godsonpeya.springbatchdemo.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class BankTransaction {

    @Id
    private Long id;

    private String accountId;

    private Date transactionDate;

    @Transient
    private String strTransactionDate;

    private String transactionType;

    private Double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BankTransaction that = (BankTransaction) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1164661983;
    }
}
