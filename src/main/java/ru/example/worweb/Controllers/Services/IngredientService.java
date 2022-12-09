package ru.example.worweb.Controllers.Services;

import org.springframework.stereotype.Service;
import ru.example.worweb.Controllers.*;
import ru.example.worweb.Controllers.Services.Model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Service
public interface IngredientService {
    String getNameIngredient();
    int getNumberIngredients();
    String getUnit();

    Long getIdIngredient();

    Ingredient createIngredient(IngredientService ingredientService);

    IngredientService getIngredientById(Long ingredienId);

    IngredientService updateIngredient(Long idIngredient, IngredientService ingredientService);

    public class IngredientServices {
        private Map<Long, IngredientService> ingredientMap = new HashMap<>();
        private Long generatedIngredientId = 1L;

        public IngredientService createIngredient(IngredientService ingredientService) {
            ingredientMap. put(generatedIngredientId, ingredientService);
            generatedIngredientId++;
            return ingredientService;
        }

        public IngredientService getIngredientById(Long ingredientId) {
            return ingredientMap.get(ingredientId);
        }
        public IngredientService updateIngredient(Long ingredientId, IngredientService ingredientService) {
            ingredientMap.put(ingredientId, ingredientService);

            return ingredientService;
        }

        public IngredientService deleteIngredient(Long ingredientId) {
            return ingredientMap.remove(ingredientId);
        }
    }
}
