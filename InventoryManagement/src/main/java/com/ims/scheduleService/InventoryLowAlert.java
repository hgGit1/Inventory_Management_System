package com.ims.scheduleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.ims.model.Inventory.catogoryEnum;
import com.ims.model.InventoryQuantity;
import com.ims.repository.InventoryQuantityRepository;
import com.ims.repository.InventoryRepository;

@Service
public class InventoryLowAlert {
	
	@Autowired
	private InventoryQuantityRepository iqRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Scheduled(cron = "0 */5 * * * *") // Runs at every 5 minute
	public void checkRecordandMapInventory() {
		List<Object[]> getInventoryQuantityOnName = inventoryRepository.findInventoryQuantity();
		
		if(getInventoryQuantityOnName!=null) {
			int i = 1;
			for(Object[] result:getInventoryQuantityOnName) {
				InventoryQuantity iq = new InventoryQuantity();
				iq.setId(i);
				iq.setCategory((catogoryEnum)result[1]);
				iq.setInventoryName((String)result[0]);
				iq.setQuantity((Long)result[2]);
				
				iqRepository.save(iq);
				i++;
			}
			
		}
	}


}
