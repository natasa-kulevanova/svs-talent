package nate.dao;

import nate.entities.PurchaseOrder;

import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDao {
	public void registerPurchaseOrder(PurchaseOrder po);
	public void unregisterPurchaseOrder(PurchaseOrder po);

}