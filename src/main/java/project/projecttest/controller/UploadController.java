//package project.projecttest.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.UUID;
//
//@RestController
//public class UploadController {
//
//    @Value("${com.example.upload.path}") // application.properties의 변수
//    private String uploadPath;
//
//    @PostMapping("/uploadAjax")
//    public void uploadFile(MultipartFile[] uploadFiles){
//
//        for (MultipartFile uploadFile : uploadFiles) {
//
//            // 이미지 파일만 업로드 가능
//            if(uploadFile.getContentType().startsWith("image") == false){
//                return;
//            }
//
//            // 실제 파일 이름 IE나 Edge는 전체 경로가 들어오므로
//            String originalName = uploadFile.getOriginalFilename();
//
//            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
//
//            // 날짜 폴더 생성
//            String folderPath = makeFolder();
//
//            //UUID
//            String uuid = UUID.randomUUID().toString();
//
//            //저장할 파일 이름 중간에 "_"를 이용해 구분
//            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
//
//            Path savePath = Paths.get(saveName);
//
//            try {
//                uploadFile.transferTo(savePath);
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private String makeFolder() {
//
//        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//
//        String folderPath = str.replace("/", File.separator);
//
//        // make folder ----
//        File uploadPatheFolder = new File(uploadPath,folderPath);
//
//        if(uploadPatheFolder.exists() == false){
//            uploadPatheFolder.mkdirs();
//        }
//
//        return folderPath;
//    }
//}
