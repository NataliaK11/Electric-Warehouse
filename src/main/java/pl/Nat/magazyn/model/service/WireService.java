package pl.Nat.magazyn.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Nat.magazyn.model.entity.WireEntity;
import pl.Nat.magazyn.model.form.WireForm;
import pl.Nat.magazyn.model.repository.WireRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WireService {
    List wireList = new ArrayList<>();

    @Autowired
    WireRepository wireRepository;

    public Iterable<WireEntity> showAllWires() {
        return wireRepository.findAll();
    }

    public void addNewWire(WireForm wireForm) {
        WireEntity wire = new WireEntity();
        wire.setLength(wireForm.getLength());
        wire.setType(wireForm.getType());
        wireRepository.save(wire);

    }


}
