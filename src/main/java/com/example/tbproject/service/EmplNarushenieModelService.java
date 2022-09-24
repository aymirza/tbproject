package com.example.tbproject.service;

import com.example.tbproject.model.EmployeeNarushenieModel;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface EmplNarushenieModelService {
    String createEmplNarushenieModel(
            String lastname, String firstname, String uchastka,
            String tsex_uchastka, String pravila, String narushenie,
            MultipartFile file) throws IOException;

    EmployeeNarushenieModel createEmplNarushenieModel(EmployeeNarushenieModel employeeNarushenieModel) throws IOException;
    EmployeeNarushenieModel getByIdEmplNarushenieModel(Long empl_narushenie_model_id);
    List<EmployeeNarushenieModel> getAllNarushenieModel();
    void deleteEmplNarushenieModel(Long empl_narushenie_model_id);

}
