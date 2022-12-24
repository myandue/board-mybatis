package com.example.boardmybatis.controller;

import com.example.boardmybatis.domain.Reply;
import com.example.boardmybatis.domain.User;
import com.example.boardmybatis.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;


    @GetMapping("/{id}")
    private String getAllReply(Model model,
                                    @PathVariable("id") int articleId){
        List<Reply> replyList = replyService.listAll(articleId);
        model.addAttribute("replies", replyList);
        System.out.println("replyList = " + replyList);
        return "reply-list";
    }


    @PostMapping("")
    private List<Reply> uploadReply(Model model,
                               @PathVariable("id") int articleId,
                               @RequestBody Reply reply,
                               @SessionAttribute(name="loginUser", required = false) User loginUser){
        if(loginUser==null){
        }
        reply.setArticleId(articleId);
        replyService.save(reply);
        return replyService.listAll(articleId);
    }



//    //Reply Register
//    @PostMapping("")
//    public ResponseEntity<String> register(@RequestBody Reply reply) {
//        System.out.println("post mapping reply = " + reply);
//        ResponseEntity<String> entity = null;
//        try {
//            replyService.save(reply);
//            entity = new ResponseEntity<String>("regSuccess", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//    }
//
//    //Reply List
//    @GetMapping("/all/{articleId}")
//    public ResponseEntity<List<Reply>> list(@PathVariable("articleId") int articleId) {
//        ResponseEntity<List<Reply>> entity = null;
//        try {
//            entity = new ResponseEntity<List<Reply>>(replyService.listAll(articleId), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//    }
//
//    //Reply Modify
//    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
//    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Reply reply) {
//        ResponseEntity<String> entity = null;
//        try {
//            reply.setId(id);
//            replyService.edit(reply);
//            entity = new ResponseEntity<String>("modSuccess", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//    }
//
//    //Reply Delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable("id") int id) {
//        ResponseEntity<String> entity = null;
//        try {
//            replyService.delete(id);
//            entity = new ResponseEntity<String>("delSuccess", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//    }
}
