package lk.ijse.pos.api;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 8/2/2023
 * Time : 11:35 PM
 */

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return new ResponseEntity<>(itemService.getAllItem(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> saveItem(@RequestBody ItemDTO itemDTO){
        itemService.addItem(itemDTO);
        return new ResponseEntity<>(itemDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemDTO);
        return new ResponseEntity<>(itemDTO, HttpStatus.OK);
    }

    @DeleteMapping(params = "itemCode")
    public ResponseEntity<String> deleteItem(String itemCode){
        itemService.deleteItem(itemCode);
        return new ResponseEntity<>(itemCode+" Item Deleted..!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItem(@RequestBody ItemDTO itemDTO){
        itemService.deleteItem(itemDTO.getItemCode());
        return new ResponseEntity<>(itemDTO.getItemCode()+" Item Deleted..!", HttpStatus.OK);
    }
}
