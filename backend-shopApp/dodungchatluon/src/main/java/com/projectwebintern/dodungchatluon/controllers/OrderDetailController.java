package com.projectwebintern.dodungchatluon.controllers;

import com.projectwebintern.dodungchatluon.dto.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {

    @PostMapping("")
    public ResponseEntity<?> create
            (@RequestBody @Valid OrderDetailDTO orderDetailDTO){
        return ResponseEntity.ok("create order detail");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll
            (@PathVariable("id") @Valid Long id){
        return ResponseEntity.ok("get order detail" + id);
    }

    @GetMapping("/order/{order_id}")
    public ResponseEntity<?> getOrderDetailId
            (@PathVariable("order_id") @Valid Long order_id){
        return ResponseEntity.ok("get order detail" + order_id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update
            (@PathVariable("id") @Valid Long id,
             @RequestBody @Valid OrderDetailDTO orderDetailDTO){
        return ResponseEntity.ok("update with id:"+ id +", new: "+ orderDetailDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete
            (@PathVariable("id") @Valid Long id){
        return ResponseEntity.noContent().build();
    }
}
