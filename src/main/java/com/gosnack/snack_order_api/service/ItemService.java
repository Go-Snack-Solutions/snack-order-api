package com.gosnack.snack_order_api.service;

import com.gosnack.snack_order_api.dto.ItemRecord;
import com.gosnack.snack_order_api.dto.OrderRecord;
import com.gosnack.snack_order_api.model.ItemModel;
import com.gosnack.snack_order_api.model.OrderModel;
import com.gosnack.snack_order_api.repository.ItemRepository;
import com.gosnack.snack_order_api.repository.OrderRepository;
import com.gosnack.snack_order_api.utils.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ItemModel createItems(ItemRecord itemRecord, String orderId) {

        var itemModel = new ItemModel();
        itemModel.setItemName(itemRecord.itemName());
        itemModel.setItemPrice(itemRecord.itemPrice());


        return itemRepository.save(itemModel);
    }

}
