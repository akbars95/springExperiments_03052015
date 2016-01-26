package com.mtsmda.souvenir.dao;

import com.mtsmda.souvenir.model.Souvenir;

import java.util.List;

/**
 * Created by MTSMDA on 16.11.2015.
 */
public interface SouvenirDAO {

    public boolean insertSouvenir(Souvenir souvenir);
    public boolean updateSouvenir(Souvenir souvenir);
    public boolean deleteSouvenir(Souvenir souvenir);
    public Souvenir getSouvenir(Integer souvenirId);
    public List<Souvenir> getAllSouvenir();

    public boolean hideSouvenir(Souvenir souvenir);

}