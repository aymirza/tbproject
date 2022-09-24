package com.example.tbproject.controller;

import com.example.tbproject.model.*;
import com.example.tbproject.service.EmplNarushenieModelService;
import com.example.tbproject.service.NarushenieListService;
import com.example.tbproject.service.PravilaListService;
import com.example.tbproject.service.TsexUchastkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/emplnaruhsenie")
public class NarushenieController {

    @Autowired
    private EmplNarushenieModelService emplNarushenieModelService;
    @Autowired
    private TsexUchastkiService tsexUchastkiService;
    @Autowired
    private PravilaListService pravilaListService;
    @Autowired
    private NarushenieListService narushenieListService;


    @GetMapping
    public ResponseEntity<List<EmployeeNarushenieModel>> getAllEmplNarushenieModel(){
        return new ResponseEntity<>(emplNarushenieModelService.getAllNarushenieModel(),HttpStatus.OK);
    }

    @GetMapping("/empl_narushenie_model_id")
    public ResponseEntity<EmployeeNarushenieModel> getByIdEmplNarushenie(@PathVariable(value = "{empl_narushenie_model_id}") Long empl_narushenie_model_id){
        return new ResponseEntity<>(emplNarushenieModelService.getByIdEmplNarushenieModel(empl_narushenie_model_id),HttpStatus.OK);
    }

    @PostMapping("/create-empl-naruhsenie")
    public ResponseEntity<?> createEmplNarushenieModel(
            @RequestParam("lastname") String lastname, @RequestParam("firstname") String firstname,
            @RequestParam("uchastka") String uchastka, @RequestParam("tsex_uchastka") String tsex_uchastka,
            @RequestParam("pravila") String pravila, @RequestParam("narushenie") String narushenie,
            @RequestParam("image") MultipartFile file) throws IOException {
        String emplNarushenie = emplNarushenieModelService.createEmplNarushenieModel(
                lastname,firstname,uchastka,tsex_uchastka,pravila,narushenie,file);
        return ResponseEntity.status(HttpStatus.CREATED).body(emplNarushenie);
    }

    @DeleteMapping("delete-empl-narushenie/{empl_narushenie_model_id}")
    public void deleteEmplNarusheniModel(@PathVariable Long empl_narushenie_model_id){
        emplNarushenieModelService.deleteEmplNarushenieModel(empl_narushenie_model_id);
    }

    @GetMapping("/tsexuchastka")
    public ResponseEntity<List<TsexUchastkiList>> getAllTsexUchastki(){
        return new ResponseEntity<>(tsexUchastkiService.getAllTsexUchastkiList(),HttpStatus.OK);
    }
    @GetMapping("/pravila")
    public ResponseEntity<List<PravilaList>> getAllPravila(){
        return new ResponseEntity<>(pravilaListService.getAllPravilaList(),HttpStatus.OK);
    }
    @GetMapping("/narushenie")
    public ResponseEntity<List<NarushenieList>> getAllNarusheni(){
        return new ResponseEntity<>(narushenieListService.getAllNarusheniList(),HttpStatus.OK);
    }

}
