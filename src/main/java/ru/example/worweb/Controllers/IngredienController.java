package ru.example.worweb.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.worweb.Controllers.Services.IngredientService;
import ru.example.worweb.Controllers.Services.Model.Ingredient;

@RequestMapping("ingredien")
@RestController
class IngredienController {
    private IngredientService ingredientService;

    public void IngredienController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;

    }
    @PostMapping
    public ResponseEntity createIngredien(@RequestBody @NotNull IngredientService ingredientService) {
        Ingredient createIngredien = ingredientService.createIngredient(ingredientService);
        return ResponseEntity.ok(createIngredien);
    }

    @GetMapping("{ingredienId}")
    public ResponseEntity getIngredien(@PathVariable Long ingredienId) {
        IngredientService ingredient = ingredientService.getIngredientById(ingredienId);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredientService);
    }

    @PutMapping()
    public ResponseEntity updateIngredien(@RequestBody IngredientService ingredientService) {
        IngredientService updatedIngredient = ingredientService.updateIngredient(ingredientService.getIdIngredient(), ingredientService);
        return ResponseEntity.ok(updatedIngredient);
    }

    @GetMapping("/api/ingredient/{id}/{name}")
    @ResponseBody
    public String IngredienController(@PathVariable String idIngredient, @PathVariable String nameIngredien) {
        return "ID: " + idIngredient + ", name: " + nameIngredien;
    }
}