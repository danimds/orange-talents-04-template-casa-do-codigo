package br.com.zupacademy.dani.casadocodigo.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private String targetAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(Unique unique) {
        targetAttribute = unique.fieldName();
        klass = unique.targetClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select k from " + klass.getName() + " k where " + targetAttribute + "=:pValue");
        query.setParameter("pValue", value);

        List<?> list = query.getResultList();
        return list.size() == 0;
    }
}