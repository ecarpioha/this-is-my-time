package edu.app.server.controller;

import edu.app.server.model.Periodicity;
import edu.app.server.service.PeriodicityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/periodicity")
public class PeriodicityRestController {
    private final PeriodicityService periodicityService;

    public PeriodicityRestController(PeriodicityService periodicityService) {
        this.periodicityService = periodicityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Periodicity>> findAll() {
        return ResponseEntity.ok(this.periodicityService.getAllPeriodicity());
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Periodicity> newPeriodicity(@Valid @RequestBody Periodicity periodicity) {
        return ResponseEntity.ok(this.periodicityService.savePeriodicity(periodicity));
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Periodicity> findOne(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(this.periodicityService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOne(@PathVariable @Min(1) Long id) {
        Periodicity periodicity = new Periodicity();
        periodicity.setId(id);
        this.periodicityService.deletePeriodicity(periodicity);
    }
}