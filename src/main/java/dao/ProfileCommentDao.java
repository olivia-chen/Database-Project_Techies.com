
package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
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

}
