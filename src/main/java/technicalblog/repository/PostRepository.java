package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;


    public List<Post> getAllPost() {


        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        List<Post> result = query.getResultList();
        return result;
    }

    public Post getOnePost() {


        EntityManager em = emf.createEntityManager();

        return em.find(Post.class,3);
    }
    
    public Post createPost(Post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transcation = em.getTransaction();
        try {
            transcation.begin();
            em.persist(newPost);
            transcation.commit();
        }catch (Exception e){
            transcation.rollback();
        }
        return newPost;
    }
}
