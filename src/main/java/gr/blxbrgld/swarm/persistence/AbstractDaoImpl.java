package gr.blxbrgld.swarm.persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;

/**
 * AbstractDao Implementation
 * @author blxbrgld
 */
public class AbstractDaoImpl<T extends Object>  implements AbstractDao<T>{

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> domainClass;

    /**
     * Get Hibernate Session
     * @return Session
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * Get Domain Class
     * @return Domain Class
     */
    private Class<T> getDomainClass(){
        if (domainClass == null){
            ParameterizedType thisType = (ParameterizedType)getClass().getGenericSuperclass();
            this.domainClass = (Class<T>)thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    /**
     * Get Domain Class Name
     * @return Domain Class Name
     */
    private String getDomainClassName(){
        return getDomainClass().getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(Serializable id) {
        return (T)getSession().get(getDomainClass(),id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T load(Serializable id) {
        return (T)getSession().load(getDomainClass(), id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> getAll() {
        return getSession().createQuery("from " + getDomainClassName()).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T persistOrMerge(T t) {
        Method method = ReflectionUtils.findMethod(getDomainClass(), "getId");
        if(method !=null){
            try {
                Serializable id = (Serializable) method.invoke(t);
                if(id == null || count(id)==0) { //IDs May Be Long or String
                    persist(t);
                    return t;
                } else {
                    merge(t);
                    return t;
                }
            } catch (Exception exception) {
                LOGGER.error("Exception", exception);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void persist(T t) {
        setDateUpdated(t);
        getSession().persist(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void merge(T t) {
        setDateUpdated(t);
        getSession().merge(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Serializable id) {
        delete(load(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAll() {
        getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return (Long) getSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count(Serializable id) {
        Query query = getSession().createQuery("select count(*) from " + getDomainClassName() + " where id=:id");
        query.setParameter("id", id);
        return (Long) query.uniqueResult();
    }

    /**
     * Invoke setDateUpdated() Method Of The Given Object In Order To Set This Property
     * @param t Object
     */
    private void setDateUpdated(T t) {
        Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateUpdated", new Class[]{Calendar.class});
        if(method!=null) {
            try {
                method.invoke(t, Calendar.getInstance());
            } catch (Exception exception) {
                LOGGER.error("Exception", exception);
            }
        }
    }
}
