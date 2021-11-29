package controller;

import domain.Instrument;
import repo.Repo;

import java.util.List;

public class InstrumentController {
    private Repo repo;

    public InstrumentController(Repo repo) {
        this.repo = repo;
        init();
    }

    private void init() {
        Instrument ins1 = new Instrument("Fender", "guitar", 300.50);
        Instrument ins2 = new Instrument("Stratovarius", "violin", 1300.50);
        Instrument ins3 = new Instrument("Marshall", "Pedal", 199.90);

        repo.getInstrumentList().add(ins1);
        repo.getInstrumentList().add(ins2);
        repo.getInstrumentList().add(ins3);
    }

    public void add(String name, String type, double price) {
        this.repo.getInstrumentList().add(new Instrument(name, type, price));
    }

    public void delete(int index) {
        this.repo.getInstrumentList().remove(index - 1);
    }

    public void update(int index, String name, String type, double price) {
        Instrument ins = this.repo.getInstrumentList().get(index - 1);
        ins.setName(name);
        ins.setType(type);
        ins.setPrice(price);
    }

    public List<Instrument> getAll() {
        return this.repo.getInstrumentList();
    }

    @Override
    public String toString() {
        return "InstrumentController{" +
                "repo=" + repo +
                '}';
    }
}
