package com.example.WebService.Spring.Entites.PK;

import java.io.Serializable;
import java.util.Objects;
import com.example.WebService.Spring.Entites.Order;
import com.example.WebService.Spring.Entites.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable {
	/*
	 Classe usada para representar a chave primaria composta que relaciona
	 um pedido a um produto.	 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//HASH CODE E EQUALS DOS 2 ATRIBUTOS
	//OS 2 JUNTOS IDENTIFICAM O ITEM
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	

}
