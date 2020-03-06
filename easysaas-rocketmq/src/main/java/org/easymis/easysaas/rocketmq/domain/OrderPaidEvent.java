package org.easymis.easysaas.rocketmq.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 传送对象
 */
public class OrderPaidEvent implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String orderId;

  private BigDecimal paidMoney;

  public OrderPaidEvent() {
  }

  public OrderPaidEvent(String orderId, BigDecimal paidMoney) {
      this.orderId = orderId;
      this.paidMoney = paidMoney;
  }

  public String getOrderId() {
      return orderId;
  }

  public void setOrderId(String orderId) {
      this.orderId = orderId;
  }

  public BigDecimal getPaidMoney() {
      return paidMoney;
  }

  public void setPaidMoney(BigDecimal paidMoney) {
      this.paidMoney = paidMoney;
  }

  @Override
  public String toString() {
    return "OrderPaidEvent [orderId=" + orderId + ", paidMoney=" + paidMoney + "]";
  }
  
}
