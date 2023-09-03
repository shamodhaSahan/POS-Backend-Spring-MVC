package lk.ijse.pos.service;

import lk.ijse.pos.dto.ItemDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/7/2023
 * Time : 11:10 PM
 */

public interface ItemService {
    List<ItemDTO> getAllItem();

    void addItem(ItemDTO itemDTO);

    void updateItem(ItemDTO itemDTO);

    void deleteItem(String itemCode);
}
