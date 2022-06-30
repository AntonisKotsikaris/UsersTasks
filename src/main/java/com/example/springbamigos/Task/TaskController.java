package com.example.springbamigos.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping (path = "/Tasks")
public class TaskController {
    @Autowired
    private RepositTask UserRepository;

    @GetMapping("/{id}")
    public @ResponseBody Task getTask(@PathVariable Long id) {
        return UserRepository.getById(id);
    }


    @PostMapping ( path  = "/add")
    public @ResponseBody String addNewTask ( @RequestBody  Task objtask ) {
        UserRepository.save(objtask);
        return "Saved";
    }

    @PutMapping (path  = "/update")
    public @ResponseBody String updateTask ( @RequestBody  Task objtask ) {
        UserRepository.save(objtask);
        return "updated";
    }
    @DeleteMapping (path  = "/delete")
    public @ResponseBody String deleteTask ( @RequestBody Task objtask ) {
        UserRepository.delete(objtask);
        return "deleted";
    }
    @GetMapping("/appweb")
    public String showForm() {

        return "sample";
    }

    @GetMapping (path = "/all")
        public @ResponseBody Iterable <Task> getAllTasks(){
        return UserRepository.findAll();
    }



@GetMapping (path = "/usersTasks/{id}")
public @ResponseBody Iterable <Task> getUserTasks(@PathVariable Long id){

    Pageable taskPage = (Pageable) PageRequest.of(0, 50);

    Page<Task> tasksByUserId = UserRepository.findTasksByUserId(id, taskPage);

    return tasksByUserId;


    }


}