package org.accountManagerService.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name="transaction_list")
public class TransactionListEntity {

    @Id
    @Column(name="account_number")
    private long account_number;
    
    @Column(name="account_name")
    private String account_name;

    @Column(name="value_date")
    private String value_date;

    @Column(name="currency")
	private String currency;

	@Column(name="debit_amount")
	private double debit_amount;

    @Column(name="credit_amount")
    private double credit_amount;

    @Column(name="debit_or_credit")
    private String debit_or_credit;

    @Column(name="transaction_narrative")
    private String transaction_narrative;


    @Override
    public String toString() {
        return "AccountListEntity [ account_number=" + account_number +
                ", account_name=" + account_name + ", value_date=" + value_date   +
                ", currency=" + currency +", debit_amount=" + debit_amount +", credit_amount=" + credit_amount+
				", debit_or_credit=" + debit_or_credit +", transaction_narrative=" + transaction_narrative +"]";
    }
}