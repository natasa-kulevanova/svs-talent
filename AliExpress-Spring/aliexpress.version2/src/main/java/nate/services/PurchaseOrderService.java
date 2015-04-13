package nate.services;

import nate.dao.PurchaseOrderDao;
import nate.entities.PurchaseOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {

	PurchaseOrderDao pod;
	
	@Autowired
	public PurchaseOrderService(PurchaseOrderDao pod){
		this.pod = pod;
	}
	
	public void registerPurchaseOrder(PurchaseOrder po){
		pod.registerPurchaseOrder(po);
	}
	public void unregisterPurchaseOrder(PurchaseOrder po){
		pod.unregisterPurchaseOrder(po);
	}
	
}
