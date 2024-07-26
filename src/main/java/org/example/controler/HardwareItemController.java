package org.example.controler;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.dto.HardwareItem;
import org.example.service.HardwareItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware-item-controller")
@RequiredArgsConstructor
public class HardwareItemController {

    final HardwareItemService hardwareItemService;
    @PostMapping("add-item")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody HardwareItem hardwareItem){
        hardwareItemService.addItem(hardwareItem);
    }
    @GetMapping("get-all")
    public List<HardwareItem> getAll(){
        return hardwareItemService.getAll();
    }
    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable Long id){
        hardwareItemService.deleteById(id);
        return "Deleted..!";
    }
    @PutMapping("update-item")
    public String update(@RequestBody HardwareItem hardwareItem){
        hardwareItemService.update(hardwareItem);
        return "Updated..!";
    }
    @GetMapping("get-by-Id/{id}")
    public HardwareItem getById(@PathVariable Long id){
        return hardwareItemService.getItemById(id);
    }

}
