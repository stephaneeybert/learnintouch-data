package com.thalasoft.learnintouch.data.jpa;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public class AuditLogInterceptor extends EmptyInterceptor {

    private static Logger logger = LoggerFactory.getLogger(AuditLogInterceptor.class);

    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        logger.debug("AuditLog interceptor - The entity was deleted");
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof UserAccount) {
            logger.debug("AuditLog interceptor - The user account was flushed");
            return true;
        }
        return false;
    }

    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        logger.debug("AuditLog interceptor - The entity was loaded");
        return true;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof UserAccount) {
            logger.debug("AuditLog interceptor - The user account was saved");
            return true;
        }
        return false;
    }

    public void preFlush(Iterator iterator) {
        logger.debug("AuditLog interceptor - Before commiting");
    }

    public void postFlush(Iterator iterator) {
        logger.debug("AuditLog interceptor - After commiting");
    }

}
