package th.ac.ku.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.restaurant.model.Cake;
import th.ac.ku.restaurant.service.CakeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cake")
public class CakeController {
    @Autowired
    private CakeService service;

    @GetMapping
    public List<Cake> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    public Cake create(@RequestBody Cake cake)
    {
        return service.create(cake);
    }

    @GetMapping("/{id}")
    public Cake getCake(@PathVariable UUID id)
    {
        return service.getCake(id);
    }

    @PutMapping("/{id}")
    public Cake update(@PathVariable UUID id, @RequestBody Cake cake)
    {
        return service.update(id, cake);
    }
    @DeleteMapping("/{id}")
    public Cake delete(@PathVariable UUID id)
    {
        return service.delete(id);
    }

}
