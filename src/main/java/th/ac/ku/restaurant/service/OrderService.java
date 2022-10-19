package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.CakeOrder;
import th.ac.ku.restaurant.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<CakeOrder> getAll()
    {
        return repository.findAll();
    }

    public CakeOrder create(CakeOrder order)
    {
        repository.save(order);
        return order;
    }

    public CakeOrder getOrder(UUID id)
    {
        return repository.findById(id).get();
    }

    public CakeOrder update(UUID id, CakeOrder requestBody)
    {
        CakeOrder record = repository.findById(id).get();
        record.setDate(requestBody.getDate());
        record.setName(requestBody.getName());
        record.setMobile(requestBody.getMobile());
        record.setAddress(requestBody.getAddress());
        record.setCake(requestBody.getCake());
        record.setAmount(requestBody.getAmount());
        record.setUsername(requestBody.getUsername());
        record.setPayment(requestBody.getPayment());
        record.setPrice(requestBody.getPrice());
        record.setStatus(requestBody.getStatus());

        repository.save(record);

        return record;
    }

    public CakeOrder delete(UUID id)
    {
        CakeOrder record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
