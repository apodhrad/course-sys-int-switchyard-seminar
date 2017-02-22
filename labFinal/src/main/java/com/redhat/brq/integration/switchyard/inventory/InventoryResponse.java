package com.redhat.brq.integration.switchyard.inventory;

public class InventoryResponse {

	private long orderId;
	private int articleId;
	private int amountReserver;
	private int amountLeft;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getAmountReserver() {
		return amountReserver;
	}

	public void setAmountReserver(int amountReserver) {
		this.amountReserver = amountReserver;
	}

	public int getAmountLeft() {
		return amountLeft;
	}

	public void setAmountLeft(int amountLeft) {
		this.amountLeft = amountLeft;
	}
}
