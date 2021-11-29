package repo;

import domain.Instrument;

import java.util.ArrayList;
import java.util.List;

public class Repo {
    private List<Instrument> instrumentList;

    public Repo() {
        this.instrumentList = new ArrayList<>();
    }

    public List<Instrument> getInstrumentList() {
        return instrumentList;
    }

    public void setInstrumentList(List<Instrument> instrumentList) {
        this.instrumentList = instrumentList;
    }

    @Override
    public String toString() {
        return "repo.Repo{" +
                "instrumentList=" + instrumentList +
                '}';
    }
}
