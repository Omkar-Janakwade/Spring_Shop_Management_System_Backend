package com.newproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DailyTransaction {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long transactionId;
		
		private String fullname;
		private String transactionDate;
		private String itemName;
		private String quantity;
		private String deliveryBoyName;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}

	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}

	@Override
	public String toString() {
		return "DailyTransaction [transactionId=" + transactionId + ", fullname=" + fullname + ", transactionDate="
				+ transactionDate + ", itemName=" + itemName + ", quantity=" + quantity + ", deliveryBoyName="
				+ deliveryBoyName + "]";
	}
	

}
