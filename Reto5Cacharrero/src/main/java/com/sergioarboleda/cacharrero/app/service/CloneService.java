package com.sergioarboleda.cacharrero.app.service;

import com.sergioarboleda.cacharrero.app.model.Clone;
import com.sergioarboleda.cacharrero.app.repository.CloneRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carotobarj
 */
@Service

public class CloneService {

    @Autowired
    CloneRepository cloneRepository;

    /**
     *
     * @return
     */
    public List<Clone> getAll() {
        return cloneRepository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Clone> getById(Integer id) {
        return cloneRepository.getById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Clone> getClone(Integer id) {
        return cloneRepository.getClone(id);
    }

    /**
     *
     * @param clone
     * @return
     */
    public Clone save(Clone clone) {

        if (clone.getBrand() == null || clone.getProcesor() == null
                || clone.getOs() == null || clone.getDescription() == null
                || clone.getMemory() == null || clone.getHardDrive() == null
                || clone.getPrice() == null || clone.getQuantity() == null) {
            return clone;
        } else {
            Optional<Clone> cloneAux = cloneRepository.getClone(clone.getId());
            if (cloneAux.isEmpty()) {
                return cloneRepository.save(clone);
            } else {
                return clone;
            }
        }
    }

    /**
     *
     * @param clone
     * @return
     */
    
    public Clone update(Clone clone) {
        if (clone.getId() != null) {
            Optional<Clone> auxClone = cloneRepository.getClone(clone.getId());
            if (!auxClone.isEmpty()) {
                if (clone.getBrand() != null) {
                    auxClone.get().setBrand(clone.getBrand());
                }

                if (clone.getProcesor() != null) {
                    auxClone.get().setProcesor(clone.getProcesor());
                }

                if (clone.getOs() != null) {
                    auxClone.get().setOs(clone.getOs());
                }

                if (clone.getDescription() != null) {
                    auxClone.get().setDescription(clone.getDescription());
                }

                if (clone.getMemory() != null) {
                    auxClone.get().setMemory(clone.getMemory());
                }

                if (clone.getHardDrive() != null) {
                    auxClone.get().setHardDrive(clone.getHardDrive());
                }

                if (clone.getPrice() != null) {
                    auxClone.get().setPrice(clone.getPrice());
                }

                if (clone.getQuantity() != null) {
                    auxClone.get().setQuantity(clone.getQuantity());
                }

                if (clone.getPhotography() != null) {
                    auxClone.get().setPhotography(clone.getPhotography());
                }

                cloneRepository.save(auxClone.get());
                return auxClone.get();
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }

    /**
     * 
     * @param id
     * @return 
     */
    
    
    public Boolean delClon(Integer id) {
        Boolean aBoolean = getClone(id).map(clone -> {
            cloneRepository.delClone(clone);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    /**
     * 
     * @param price
     * @return 
     */
    
    public List<Clone> getPrice(double price) {
        return cloneRepository.getPrice(price);
    }
    /**
     * 
     * @param string1
     * @param string2
     * @return 
     */
    
    private boolean checkStrings(String string1, String string2) {

        return string1.indexOf(string2)>=0;
    }
    
public List <Clone> findByDescription (String description2){
        List <Clone> clones = cloneRepository.getAll();
        ArrayList<Clone> clones2 = new ArrayList();
        for(Clone clon: clones){
            String descripcion1 = clon.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                clones2.add(clon);
            }
            
        }
        
        return (List<Clone>) clones2;
    }
}
