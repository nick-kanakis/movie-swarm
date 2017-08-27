package gr.blxbrgld.swarm.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * AbstractDao Interface
 * @author blxbrgld
 */
public interface AbstractDao<T extends Object> {

    /**
     * Get An Object By A Given Id
     * @param id Object's Id
     * @return Object Or null If The Object Does Not Exist
     */
    T get(Serializable id);

    /**
     * Load An Object By A Given Id
     * @param id Object's Id
     * @return If The Object Does Not Exist It Will Throw A ObjectNotFoundException
     */
    T load(Serializable id);

    /**
     * Get All Objects
     * @return List Of Objects
     */
    List<T> getAll();

    /**
     * If Given Object's Id Is null Persist The Object, Otherwise Merge It
     * @param t Object
     */
    T persistOrMerge(T t);

    /**
     * Persist The Given Object
     * @param t Object
     */
    void persist(T t);

    /**
     * Persist The Given Object
     * @param t Object
     */
    void merge(T t);

    /**
     * Delete The Given Object
     * @param t Object
     */
    void delete(T t);

    /**
     * Delete An Object By A Given Id
     * @param id Object's Id
     */
    void deleteById(Serializable id);

    /**
     * Delete All Objects
     */
    void deleteAll();

    /**
     * Get The Count Of The Existing Objects
     * @return The Count Of The Existing Objects
     */
    Long count();

    /**
     * Get The Count Of The Existing Object With The Given Id
     * @param id Object's Id
     * @return The Count Of The Existing Objects,Zero If The Object Does Not Exists
     */
    Long count(Serializable id);
}
