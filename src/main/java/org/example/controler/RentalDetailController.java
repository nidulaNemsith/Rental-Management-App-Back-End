package org.example.controler;

import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.dto.RentalDetail;
import org.example.service.RentalDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-detail-controller")
@RequiredArgsConstructor
public class RentalDetailController {

    final RentalDetailService rentalDetailService;
    @PostMapping("new-rent")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody RentalDetail rentalDetail){
        rentalDetailService.addItem(rentalDetail);
    }
    @GetMapping("get-all")
    public List<RentalDetail> getAll(){
        return rentalDetailService.getAll();
    }
    @DeleteMapping("/delete-rent/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable Long id){
        rentalDetailService.deleteById(id);
        return "Deleted..!";
    }
    @PutMapping("update-rent")
    public String update(@RequestBody RentalDetail rentalDetail){
        rentalDetailService.update(rentalDetail);
        return "Updated..!";
    }
    @GetMapping("get-by-Id/{id}")
    public RentalDetail getById(@PathVariable Long id){
        return rentalDetailService.getItemById(id);
    }

}
