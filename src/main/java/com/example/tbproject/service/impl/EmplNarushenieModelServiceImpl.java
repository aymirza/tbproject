package com.example.tbproject.service.impl;

import com.example.tbproject.model.EmployeeNarushenieModel;
import com.example.tbproject.repository.EmplNarushenieModelRepository;
import com.example.tbproject.service.EmplNarushenieModelService;
import com.example.tbproject.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EmplNarushenieModelServiceImpl implements EmplNarushenieModelService {
    @Autowired
    private EmplNarushenieModelRepository emplNarushenieModelRepository;

    @Override
    public List<EmployeeNarushenieModel> getAllNarushenieModel() {
        return emplNarushenieModelRepository.findAll();
    }

    @Override
    public String createEmplNarushenieModel(
            String lastname, String firstname, String uchastka,
            String tsex_uchastka, String pravila, String narushenie,
            MultipartFile file) throws IOException {
        byte[] imageData = ImageUtils.compressImage(file.getBytes());
        EmployeeNarushenieModel employeeNarushenieModel1 = new EmployeeNarushenieModel();
        employeeNarushenieModel1.setLastname(lastname);
        employeeNarushenieModel1.setFirstname(firstname);
        employeeNarushenieModel1.setUchastka(uchastka);
        employeeNarushenieModel1.setTsex_uchastka(tsex_uchastka);
        employeeNarushenieModel1.setPravila(pravila);
        employeeNarushenieModel1.setNarushenie(narushenie);
        employeeNarushenieModel1.setImage(imageData);
        emplNarushenieModelRepository.save(employeeNarushenieModel1);
        if (employeeNarushenieModel1 != null){
            return "Saved narushenie: "+lastname+" "+firstname;
        }
        return null;

    }

    @Override
    public EmployeeNarushenieModel createEmplNarushenieModel(EmployeeNarushenieModel employeeNarushenieModel) throws IOException {
        return null;
    }

    @Override
    public EmployeeNarushenieModel getByIdEmplNarushenieModel(Long empl_narushenie_model_id) {
        Optional<EmployeeNarushenieModel> optionalEmployeeNarushenieModel = emplNarushenieModelRepository.findById(empl_narushenie_model_id);
        if (optionalEmployeeNarushenieModel.isPresent()) {
            return optionalEmployeeNarushenieModel.get();
        }
        return null;
    }

    @Override
    public void deleteEmplNarushenieModel(Long empl_narushenie_model_id) {
        emplNarushenieModelRepository.deleteById(empl_narushenie_model_id);
    }
}
