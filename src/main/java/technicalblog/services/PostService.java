package technicalblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {


    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPost(){
         return postRepository.getAllPost();
    }
    

    public Post getonePost(){
        return postRepository.getOnePost();

    }
    public void createPost (Post newPost){
        newPost.setDate(new Date());
        postRepository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

}
