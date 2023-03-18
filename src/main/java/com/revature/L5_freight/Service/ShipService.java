package com.revature.L5_freight.Service;

import com.revature.L5_freight.Exceptions.InvalidTonnageException;
import com.revature.L5_freight.Model.Ship;
import com.revature.L5_freight.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: add the @Transactional annotation, with rollbackFor = Exception.class. This will wrap all methods in this
 * class inside of a database transaction using AOP, which will prevent incomplete updates in the event of an
 * exception being thrown. It should be assigned to rollback the transaction for any Exception, hence the rollbackFor.
 * You can test this by attempting to POST an array of ships where some ship in the JSON has a negative tonnage, then
 * attempting to get all ships. No ships should be POSTed if any ship in the array has a negative or zero
 * tonnage - we're left to assume some form of unwanted user error in that case.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ShipService {
    ShipRepository shipRepository;
    @Autowired
    public ShipService(ShipRepository shipRepository){
        this.shipRepository = shipRepository;
    }
    /**
     * this is a bad way to save a list to the repository as you can just use the .saveAll method provided the table
     * has a CHECK constraint to check tonnage, but this gets the point across for the importance of @Transactional
     * @param ships transient ship entities
     * @throws InvalidTonnageException ships can not have negative tonnage (they'd sink), containers can not have
     * negative weight (they'd fly away)
     */
    public List<Ship> addListShips(List<Ship> ships) throws InvalidTonnageException {
        List<Ship> persistedShips = new ArrayList<>();
        for(int i = 0; i < ships.size(); i++){
            if(ships.get(i).getTonnage()<=0){
                throw new InvalidTonnageException();
            }
            persistedShips.add(shipRepository.save(ships.get(i)));
        }
        return persistedShips;
    }
    /**
     * @return all ship entities
     */
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }
    /**
     * @return ship entity by id
     */
    public Ship getShipById(long id) {
        return shipRepository.findById(id).get();
    }
}
