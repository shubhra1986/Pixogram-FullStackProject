package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UploadMedia;
import com.example.demo.service.UploadMediaService;


@RestController
public class UploadMediaController {

	@Autowired
	UploadMediaService uploadMediaService;
	
	@GetMapping("/media/uid/{userId}")
	 public List<UploadMedia> getAllUserMedia(@PathVariable int userId){	 
		 return uploadMediaService.getMediaByUid(userId);
	 }
	 @GetMapping("/media/id/{userId}")
	 public Optional<UploadMedia> getUserMedia(@PathVariable int userId)  {	 
		 return uploadMediaService.getMediaById(userId);
	 }
	
	@PostMapping("/media/create/{userId}/{userName}")
	public UploadMedia createMedia(@RequestBody UploadMedia media,@PathVariable int userId, @PathVariable String userName) {
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
         String strDate = dateFormat.format(date); 
		
		UploadMedia uploadMedia=new UploadMedia(userId, media.getTitle(), media.getDescription(), media.getTags(), media.getUrl(),strDate,userName,0);
		uploadMediaService.createMedia(uploadMedia);
		return uploadMedia;
     }
	
	 @PutMapping("/media/like/{id}/{flag}")
	 public UploadMedia updateLike(@PathVariable int id, @PathVariable int flag) {
		 Optional<UploadMedia> um = uploadMediaService.getMediaById(id);
		 UploadMedia upmedia = um.get();
		 if(flag==1) {
		 upmedia.setLikes((upmedia.getLikes())+1);}
		 else {
			 upmedia.setLikes((upmedia.getLikes())-1);
		 }
		 uploadMediaService.createMedia(upmedia);
		 return upmedia;
	 }
	 
 
	
}