DROP TABLE IF EXISTS account_list;

CREATE TABLE account_list (
  customer_id INTEGER NOT NULL,
  account_number INTEGER PRIMARY KEY,
  account_name VARCHAR(50) NOT NULL,
  account_type VARCHAR(15) NOT NULL,
  balance_date VARCHAR(50) NOT NULL,
  currency VARCHAR(3),
  opening_balance DOUBLE default 0.0
);


CREATE TABLE transaction_list (
  account_number INTEGER NOT NULL,
  account_name VARCHAR(50) NOT NULL,
  value_date VARCHAR(50) NOT NULL,
  currency VARCHAR(3),
  debit_amount DOUBLE ,
  credit_amount DOUBLE ,
  debit_or_credit VARCHAR(50) NOT NULL,
  transaction_narrative VARCHAR(250)
);



INSERT INTO account_list (customer_id,account_number, account_name, account_type,balance_date,currency,opening_balance ) VALUES
  (87656898,585309209, 'SGSavings726', 'Savings','08/11/2018','SGD',84327.51);

INSERT INTO account_list (customer_id,account_number, account_name, account_type,balance_date,currency,opening_balance ) VALUES
  (87656898,791066619, 'AUSavings933', 'Savings','08/11/2018','AUD',88005.93);

INSERT INTO account_list (customer_id,account_number, account_name, account_type,balance_date,currency,opening_balance ) VALUES
  (56798787,321143048, 'AUCurrent433', 'Current','08/11/2018','AUD',38010.62);

INSERT INTO transaction_list (account_number, account_name, value_date,currency,debit_amount,credit_amount,debit_or_credit, transaction_narrative) VALUES
  (321143048, 'Current Account', 'Jan 12 2012','SGD',0.0 ,9540.00,'Credit',' ');

INSERT INTO transaction_list (account_number, account_name, value_date,currency,debit_amount,credit_amount,debit_or_credit, transaction_narrative) VALUES
  (321143048, 'Current Account', 'Jan 12 2012','SGD',0.0 ,6732.00,'Credit',' ');

INSERT INTO transaction_list (account_number, account_name, value_date,currency,debit_amount,credit_amount,debit_or_credit, transaction_narrative) VALUES
  (321143048, 'Current Account', 'Jan 12 2012','SGD',0.0 ,4391.40,'Credit',' ');

INSERT INTO transaction_list (account_number, account_name, value_date,currency,debit_amount,credit_amount,debit_or_credit, transaction_narrative) VALUES
  (321143048, 'Current Account', 'Jan 12 2012','SGD',3452.30,0.0 ,'Debit','Home Loan EMI');

INSERT INTO transaction_list (account_number, account_name, value_date,currency,debit_amount,credit_amount,debit_or_credit, transaction_narrative) VALUES
  (791066619, 'Savings Account', 'Jan 12 2012','SGD',6568.80,0.0 ,'Debit','Grocerries');