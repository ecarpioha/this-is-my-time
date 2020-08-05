package edu.app.server.controller;

import edu.app.server.model.Authority;
import edu.app.server.service.AuthorityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/authority")
public class AuthorityRestController {
    private final AuthorityService authorityService;

    public AuthorityRestController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Authority>> getAll() {
        return ResponseEntity.ok(this.authorityService.getAllAuthorities());
    }

    @PutMapping("/new")
    public ResponseEntity<Authority> newAuthority(@Valid @RequestBody Authority user) {
        return ResponseEntity.ok(this.authorityService.saveAuthority(user));
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Authority> findOne(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(this.authorityService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOne(@PathVariable @Min(1) Long id) {
        Authority authority = new Authority();
        authority.setId(id);
        this.authorityService.deleteAuthority(authority);
    }

}