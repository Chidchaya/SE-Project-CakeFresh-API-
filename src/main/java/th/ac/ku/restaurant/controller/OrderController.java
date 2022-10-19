package th.ac.ku.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.restaurant.model.CakeOrder;
import th.ac.ku.restaurant.service.OrderService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<CakeOrder> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    public CakeOrder create(@RequestBody CakeOrder order)
    {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public CakeOrder getOrder(@PathVariable UUID id)
    {
        return service.getOrder(id);
    }

    @PutMapping("/{id}")
    public CakeOrder update(@PathVariable UUID id, @RequestBody CakeOrder order)
    {
        return service.update(id, order);
    }

    @DeleteMapping("/{id}")
    public CakeOrder delete(@PathVariable UUID id)
    {
        return service.delete(id);
    }
}
