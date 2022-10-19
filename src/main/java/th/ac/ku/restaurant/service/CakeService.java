package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.Cake;
import th.ac.ku.restaurant.repository.CakeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CakeService {
    @Autowired
    private CakeRepository repository;

    public List<Cake> getAll()
    {
        return repository.findAll();
    }

    public Cake create(Cake cake)
    {
        repository.save(cake);
        return cake;
    }

    public Cake getCake(UUID id)
    {
        return repository.findById(id).get();
    }

    public Cake update(UUID id, Cake requestBody)
    {
        Cake record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setPrice(requestBody.getPrice());
        record.setWeight(requestBody.getWeight());
        record.setAmount(requestBody.getAmount());

        repository.save(record);

        return record; // Return is optional
    }

    public Cake delete(UUID id)
    {
        Cake record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }
}
