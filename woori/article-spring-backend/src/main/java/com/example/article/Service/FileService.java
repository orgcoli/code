package com.example.article.Service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

//파일업로드와 삭제를 처리하는 클래스(Controller에 만들어서 사용가능)

@Service
public class FileService {
    //파일 업로드
    //저장위치, 파일명, 파일데이터
    //text는 ASCII코드로 전달, 그외 파일은 byte(2진수)방식
    //sample.jpg -> era3war65s4fda(난수로 파일명생성)->.jpg 분리
    //era3war65s4fda.jpg (재조립) -> 하드의 저장
    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData)throws Exception{
        //저장시 동일한 파일이름에 의해서 덮어쓰기가 되는 것을 방지
        UUID uuid = UUID.randomUUID(); //임의의 문자열(새로운 파일명)   era3war65s4fda
        //substring 지정한 문자까지 추출, lastIndexOf 뒤에서 부터 지정한 문자의 위치
        //sample.jpg=> .jpg
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        //실질적으로 저장할 파일명 만들기 era3war65s4fda.jpg
        String saveFileName = uuid.toString()+extension;
        //저장할 위치와 파일을 합쳐서 작업파일을 만들기
        String fileUploadFullUrl = uploadPath+saveFileName; //c:/image/item/era3war65s4fda.jpg

        //파일저장
        //입력한 파일명 그대로 저장
        //FileOutputStream fos =new FileOutputStream(uploadPath+originalFileName);
        //임의의 파일명으로 저장
        FileOutputStream fos =new FileOutputStream(fileUploadFullUrl);  //지정된 위치의 이름으로 저장(쓰기)
        fos.write(fileData);  //읽어온 바이트를 하드에 쓰기
        fos.close();    //쓰기종료

        return saveFileName;
    }

    //이미지를 변경할 경우 (기존 이미지를 삭제)하고 새로운파일을 저장
    //파일 삭제
    public void deleteFile(String filePath)throws Exception{
        File deleteFile = new File(filePath);
        if(deleteFile.exists()){    //지정한 위치에 파일이 있으면
            deleteFile.delete();    //파일삭제
        }
    }
}

//하드디스크에 저장할 폴더, 이미지 등을 준비