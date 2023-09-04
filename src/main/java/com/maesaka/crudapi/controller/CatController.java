package com.maesaka.crudapi.controller;

import com.maesaka.crudapi.controller.form.CatCreateForm;
import com.maesaka.crudapi.controller.form.CatUpdateForm;
import com.maesaka.crudapi.controller.response.CatResponse;
import com.maesaka.crudapi.entity.Cat;
import com.maesaka.crudapi.exception.ResourceNotFoundException;
import com.maesaka.crudapi.service.CatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return catService.findAll();
    }

    @GetMapping("/cats/{id}")
    public CatResponse findCatId(@PathVariable("id") int id) {
        Cat cat = catService.findCatId(id);
        return new CatResponse(cat);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/cats")
    public ResponseEntity<Map<String, String>> createGuest(@RequestBody CatCreateForm catCreateForm, UriComponentsBuilder uriBuilder) {
        Cat cat = catService.createCat(catCreateForm.convertToCat());
        URI url = uriBuilder
                .path("/cats/" + cat.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "successfully created"));
    }

    @PatchMapping("/cats/{id}")
    public ResponseEntity<Map<String, String>> updateCat(@PathVariable("id") int id, @RequestBody @Validated CatUpdateForm catUpdateForm) {
        catService.updateCat(id, catUpdateForm.getName(), catUpdateForm.getAge(), catUpdateForm.getFavoriteSnack());
        return ResponseEntity.ok(Map.of("message", "successfully updated"));
    }

    @DeleteMapping("/cats/{id}")
    public ResponseEntity<Map<String, String>> deleteCat(@PathVariable("id") int id) {
        catService.deleteCat(id);
        return ResponseEntity.ok(Map.of("message", "successfully deleted"));
    }
}
