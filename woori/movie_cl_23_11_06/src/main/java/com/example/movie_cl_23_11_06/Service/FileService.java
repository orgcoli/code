package com.example.movie_cl_23_11_06.Service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] filedata)throws Exception{
        UUID uuid = UUID.randomUUID();
        String extension = originalFileName.substring(
                originalFileName.lastIndexOf(".")
        );
        String saveFileName = uuid.toString()+extension;
        String uploadFullUrl = uploadPath+saveFileName;

        FileOutputStream fos = new FileOutputStream(uploadFullUrl);
        fos.write(filedata);
        fos.close();

        return saveFileName;
    }

    public void deleteFile(String uploadPath, String fileName) throws Exception{
        String deleteFileName = uploadPath+fileName;

        File deleteFile = new File(deleteFileName);
        if(deleteFile.delete()){
            deleteFile.delete();
        }
    }
}
