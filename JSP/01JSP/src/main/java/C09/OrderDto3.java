package C09;

import java.time.LocalDate;

public class OrderDto3 {

	private String addr;
	private LocalDate order_date;
	private int sum_price;

	public OrderDto3() {}

	public OrderDto3(String addr, LocalDate order_date, int sum_price) {
		super();
		this.addr = addr;
		this.order_date = order_date;
		this.sum_price = sum_price;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public int getSum_price() {
		return sum_price;
	}

	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}

	@Override
	public String toString() {
		return "OrderDt03 [addr=" + addr + ", order_date=" + order_date + ", sum_price=" + sum_price + "]";
	}
	
}
