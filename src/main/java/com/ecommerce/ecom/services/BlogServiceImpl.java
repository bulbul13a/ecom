package com.ecommerce.ecom.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dbl.nsl.erp.config.FileUploadUtil;
import com.dbl.nsl.erp.exception.ResourceNotFoundException;
import com.dbl.nsl.erp.notice_board.NoticeBoard;
import com.dbl.nsl.erp.payload.response.MessageResponse;
import com.ecommerce.ecom.models.Blog;
import com.ecommerce.ecom.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
	public ResponseEntity<?> addBlog(Blog blog, List<MultipartFile> files) throws ResourceNotFoundException {
		try {
			Log.info("addNotice Service has been called.");
		
			final String uploadDir = BASE_UPLOAD_DIR.concat(SUFFIX);
			List<String> attachmentFiles = new ArrayList<>();
			for(MultipartFile file : files) {
				String attachment = null;
				try {
					attachment = SUFFIX + FileUploadUtil.saveFileWithNanoSec(noticReq.getUploaderId(), uploadDir, file);
					attachmentFiles.add(attachment);
				} catch (Exception e) {
					Log.info("No file attached with the leave request.");
				}
			}
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			noticReq.setUploadedTime((formatter.format(date)).split(" ")[1]);
			
			noticReq.setAttachmentFilePath(attachmentFiles);
			noticReq.setUploadedDate(new Date());
			
			NoticeBoard savedNotice = noticeBoardRepository.save(noticReq);
			
			return ResponseEntity.ok().body(savedNotice);
		} catch (Exception e) {
			Log.info("Excepton : " + e + " has occured.");
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body( new MessageResponse("Exception :" + e + " has occured"));
		}
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}
}
