package org.example.services;

import org.example.exceptions.BookNotFoundException;
import org.example.models.entities.Customiser;
import org.example.repositories.CustomiserRepositoryImpl;

import java.util.List;

public class CustomiserServiceImpl {
    private CustomiserRepositoryImpl customiserRepository;

    public CustomiserServiceImpl() {
        this.customiserRepository = new CustomiserRepositoryImpl();
    }
    String customiser = "CUSTOMISER";

    public Customiser getOne(Integer id,String idName){
        return customiserRepository.getOne(id, customiser,idName);
    }
    public List<Customiser> getMany(){
        return customiserRepository.getMany(customiser);
    }
    public Customiser add(Customiser customiser){
        return customiserRepository.add(customiser);
    }
    public boolean delete(Integer id,String idName){
        if (!customiserRepository.delete(id,customiser,idName))
            throw new BookNotFoundException();
        return customiserRepository.delete(id,customiser,idName);
    }
    public boolean update(Integer id,Customiser customiserObject){
        if (!customiserRepository.update(customiserObject,id))
            throw new BookNotFoundException();
        return customiserRepository.update(customiserObject,id);
    }
}
