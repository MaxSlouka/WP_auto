package auto.backe.auto_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

@Controller
public class FileController {

    @GetMapping("/upload-form")
    public String showUploadForm() {
        return "index";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "upload";
        }

        model.addAttribute("message", "File uploaded successfully: " + file.getOriginalFilename());
        return "upload";
    }
}
