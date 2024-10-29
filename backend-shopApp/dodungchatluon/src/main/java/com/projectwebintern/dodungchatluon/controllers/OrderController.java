package com.projectwebintern.dodungchatluon.controllers;

import com.projectwebintern.dodungchatluon.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {

    @PostMapping("")
    public ResponseEntity<?> create
            (@RequestBody @Valid OrderDTO orderDTO,
             BindingResult result){
        try {
            if(result.hasErrors()){
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errors);
            }
            return ResponseEntity.ok("create order success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getAll
            (@PathVariable("user_id") @Valid Long userId){
        try {
            return ResponseEntity.ok("get orders success");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update
            (@PathVariable("id") Long id,
             @RequestBody @Valid OrderDTO orderDTO){
        return ResponseEntity.ok("update order success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete
            (@PathVariable("id") @Valid Long id){
        return ResponseEntity.ok("delete order success");
    }
}
