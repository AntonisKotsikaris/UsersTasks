package com.example.springbamigos.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping (path = "/Categories" )
public class CategoryController {
    @Autowired
    private RepositCategory CatRepository;

    @PostMapping ( path  = "/addCategory")
    public @ResponseBody String addNewCategory (@RequestBody Category category) {
        CatRepository.save(category);
        return"saved categorie";
    }

    @PutMapping (path  = "/update")
    public @ResponseBody String updateCategory ( @RequestBody Category category ) {
        CatRepository.save(category);
        return "updated";
    }

    @DeleteMapping (path  = "/delete")
    public @ResponseBody String deleteCategory ( @RequestBody Category category ) {
        CatRepository.delete(category);
        return "deleted";
    }

    @GetMapping (path = "/allCategories")
    public @ResponseBody Iterable <Category> getAllCateogies(){
        return CatRepository.findAll();
    }
}


