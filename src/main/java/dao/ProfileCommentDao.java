
package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import models.Comment;
import models.Post;
import models.Profile;
import models.ProfileComment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProfileCommentDao {
    @Inject
    Provider<EntityManager> EntityManagerProvider;

    @Transactional
    public List<ProfileComment> getCommentsFromProfile(Profile profile) {
        EntityManager em = EntityManagerProvider.get();

        List<ProfileComment> comments = new ArrayList<>();
        String strQuery = "SELECT x FROM ProfileComment x WHERE profile_id = :profileid ORDER BY timestamp DESC";
        Query q = em.createQuery(strQuery);
        q.setParameter("profileid", profile.getId());
        comments = (List<ProfileComment>) q.getResultList();

        return comments;
    }

   /* @Transactional
    public List<Comment> getCommentsBySearchresult(Post post){

            EntityManager em = EntityManagerProvider.get();
            // Get all comments from post
            // --------------------------
            // Create a query for comments by post IDs, the result should be something like
            // "SELECT * FROM Comment WHERE post_id IN ('8', '7', '3', '2', '1', '6')"
            //

            List<Comment> comments = new ArrayList<Comment>();
            String strQuery = "SELECT x FROM Comment x WHERE post_id IN (";

                strQuery += "'" + post.getId().toString() + "'";



            strQuery += ") ORDER BY timestamp DESC";

            Query q = em.createQuery(strQuery);
            comments = (List<Comment>) q.getResultList();

            return comments;

    }*/
}
