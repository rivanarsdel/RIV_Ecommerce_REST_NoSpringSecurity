package dev.riv.REST_TurboBasic.controllers;

import dev.riv.REST_TurboBasic.modelDTOs.OrderDTO;
import dev.riv.REST_TurboBasic.models.Order;
import dev.riv.REST_TurboBasic.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5000", "http://localhost:8080" } )
public class OrderController {
    private OrderService orderService;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public Optional<Order> upsertProduct (OrderDTO orderDTO) throws NoSuchAlgorithmException {
        Order orderObj = orderService.upsertOrder(orderDTO);
        return Optional.of(orderObj);
    }
    @GetMapping
    public Optional<List<Order>> getAllOrders () {
        return Optional.of(orderService.getAllOrders());
    }
    @DeleteMapping
    public void deleteOrderByHash (String orderHash) {
        orderService.deleteOrderByOrderHash(orderHash);
    }
}
