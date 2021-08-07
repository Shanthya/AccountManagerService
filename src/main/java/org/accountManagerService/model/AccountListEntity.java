package org.accountManagerService.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name="account_list")
public class AccountListEntity {

    @Id
    @Column(name="customer_id")
    private long customer_id;

    @Column(name="account_number")
    private int account_number;
    
    @Column(name="account_name")
    private String account_name;

	@Column(name="account_type")
	private String account_type;

	@Column(name="balance_date")
	private String balance_date;

	@Column(name="currency")
	private String currency;

	@Column(name="opening_balance")
	private String opening_balance;
    

    @Override
    public String toString() {
        return "AccountListEntity [customer_id=" + customer_id + ", account_number=" + account_number +
                ", account_name=" + account_name + ", account_type=" + account_type   +
				", balance_date=" + balance_date +", currency=" + currency +", opening_balance=" + opening_balance+"]";
    }
}