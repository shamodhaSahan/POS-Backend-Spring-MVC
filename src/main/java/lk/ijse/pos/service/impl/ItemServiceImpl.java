package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.repo.ItemRepo;
import lk.ijse.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/7/2023
 * Time : 11:10 PM
 */

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemDTO> getAllItem() {
        return modelMapper.map(itemRepo.findAll(), new TypeToken<List<ItemDTO>>(){}.getType());
    }

    @Override
    public void addItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemCode()))
            throw new RuntimeException("Item Code : "+itemDTO.getItemCode()+" Already exists..!");
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getItemCode()))
            throw new RuntimeException("Item Code : "+itemDTO.getItemCode()+" Item not found..!");
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void deleteItem(String itemCode) {
        if (!itemRepo.existsById(itemCode))
            throw new RuntimeException("Item Code : "+itemCode+" Item not found..!");
        itemRepo.deleteById(itemCode);
    }
}
